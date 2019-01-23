package com.demo.seckill.service;

import com.demo.seckill.dao.OrderDao;
import com.demo.seckill.enums.OrderEnum;
import com.demo.seckill.model.Order;
import com.demo.seckill.model.SeckillOrder;
import com.demo.seckill.model.User;
import com.demo.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    SeckillOrderService seckillOrderService;

    @Transactional
    public Order createOrder(User user, GoodsVo goodsVo) {
        Order order = new Order();
        order.setCreateDate(new Date());
        order.setDeliveryAddrId(0L);
        order.setGoodsCount(1);
        order.setGoodsId(goodsVo.getId());
        order.setGoodsName(goodsVo.getGoodsName());
        order.setGoodsPrice(goodsVo.getSeckillPrice());
        order.setOrderChannel(1);
        order.setStatus(OrderEnum.NEW.getValue());
        long orderId = orderDao.insertOrder(order);
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setGoodsId(goodsVo.getId());
        seckillOrder.setOrderId(orderId);
        seckillOrder.setUserId(user.getId());
        seckillOrderService.insertSeckillOrder(seckillOrder);
        return order;
    }

}
