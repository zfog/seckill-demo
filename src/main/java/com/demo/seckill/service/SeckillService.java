package com.demo.seckill.service;

import com.demo.seckill.model.Goods;
import com.demo.seckill.model.Order;
import com.demo.seckill.model.User;
import com.demo.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeckillService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    SeckillGoodsService seckillGoodsService;

    @Autowired
    OrderService orderService;

    @Transactional
    public Order seckill(User user, GoodsVo goodsVo) {
        //减少库存
        seckillGoodsService.reduceStock(goodsVo);
        //下订单 写入秒杀订单
        return orderService.createOrder(user, goodsVo);
    }
}
