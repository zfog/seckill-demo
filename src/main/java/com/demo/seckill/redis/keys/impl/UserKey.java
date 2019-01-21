package com.demo.seckill.redis.keys.impl;

import com.demo.seckill.redis.keys.base.BasePrefix;

public class UserKey extends BasePrefix {

    public static final int TOKEN_EXPIRE = 3600 * 24 * 2;

    private UserKey(int expireSeconds, String prefix){
        super(expireSeconds, prefix);
    }

//    public static UserKey getById = new UserKey("id");
//
//    public static UserKey getByName = new UserKey("name");

    public static UserKey token = new UserKey(TOKEN_EXPIRE,"token");
}
