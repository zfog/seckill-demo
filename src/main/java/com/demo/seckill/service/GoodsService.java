package com.demo.seckill.service;

import com.demo.seckill.dao.GoodsDao;
import com.demo.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsDao goodsDao;

    public List<GoodsVo> findGoodsVoList(){
        return goodsDao.findGoodsVoList();
    }

    public GoodsVo findGoodsVoById(Long goodsId) {
        return goodsDao.findGoodsVoById(goodsId);
    }
}
