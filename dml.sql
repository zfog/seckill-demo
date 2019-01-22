--t_goods
INSERT INTO `t_goods`(`id`, `goods_name`, `goods_title`, `goods_img`, `goods_detail`, `goods_price`, `goods_stock`) VALUES (1, 'iphoneXR', 'Apple iPhone XR (A2108) 128GB', '/img/iphonexr.png', 'Apple iPhone XR (A2108) 128GB 蓝色 移动联通电信4G手机 双卡双待', 6199.00, 100);
INSERT INTO `t_goods`(`id`, `goods_name`, `goods_title`, `goods_img`, `goods_detail`, `goods_price`, `goods_stock`) VALUES (2, 'HUAWEIMate20', 'HUAWEI Mate 20 麒麟980', '/img/huaweimate20.png', 'HUAWEI Mate 20 麒麟980AI智能芯片全面屏超微距影像超大广角徕卡三摄6GB+128GB亮黑色全网通版双4G手机', 4499.00, 100);

--t_seckill_goods
INSERT INTO `t_seckill_goods`(`id`, `goods_id`, `seckill_price`, `stock_count`, `start_date`, `end_date`) VALUES (1, 1, 0.01, 5, '2019-01-21 16:38:07', '2019-01-24 16:38:12');
INSERT INTO `t_seckill_goods`(`id`, `goods_id`, `seckill_price`, `stock_count`, `start_date`, `end_date`) VALUES (2, 2, 0.01, 8, '2019-01-20 16:38:39', '2019-01-24 16:38:42');
