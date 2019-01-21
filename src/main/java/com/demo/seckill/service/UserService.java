package com.demo.seckill.service;

import com.demo.seckill.dao.UserDao;
import com.demo.seckill.exception.GlobalException;
import com.demo.seckill.model.User;
import com.demo.seckill.redis.keys.impl.UserKey;
import com.demo.seckill.redis.service.RedisService;
import com.demo.seckill.result.CodeMsg;
import com.demo.seckill.utils.MD5Util;
import com.demo.seckill.utils.UUIDUtil;
import com.demo.seckill.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserService {

    public static final String COOKIE_NAME_TOKEN = "token";

    @Autowired
    public UserDao userDao;

    @Autowired
    RedisService redisService;

    public User findById(long id){
        return userDao.findById(id);
    }

    public boolean login(HttpServletResponse response, LoginVo loginVo){
        if(loginVo == null){
//            return CodeMsg.SERVER_ERROR;
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }

        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        User user = findById(Long.valueOf(mobile));
        if(user == null){
//            return CodeMsg.MOBILE_NOT_EXIST;
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(formPass, saltDB);
        if (!calcPass.equals(dbPass)) {
//            return CodeMsg.PASSWORD_ERROR;
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
//        return CodeMsg.SUCCESS;

        //生成cookie
        String token = UUIDUtil.uuid();
        redisService.set(UserKey.token, token, user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(UserKey.token.expireSecond());
        cookie.setPath("/");
        response.addCookie(cookie);
        return true;
    }


    public User getByToken(String token) {
        if(StringUtils.isEmpty(token)){
            return null;
        }
        return redisService.get(UserKey.token, token, User.class);
    }
}
