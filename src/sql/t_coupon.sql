CREATE TABLE `t_coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coupon_text` text COMMENT '券信息',
  `create_time` timestamp NULL DEFAULT NULL,
  `reply` tinyint(1) DEFAULT '0' COMMENT '是否已获取',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;