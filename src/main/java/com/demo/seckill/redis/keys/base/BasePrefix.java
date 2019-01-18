package com.demo.seckill.redis.keys.base;

public abstract class BasePrefix implements KeyPrefix {

    private int expireSeconds;

    private String attribute;

    /**
     * 默认0永不过期
     *
     * @return
     */

    public BasePrefix(int expireSeconds, String attribute) {
        this.expireSeconds = expireSeconds;
        this.attribute = attribute;
    }

    public BasePrefix(String attribute) {//0永不过期
        this(0, attribute);
    }

    @Override
    public int expireSecond() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + "_" + attribute;
    }
}
