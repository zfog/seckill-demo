package com.demo.seckill.controller;

import com.demo.seckill.model.User;
import com.demo.seckill.redis.config.RedisConfig;
import com.demo.seckill.redis.keys.impl.UserKey;
import com.demo.seckill.redis.service.RedisService;
import com.demo.seckill.result.CodeMsg;
import com.demo.seckill.result.Result;
import com.demo.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableConfigurationProperties({RedisConfig.class})
public class SecKillDemoTest {
    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @GetMapping("/hello")
    public Result<String> hello() {
        return Result.success("hello");
    }

    @GetMapping("/helloError")
    public Result<String> helloError() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "thymeleaf");
        return "helloThymeleaf";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("name", "seckill");
        return "test";
    }

    @RequestMapping("/dbGet/{id}")
    @ResponseBody
    public Result<User> dbGet(@PathVariable("id") int id) {
        User user = userService.findById(id);
        return Result.success(user);
    }

    @RequestMapping("/dbInsert/{name}")
    @ResponseBody
    public Result<Integer> dbInsert(@PathVariable("name") String name) {
//        User user = new User();
//        user.setName(name);
//        int result = userService.insertUser(user);
//        return Result.success(result);
        return null;
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet() {
//        User user = new User();
//        user.setId(1);
//        user.setName("test1");
//        boolean b = redisService.set(UserKey.getById, String.valueOf(1), user);
//        return Result.success(b);
        return null;
    }

//    @RequestMapping("/redis/get")
//    @ResponseBody
//    public Result<String> redisGet() {
//        String str = redisService.get(UserKey.getById, "" + 1, String.class);
//        return Result.success(str);
//    }
}
