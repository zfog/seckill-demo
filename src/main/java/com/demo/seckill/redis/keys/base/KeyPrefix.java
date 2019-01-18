package com.demo.seckill.redis.keys.base;

public interface KeyPrefix {

    int expireSecond();

    String getPrefix();
}
