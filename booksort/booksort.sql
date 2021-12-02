/*
 Navicat Premium Data Transfer

 Source Server         : tesst
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : bookm

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 02/12/2021 18:05:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bid` int(0) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书名',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者',
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详情',
  `num` int(0) NOT NULL COMMENT '书的状态分为两种，第一种是存在1，第二种是被借0',
  `price` int(0) NOT NULL COMMENT '价格',
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类别',
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 157 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (139, '图解java', '212', '121', 12, 121, '计算机');
INSERT INTO `book` VALUES (152, '图解c++', '李明', 'good', 12, 121, '计算机');
INSERT INTO `book` VALUES (153, '图解python', '李华', 'good', 12, 121, '计算机');
INSERT INTO `book` VALUES (154, 'java成神之路', '赵明', 'good', 12, 121, '计算机');
INSERT INTO `book` VALUES (155, 'java从零到大神', '张大大', 'good', 12, 134, '计算机');
INSERT INTO `book` VALUES (156, '盗墓笔记', '南派三叔', 'good', 123, 134, '恐怖灵异');

-- ----------------------------
-- Table structure for bookorder
-- ----------------------------
DROP TABLE IF EXISTS `bookorder`;
CREATE TABLE `bookorder`  (
  `orderid` int(0) NOT NULL AUTO_INCREMENT,
  `rid` int(0) NOT NULL,
  `bid` int(0) NOT NULL,
  `orderstatus` int(0) NOT NULL,
  `num` int(0) NOT NULL,
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bookorder
-- ----------------------------
INSERT INTO `bookorder` VALUES (1, 9, 139, 0, 2);
INSERT INTO `bookorder` VALUES (42, 9, 152, 1, 1);
INSERT INTO `bookorder` VALUES (44, 9, 153, 1, 2);

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `grade` int(0) NOT NULL COMMENT '0是超级管理员：能够进入系统管理界面，1是普通用户，进入普通用户界面，能够进行借书还书操作',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (1, '邓俊涛', '1314', 1);
INSERT INTO `emp` VALUES (2, 'ssm', '1314', 0);

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader`  (
  `eid` int(0) NOT NULL AUTO_INCREMENT,
  `ename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `adders` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`eid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES (9, '张方华', '15527991399', '湖北省');
INSERT INTO `reader` VALUES (10, '王小华', '15527996996', '湖北省');
INSERT INTO `reader` VALUES (11, '赵小华', '15527991369', '湖北省');
INSERT INTO `reader` VALUES (12, '邓俊涛', '15527991469', '湖北省襄阳市');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `adders` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES (1, '张华', '23', '155235611', '襄阳市');
INSERT INTO `staff` VALUES (2, '张明', '34', '1314888781', '武汉市');
INSERT INTO `staff` VALUES (4, '王小华', '33', '15527991393', '湖北省');

SET FOREIGN_KEY_CHECKS = 1;
