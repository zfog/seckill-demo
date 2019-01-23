package com.demo.seckill.controller;

import com.demo.seckill.model.Order;
import com.demo.seckill.model.SeckillOrder;
import com.demo.seckill.model.User;
import com.demo.seckill.result.CodeMsg;
import com.demo.seckill.service.GoodsService;
import com.demo.seckill.service.OrderService;
import com.demo.seckill.service.SeckillOrderService;
import com.demo.seckill.service.SeckillService;
import com.demo.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/secondkill")
public class SecondKillController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    SeckillOrderService seckillOrderService;

    @Autowired
    SeckillService seckillService;

    @RequestMapping("/do_seckill")
    public String list(Model model, User user, @RequestParam("goodsId")long goodsId){
        model.addAttribute("user", user);
        if(user == null){
            return "login";
        }
        //判断库存
        GoodsVo goodsVo = goodsService.findGoodsVoById(goodsId);
        int stock = goodsVo.getGoodsStock();
        if(stock <= 0){
            model.addAttribute("errmsg", CodeMsg.SOLD_OUT.getMsg());
            return "seckill_fail";
        }
        //判断是否秒杀到了商品
        SeckillOrder seckillOrder = seckillOrderService.findSeckillOrderByUserIdAndGoodsId(user.getId(), goodsId);
        if(seckillOrder != null){
            model.addAttribute("errmsg", CodeMsg.REPEATABLE_SECKILL.getMsg());
            return "seckill_fail";
        }
        //减库存 下订单 写入秒杀订单
        Order order = seckillService.seckill(user, goodsVo);
        model.addAttribute("order", order);
        model.addAttribute("goods", goodsVo);
        return "order_detail";
    }
}
