package com.demo.seckill.controller;

import com.demo.seckill.redis.config.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({RedisConfig.class})
public class SecKillDemoTest {
    @Autowired
    public RedisConfig redisConfig;

    @GetMapping("/demotest/hello")
    public void hellotest(){
        System.out.println("hello");
    }

    @GetMapping("/demotest/config")
    public void printConfig(){
        System.out.println("redisConfig:"+redisConfig.getPoolMaxIdle());
    }
}
