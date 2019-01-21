package com.demo.seckill.controller;

import com.demo.seckill.redis.keys.impl.UserKey;
import com.demo.seckill.redis.service.RedisService;
import com.demo.seckill.service.UserService;
import com.demo.seckill.model.User;
import com.demo.seckill.result.CodeMsg;
import com.demo.seckill.result.Result;
import com.demo.seckill.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/seckill")
public class SecKillDemoController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    public User findById(Integer id){
        return userService.findById(id);
    }

//    public CodeMsg login(LoginVo loginVo){
//        if(loginVo == null){
//            return CodeMsg.SERVER_ERROR;
//        }
//        String mobile = loginVo.getMobile();
//        String password = loginVo.getPassword();
//        User user = findById(Integer.valueOf(mobile));
//        if(user == null){
//            return CodeMsg.MOBILE_NOT_EXIST;
//        }
//    }

//    @RequestMapping("/redis/get")
//    @ResponseBody
//    public Result<String> redisGet() {
//        String str = redisService.get(UserKey.getById, "" + 1, String.class);
//        return Result.success(str);
//    }

}
