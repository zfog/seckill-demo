package com.demo.seckill.redis.keys.impl;

import com.demo.seckill.redis.keys.base.BasePrefix;

public class GoodsKey extends BasePrefix {


    private GoodsKey(int expireSeconds, String prefix){
        super(expireSeconds, prefix);
    }

    public static GoodsKey getGoodsList = new GoodsKey(30,"gl");
    public static GoodsKey getGoodsDetail = new GoodsKey(30,"gd");
}
