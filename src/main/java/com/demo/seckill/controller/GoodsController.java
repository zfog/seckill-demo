package com.demo.seckill.controller;

import com.demo.seckill.model.User;
import com.demo.seckill.redis.service.RedisService;
import com.demo.seckill.service.GoodsService;
import com.demo.seckill.service.UserService;
import com.demo.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;

    /*@RequestMapping("/to_list")
    public String toList(HttpServletResponse response, Model model, @CookieValue(value = UserService.COOKIE_NAME_TOKEN, required = false) String cookieToken,
                         @RequestParam(value = UserService.COOKIE_NAME_TOKEN, required = false) String paramToken) {
        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            return "login";
        }
        String token = StringUtils.isEmpty(paramToken)?cookieToken:paramToken;
        User user = userService.getByToken(response, token);
        model.addAttribute("user", user);
        return "goods_list";
    }*/

    /**
     * toList()方法的改进版，将获取user对象的处理逻辑放在了UserArgumentResolver中，这里直接注入user即可获得
     * 通过实现WebMvcConfigurer接口实现
     *
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/to_list")
    public String toListUpgrade(Model model, User user) {
        model.addAttribute("user", user);
        return "goods_list";
    }

    @RequestMapping("to_goods_list")
    public String toGoodsList(Model model, User user) {
        //查询商品列表
        List<GoodsVo> goodsList = goodsService.findGoodsVoList();
        model.addAttribute("goodsList", goodsList);
        return "goods_list";
    }

    @RequestMapping("/to_detail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable("goodsId") Long goodsId) {
        model.addAttribute("user", user);
        GoodsVo goodsVo = goodsService.findGoodsVoById(goodsId);
        model.addAttribute("goods", goodsVo);
        long startAt = goodsVo.getStartDate().getTime();
        long endAt = goodsVo.getEndDate().getTime();
        long now = System.currentTimeMillis();

        int seckillStatus = 0;
        int remainSeconds = 0;
        if (now < startAt) {//秒杀还没开始，倒计时
            seckillStatus = 0;
            remainSeconds = (int) ((startAt - now) / 1000);
        } else if (now > endAt) {//秒杀结束
            seckillStatus = 2;
            remainSeconds = -1;
        } else {//秒杀进行中
            seckillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("seckillStatus", seckillStatus);
        model.addAttribute("remainSeconds", remainSeconds);
        return "goods_detail";
    }


}
