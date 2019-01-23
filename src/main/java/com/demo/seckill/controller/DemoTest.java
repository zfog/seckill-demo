package com.demo.seckill.controller;

import com.demo.seckill.model.User;
import com.demo.seckill.redis.config.RedisConfig;
import com.demo.seckill.redis.service.RedisService;
import com.demo.seckill.result.CodeMsg;
import com.demo.seckill.result.Result;
import com.demo.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoTest {
    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public Result<User> userInfo(Model model, User user){
        return Result.success(user);
    }

}
