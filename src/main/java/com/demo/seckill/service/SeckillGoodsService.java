package com.demo.seckill.service;

import com.demo.seckill.dao.SeckillGoodsDao;
import com.demo.seckill.model.Goods;
import com.demo.seckill.model.SeckillGoods;
import com.demo.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillGoodsService {

    @Autowired
    SeckillGoodsDao seckillGoodsDao;

    public void reduceStock(GoodsVo goodsVo) {
        SeckillGoods seckillGoods = new SeckillGoods();
        seckillGoods.setGoodsId(goodsVo.getId());
        seckillGoodsDao.reduce(seckillGoods);
    }
}
