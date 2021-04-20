drop table med_customer;
CREATE TABLE `med_customer` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` bigint(11) DEFAULT NULL COMMENT '父节点id',
  `user_name` varchar(128) NOT NULL COMMENT '用户名',
  `pwd_word` varchar(64) NOT NULL COMMENT '密码',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态 1-有效；0-无效',
  `grade` int(4) DEFAULT NULL COMMENT '等级',
  `user_type` int(4) DEFAULT '0' COMMENT '用户类型 1-加盟商 0-普通用户',
  `child_lev` int(4) DEFAULT '2' COMMENT '下辖级别 加盟商可能超过2',
  `socre` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '积分',
  `ratio` float(6,4) DEFAULT '0.0000' COMMENT '比率',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `ext_data` varchar(1000) DEFAULT NULL COMMENT '扩展数据',
  PRIMARY KEY (`id`),
  KEY `pid_idx` (`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

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