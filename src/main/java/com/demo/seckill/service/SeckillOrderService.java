package com.demo.seckill.service;

import com.demo.seckill.dao.SeckillOrderDao;
import com.demo.seckill.model.SeckillOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SeckillOrderService {

    @Autowired
    SeckillOrderDao seckillOrderDao;

    public SeckillOrder findSeckillOrderByUserIdAndGoodsId(long userId, long goodsId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        param.put("goodsId", goodsId);
        SeckillOrder seckillOrder = seckillOrderDao.findSeckillOrderByUserIdAndGoodsId(param);
        return seckillOrder;
    }

    public void insertSeckillOrder(SeckillOrder seckillOrder) {
        seckillOrderDao.insertSeckillOrder(seckillOrder);
    }
}
