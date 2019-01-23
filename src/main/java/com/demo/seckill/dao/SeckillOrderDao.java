package com.demo.seckill.dao;

import com.demo.seckill.model.SeckillOrder;

import java.util.Map;

public interface SeckillOrderDao {


    SeckillOrder findSeckillOrderByUserIdAndGoodsId(Map<String, Object> param);

    void insertSeckillOrder(SeckillOrder seckillOrder);
}
