package com.demo.seckill.redis.keys.impl;

import com.demo.seckill.redis.keys.base.BasePrefix;

public class UserKey extends BasePrefix {

    private UserKey(String prefix){
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");

    public static UserKey getByName = new UserKey("name");
}
