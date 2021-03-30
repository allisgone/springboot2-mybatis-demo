CREATE TABLE `t_sys_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coupon_jump_url` varchar(255) DEFAULT NULL COMMENT '回复优惠券跳转地址',
  `usertoken` varchar(100) DEFAULT NULL COMMENT '淘宝授权token 手动一个月更新一次',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `sid` varchar(20) DEFAULT NULL COMMENT '折淘客对应的淘客账号授权ID',
  `pid` varchar(64) DEFAULT NULL COMMENT '淘客pid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;