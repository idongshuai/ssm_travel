
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `orderNum` varchar(20) NOT NULL COMMENT '订单编号 不为空 唯一',
  `orderTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `peopleCount` int(11) DEFAULT NULL COMMENT '出行人数',
  `orderDesc` varchar(500) DEFAULT NULL COMMENT '订单描述(其它信息)',
  `payType` int(2) DEFAULT NULL COMMENT '支付方式(0 支付宝 1 微信 2其它)',
  `orderStatus` int(2) DEFAULT NULL COMMENT '订单状态(0 未支付 1 已支付)',
  `productId` int(9) DEFAULT NULL COMMENT '产品id 外键',
  PRIMARY KEY (`id`),
  UNIQUE KEY `orderNum` (`orderNum`),
  KEY `productId` (`productId`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', 'order-001', '2018-07-04 16:02:50', '23', '1232412', '1', '1', '2');
INSERT INTO `orders` VALUES ('2', 'order-002', '2018-07-15 16:03:52', '2', 'fasdfa', '0', '0', '3');
INSERT INTO `orders` VALUES ('3', 'order-003', '2018-07-15 16:04:12', '5', 'asghdfgas', '2', '1', '4');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '无意义，主键',
  `productNum` varchar(50) DEFAULT NULL COMMENT '产品编号',
  `productName` varchar(50) DEFAULT NULL COMMENT '产品名称（路线名称）',
  `cityName` varchar(50) DEFAULT NULL COMMENT '出发城市',
  `departureTime` datetime DEFAULT NULL COMMENT '出发时间',
  `productPrice` double(8,2) DEFAULT NULL COMMENT '产品价格',
  `productDesc` varchar(500) DEFAULT NULL COMMENT '产品描述',
  `productStatus` int(2) DEFAULT NULL COMMENT '状态(0 关闭 1 开启)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('2', 'travel-002', '杭州七日游', '杭州', '2018-07-15 15:22:00', '9000.00', '欲把西湖比西子,淡妆浓抹总相宜', '0');
INSERT INTO `product` VALUES ('3', 'travel-003', '三沙十五日游', '三沙', '2018-07-15 15:22:00', '9000.00', '海上明月共潮生', '0');
INSERT INTO `product` VALUES ('4', 'travel-004', '西藏自由行', '拉萨', '2018-07-15 15:13:00', '123.00', 'aaaaaaaaaaaaaa', '0');
INSERT INTO `product` VALUES ('5', 'travel-005', '新疆自由行', '乌鲁木齐', null, '7890.00', '', '0');
INSERT INTO `product` VALUES ('6', '34', '34', '324', '2018-07-11 16:44:52', '243.00', '234', '1');
INSERT INTO `product` VALUES ('7', '32', '234', '23', null, null, null, null);
INSERT INTO `product` VALUES ('8', '324', '234', '324', null, null, null, null);
INSERT INTO `product` VALUES ('9', '34', '56745', '567', null, null, null, null);
INSERT INTO `product` VALUES ('10', '786', 'th', 'sdf', null, null, null, null);
INSERT INTO `product` VALUES ('11', 'gf', 'dfg', 'df', null, null, null, null);
INSERT INTO `product` VALUES ('12', 'g', 'sdfg', 'dsfg', null, null, null, null);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `visitTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `username` varchar(50) DEFAULT NULL,
  `ip` varchar(30) DEFAULT NULL,
  `method` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', '2018-07-16 15:33:37', '111', '0:0:0:0:0:0:0:1', 'RoleController.findAllRole');
INSERT INTO `sys_log` VALUES ('2', '2018-07-16 15:33:39', '111', '0:0:0:0:0:0:0:1', 'SysUserController.findAllUser');
INSERT INTO `sys_log` VALUES ('3', '2018-07-16 15:33:41', '111', '0:0:0:0:0:0:0:1', 'RoleController.findAllRole');
INSERT INTO `sys_log` VALUES ('4', '2018-07-16 15:33:43', '111', '0:0:0:0:0:0:0:1', 'PermissionController.findAllPermission');
INSERT INTO `sys_log` VALUES ('5', '2018-07-16 15:33:46', '111', '0:0:0:0:0:0:0:1', 'PermissionController.findAllPermission');
INSERT INTO `sys_log` VALUES ('6', '2018-07-16 15:33:48', '111', '0:0:0:0:0:0:0:1', 'ProductController.findProductByPageHelper');
INSERT INTO `sys_log` VALUES ('7', '2018-07-16 15:33:51', '111', '0:0:0:0:0:0:0:1', 'OrderController.findAllOrder');
INSERT INTO `sys_log` VALUES ('8', '2018-07-16 15:34:34', '222', '0:0:0:0:0:0:0:1', 'ProductController.findProductByPageHelper');
INSERT INTO `sys_log` VALUES ('9', '2018-07-16 15:48:05', '111', '0:0:0:0:0:0:0:1', 'ProductController.findProductByPageHelper');
INSERT INTO `sys_log` VALUES ('10', '2018-07-16 15:49:14', '111', '0:0:0:0:0:0:0:1', 'ProductController.findProductByPageHelper');
INSERT INTO `sys_log` VALUES ('11', '2018-07-16 15:49:16', '111', '0:0:0:0:0:0:0:1', 'ProductController.findProductByPageHelper');
INSERT INTO `sys_log` VALUES ('12', '2018-07-16 15:49:27', '111', '0:0:0:0:0:0:0:1', 'OrderController.findAllOrder');
INSERT INTO `sys_log` VALUES ('13', '2018-07-16 15:49:30', '111', '0:0:0:0:0:0:0:1', 'OrderController.findAllOrder');
INSERT INTO `sys_log` VALUES ('14', '2018-07-16 15:52:09', '111', '0:0:0:0:0:0:0:1', 'SysUserController.loginFail');
INSERT INTO `sys_log` VALUES ('15', '2018-07-16 15:52:13', '111', '0:0:0:0:0:0:0:1', 'SysUserController.loginFail');
INSERT INTO `sys_log` VALUES ('16', '2018-07-16 15:52:45', '111', '0:0:0:0:0:0:0:1', 'SysUserController.loginFail');
INSERT INTO `sys_log` VALUES ('17', '2018-07-16 15:53:45', '111', '0:0:0:0:0:0:0:1', 'SysUserController.loginFail');
INSERT INTO `sys_log` VALUES ('18', '2018-07-16 15:53:51', '111', '0:0:0:0:0:0:0:1', 'OrderController.findAllOrder');
INSERT INTO `sys_log` VALUES ('19', '2018-07-16 15:53:55', '111', '0:0:0:0:0:0:0:1', 'SysUserController.loginFail');
INSERT INTO `sys_log` VALUES ('20', '2018-07-16 16:35:17', '111', '0:0:0:0:0:0:0:1', 'RoleController.findAllRole');
INSERT INTO `sys_log` VALUES ('21', '2018-07-16 16:35:19', '111', '0:0:0:0:0:0:0:1', 'ProductController.findProductByPageHelper');
INSERT INTO `sys_log` VALUES ('22', '2018-07-16 16:38:01', '111', '0:0:0:0:0:0:0:1', 'SysUserController.findAllUser');
INSERT INTO `sys_log` VALUES ('23', '2018-07-16 21:39:29', '111', '0:0:0:0:0:0:0:1', 'SysUserController.findAllUser');
INSERT INTO `sys_log` VALUES ('24', '2018-07-16 21:39:34', '111', '0:0:0:0:0:0:0:1', 'SysUserController.initAddRole');
INSERT INTO `sys_log` VALUES ('25', '2018-07-16 21:39:36', '111', '0:0:0:0:0:0:0:1', 'SysUserController.findAllUser');
INSERT INTO `sys_log` VALUES ('26', '2018-07-16 21:39:38', '111', '0:0:0:0:0:0:0:1', 'SysUserController.findUserById');
INSERT INTO `sys_log` VALUES ('27', '2018-07-16 21:40:09', '111', '0:0:0:0:0:0:0:1', 'SysUserController.findAllUser');
INSERT INTO `sys_log` VALUES ('28', '2018-07-16 21:40:13', '111', '0:0:0:0:0:0:0:1', 'ProductController.findProductByPageHelper');
INSERT INTO `sys_log` VALUES ('29', '2018-07-16 21:40:15', '111', '0:0:0:0:0:0:0:1', 'OrderController.findAllOrder');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `permissionName` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '产品', '/product');
INSERT INTO `sys_permission` VALUES ('2', '订单', '/order');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '无意义，主键自动增长',
  `roleName` varchar(50) DEFAULT NULL COMMENT '角色名',
  `roleDesc` varchar(50) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'USER', '普通用户');
INSERT INTO `sys_role` VALUES ('2', 'ADMIN', '管理员');
INSERT INTO `sys_role` VALUES ('3', 'HOUHOU', '侯侯');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `permissionId` int(9) DEFAULT NULL,
  `roleId` int(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '2');
INSERT INTO `sys_role_permission` VALUES ('2', '2');
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '3');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('3', '111', '111', '$2a$10$qSuF8UaXSGQ5XAnPB9HW3.JWv38kYufMi7gRkhMpybcHLYlckUOSO', '111', '1');
INSERT INTO `sys_user` VALUES ('4', '222', '222', '$2a$10$OQZxfkPlFsgukF6btp4KL.fPoth63xHdvLP8e.dF5X10ae.Kxhopa', '222', '0');
INSERT INTO `sys_user` VALUES ('5', '333', '333', '$2a$10$p22aQvh5a6wiXxqxHbinwe.VwtS9aCJ422Ni7D3H/gJiu8HeAdcVG', '333', '1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `userId` int(9) DEFAULT NULL,
  `roleId` int(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('3', '1');
INSERT INTO `sys_user_role` VALUES ('3', '2');
INSERT INTO `sys_user_role` VALUES ('3', '3');
INSERT INTO `sys_user_role` VALUES ('5', '3');
INSERT INTO `sys_user_role` VALUES ('4', '1');
