/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50734
Source Host           : 101.132.74.147:3306
Source Database       : order_system

Target Server Type    : MYSQL
Target Server Version : 50734
File Encoding         : 65001

Date: 2022-01-12 12:09:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '蔬菜类');
INSERT INTO `category` VALUES ('2', '荤菜类');
INSERT INTO `category` VALUES ('3', '海鲜类');
INSERT INTO `category` VALUES ('4', '小吃类');
INSERT INTO `category` VALUES ('5', '主食类');
INSERT INTO `category` VALUES ('6', '凉菜类');
INSERT INTO `category` VALUES ('7', '卤菜类');
INSERT INTO `category` VALUES ('8', '菌菇类');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cust_phone` char(11) NOT NULL DEFAULT '' COMMENT '顾客电话号码',
  `password` varchar(255) NOT NULL,
  `cust_name` varchar(50) NOT NULL,
  `cust_balance` double(20,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`cust_phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `food_id` int(11) NOT NULL AUTO_INCREMENT,
  `food_name` varchar(50) NOT NULL,
  `category_id` int(11) NOT NULL,
  `food_price` double(20,2) NOT NULL,
  `food_desc` varchar(255) DEFAULT NULL,
  `food_photo` varchar(255) DEFAULT NULL,
  `food_repertory` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`food_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `food_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('1', '拍黄瓜', '6', '15.00', '爽脆可口', null, '0000000100');
INSERT INTO `food` VALUES ('2', '蛋炒饭', '5', '18.00', '贼香', null, '0000000100');
INSERT INTO `food` VALUES ('3', '卤鸡腿', '7', '8.00', '独家秘方', null, '0000000100');
INSERT INTO `food` VALUES ('4', '金汤娃娃菜', '1', '30.00', '酸爽开胃', null, '0000000100');
INSERT INTO `food` VALUES ('5', '宫保鸡丁', '2', '58.00', '人人都说好', null, '0000000088');
INSERT INTO `food` VALUES ('6', '养生茶树菇', '8', '88.00', '养胃益肾', null, '0000000066');
INSERT INTO `food` VALUES ('7', '鱼子酱', '3', '666.00', '名贵鱼子酱，你值得拥有！', null, '0000000020');
INSERT INTO `food` VALUES ('8', '小吃拼盘', '4', '40.00', '饭前小吃', null, '0000000100');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` char(30) NOT NULL,
  `cust_phone` char(11) NOT NULL,
  `table_id` char(3) NOT NULL,
  `order_state` int(11) NOT NULL DEFAULT '0',
  `order_price` double(20,2) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `cust_phone` (`cust_phone`),
  KEY `table_id` (`table_id`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`cust_phone`) REFERENCES `customer` (`cust_phone`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`table_id`) REFERENCES `table` (`table_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` char(30) NOT NULL,
  `food_id` int(11) NOT NULL,
  `food_num` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`record_id`),
  KEY `order_id` (`order_id`),
  KEY `food_id` (`food_id`),
  CONSTRAINT `record_ibfk_2` FOREIGN KEY (`food_id`) REFERENCES `food` (`food_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `record_ibfk_3` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------

-- ----------------------------
-- Table structure for reserve
-- ----------------------------
DROP TABLE IF EXISTS `reserve`;
CREATE TABLE `reserve` (
  `reserve_id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_phone` varchar(11) NOT NULL,
  `table_id` char(3) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`reserve_id`),
  KEY `cust_phone` (`cust_phone`),
  KEY `table_id` (`table_id`),
  CONSTRAINT `reserve_ibfk_1` FOREIGN KEY (`cust_phone`) REFERENCES `customer` (`cust_phone`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reserve_ibfk_2` FOREIGN KEY (`table_id`) REFERENCES `table` (`table_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reserve
-- ----------------------------

-- ----------------------------
-- Table structure for SPRING_SESSION
-- ----------------------------
DROP TABLE IF EXISTS `SPRING_SESSION`;
CREATE TABLE `SPRING_SESSION` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of SPRING_SESSION
-- ----------------------------

-- ----------------------------
-- Table structure for SPRING_SESSION_ATTRIBUTES
-- ----------------------------
DROP TABLE IF EXISTS `SPRING_SESSION_ATTRIBUTES`;
CREATE TABLE `SPRING_SESSION_ATTRIBUTES` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`),
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `SPRING_SESSION` (`PRIMARY_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of SPRING_SESSION_ATTRIBUTES
-- ----------------------------

-- ----------------------------
-- Table structure for table
-- ----------------------------
DROP TABLE IF EXISTS `table`;
CREATE TABLE `table` (
  `table_id` char(3) NOT NULL,
  `table_state` int(11) NOT NULL DEFAULT '0',
  `full_people` int(11) NOT NULL,
  `table_price` double(20,2) NOT NULL,
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of table
-- ----------------------------
INSERT INTO `table` VALUES ('A01', '0', '2', '4.00');
INSERT INTO `table` VALUES ('A02', '0', '2', '4.00');
INSERT INTO `table` VALUES ('A03', '0', '2', '4.00');
INSERT INTO `table` VALUES ('A04', '0', '2', '4.00');
INSERT INTO `table` VALUES ('B01', '0', '4', '8.00');
INSERT INTO `table` VALUES ('B02', '0', '4', '8.00');
INSERT INTO `table` VALUES ('B03', '0', '4', '8.00');
INSERT INTO `table` VALUES ('B04', '0', '4', '8.00');
INSERT INTO `table` VALUES ('C01', '0', '6', '12.00');
INSERT INTO `table` VALUES ('C02', '0', '6', '12.00');
INSERT INTO `table` VALUES ('C03', '0', '6', '12.00');
INSERT INTO `table` VALUES ('C04', '0', '6', '12.00');
INSERT INTO `table` VALUES ('D01', '0', '12', '24.00');
INSERT INTO `table` VALUES ('D02', '0', '12', '24.00');
INSERT INTO `table` VALUES ('D03', '0', '12', '24.00');
INSERT INTO `table` VALUES ('D04', '0', '12', '24.00');
INSERT INTO `table` VALUES ('E01', '0', '16', '32.00');
INSERT INTO `table` VALUES ('E02', '0', '16', '32.00');
INSERT INTO `table` VALUES ('E03', '0', '16', '32.00');
INSERT INTO `table` VALUES ('E04', '0', '16', '32.00');
