drop table med_customer;
CREATE TABLE `med_customer` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` bigint(11) DEFAULT NULL COMMENT '父节点id',
  `root_id` bigint(11) DEFAULT '0' COMMENT '根节点id(非总根0节点)加盟商类型下使用',
  `user_name` varchar(128) NOT NULL COMMENT '用户名',
  `pwd_word` varchar(64) NOT NULL COMMENT '密码',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态 1-有效；0-无效',
  `grade` int(4) DEFAULT NULL COMMENT '等级',
  `user_type` int(4) DEFAULT '0' COMMENT '用户类型 1-加盟商 0-普通用户',
  `child_lev` int(4) DEFAULT '2' COMMENT '下辖级别 加盟商可能超过2 系统参数为准，可手动修改',
  `socre` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '积分',
  `ratio` float(6,4) DEFAULT '0.0000' COMMENT '比率',
  `proxy_ratio` float(6,4) DEFAULT '0.0000' COMMENT '加盟商独立比率',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `ext_data` varchar(1000) DEFAULT NULL COMMENT '扩展数据',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_idx` (`user_name`) USING BTREE,
  KEY `pid_idx` (`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12241 DEFAULT CHARSET=utf8;

INSERT INTO `med_customer` VALUES ('1', null,  'root','med_root_user', '1',0,1,9999,null);
INSERT INTO `med_customer` VALUES ('2', '1', 'join1', '2222', '1',1,1,5,null);
INSERT INTO `med_customer` VALUES ('21', '2', 'user21', '22222', '1',2,2,2,null);
INSERT INTO `med_customer` VALUES ('22', '2', 'user22', '22222', '1',2,2,2,null);
INSERT INTO `med_customer` VALUES ('3', '1', 'join2', '3333', '1',1,1,8,null);
INSERT INTO `med_customer` VALUES ('31', '3', 'user31', '33333', '1',2,2,2,null);
INSERT INTO `med_customer` VALUES ('32', '3', 'user32', '33332', '1',2,2,2,null);
INSERT INTO `med_customer` VALUES ('4', '1', 'user1', '111', '1',1,2,2,null);
INSERT INTO `med_customer` VALUES ('11', '2', 'user11', '222', '1',2,2,2,null);
INSERT INTO `med_customer` VALUES ('12', '2', 'user12', '333', '1',2,2,2,null);
INSERT INTO `med_customer` VALUES ('13', '2', 'user13', '444', '1',2,2,2,null);
INSERT INTO `med_customer` VALUES ('111', '11', 'user111', '555', '1',3,2,2,null);
INSERT INTO `med_customer` VALUES ('121', '12', 'user121', '666', '1',3,2,2,null);
INSERT INTO `med_customer` VALUES ('122', '12', 'user122', '777', '1',3,2,2,null);
INSERT INTO `med_customer` VALUES ('1221', '122', 'user1221', '888', '1',4,2,2,null);
INSERT INTO `med_customer` VALUES ('1222', '122', 'user1222', '999', '1',4,2,2,null);
INSERT INTO `med_customer` VALUES ('12211', '1222', 'user12211', '000', '1',5,2,2,null);

CREATE TABLE `med_order` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `socre` float(8,2) NOT NULL,
  `status` tinyint(1) DEFAULT '0' COMMENT '状态 0-申请；1-有效；2-无效',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `med_socre` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `socre` float(8,2) NOT NULL,
  `status` tinyint(1) DEFAULT '0' COMMENT '状态 1-有效；0-无效',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `order_id` bigint(11) DEFAULT NULL COMMENT '订单号',
  PRIMARY KEY (`id`),
  KEY `idx_customer_id` (`customer_id`) USING BTREE,
  KEY `ind_order_id` (`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `med_image` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `img_name` varchar(64) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `content` mediumblob,
  `content_type` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

CREATE TABLE `med_partner_store` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL COMMENT '位置',
  `phone` varchar(15) DEFAULT NULL COMMENT '手机号',
  `tel` varchar(13) DEFAULT NULL COMMENT '座机',
  `store_img` varchar(255) DEFAULT NULL COMMENT '店铺首页',
  `store_name` varchar(255) DEFAULT NULL COMMENT '店铺名',
  `price` float(8,2) DEFAULT NULL COMMENT '消费均价',
  `carousel` varchar(1000) DEFAULT NULL COMMENT '轮播图内容(json)',
  `represent` varchar(2000) DEFAULT NULL COMMENT '描述',
  `cate_id` int(5) DEFAULT NULL COMMENT '分类id',
  `latitude` float(10,7) DEFAULT '0.0000000',
  `longitude` float(10,7) DEFAULT '0.0000000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `med_dictionary_classification` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `item_type` tinyint(2) NOT NULL COMMENT '字典项类型 1 单独项 2数组项',
  `dictionary_classification` varchar(100) NOT NULL COMMENT '字典类型值',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` bigint(1) DEFAULT NULL COMMENT '有效性(0：失效,1：有效)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='字典类型';

CREATE TABLE `med_dictionary_item` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `pid` bigint(16) DEFAULT NULL COMMENT '父级ID',
  `dictionary_classification_id` bigint(16) NOT NULL COMMENT '字典类型id',
  `item_data` varchar(20000) NOT NULL COMMENT '字典项内容',
  `item_order` bigint(16) DEFAULT '1' COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` bigint(1) DEFAULT NULL COMMENT '有效性(0：失效,1：有效)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='字典项';