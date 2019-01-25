package com.demo.seckill.vo;

import com.demo.seckill.model.User;

public class GoodsDetailVo {
    private int seckillStatus;
    private int remainSeconds;
    private GoodsVo goodsVo;
    private User user;

    public int getSeckillStatus() {
        return seckillStatus;
    }

    public void setSeckillStatus(int seckillStatus) {
        this.seckillStatus = seckillStatus;
    }

    public int getRemainSeconds() {
        return remainSeconds;
    }

    public void setRemainSeconds(int remainSeconds) {
        this.remainSeconds = remainSeconds;
    }

    public GoodsVo getGoodsVo() {
        return goodsVo;
    }

    public void setGoodsVo(GoodsVo goodsVo) {
        this.goodsVo = goodsVo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
