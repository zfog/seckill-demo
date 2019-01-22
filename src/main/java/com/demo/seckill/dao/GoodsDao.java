package com.demo.seckill.dao;

import com.demo.seckill.vo.GoodsVo;

import java.util.List;

public interface GoodsDao {

    List<GoodsVo> findGoodsVoList();

    GoodsVo findGoodsVoById(Long goodsId);
}