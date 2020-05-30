/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2020-05-30 08:54:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(128) NOT NULL COMMENT '账户姓名',
  `amount` decimal(11,3) NOT NULL COMMENT '账户金额',
  `type` int(11) NOT NULL,
  `is_lock` bit(1) NOT NULL DEFAULT b'1' COMMENT '账户锁定',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL,
  `password` varchar(6) NOT NULL,
  PRIMARY KEY (`id`,`account_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '1', '9731.000', '1', '', '2020-05-29 22:37:28', '2020-05-29 22:37:29', '123456');
INSERT INTO `account` VALUES ('2', '1231', '14612.000', '1', '', '2020-05-29 22:37:28', '2020-05-29 22:37:29', '123456');
INSERT INTO `account` VALUES ('3', '121', '2323.000', '1', '', '2020-05-29 16:15:36', '2020-05-29 08:38:11', '123456');
INSERT INTO `account` VALUES ('4', '432', '24343.000', '2', '', '2020-05-29 16:15:39', '2020-05-29 08:38:37', '123456');
