/*
 Navicat Premium Data Transfer

 Source Server         : localDB
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : AppStore

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 26/11/2017 12:38:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_category
-- ----------------------------
DROP TABLE IF EXISTS `app_category`;
CREATE TABLE `app_category`  (
  `id` int(11) NOT NULL,
  `appId` int(11) NOT NULL,
  `categoryId` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `app`(`appId`) USING BTREE,
  INDEX `category`(`categoryId`) USING BTREE,
  CONSTRAINT `app` FOREIGN KEY (`appId`) REFERENCES `apps` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `category` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of app_category
-- ----------------------------
BEGIN;
INSERT INTO `app_category` VALUES (1, 1, 1), (2, 2, 1);
COMMIT;

-- ----------------------------
-- Table structure for apps
-- ----------------------------
DROP TABLE IF EXISTS `apps`;
CREATE TABLE `apps`  (
  `id` int(11) NOT NULL,
  `appName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `version` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` date NOT NULL,
  `updateTime` date NOT NULL,
  `size` double NOT NULL,
  `brief` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of apps
-- ----------------------------
BEGIN;
INSERT INTO `apps` VALUES (1, '1', '1', '1', '2017-11-25', '2017-11-25', 20, 'xxxx', 'xxxxxx'), (2, '2', '2', '2', '2017-11-25', '2017-11-26', 30, 'yyyy', 'yyyy');
COMMIT;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL,
  `category` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `brief` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
INSERT INTO `category` VALUES (1, '1', '1', 'eeee'), (2, '2', '2', 'www');
COMMIT;

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `id` int(11) NOT NULL,
  `appId` int(11) NOT NULL,
  `image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `app_image`(`appId`) USING BTREE,
  CONSTRAINT `app_image` FOREIGN KEY (`appId`) REFERENCES `apps` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;

SET FOREIGN_KEY_CHECKS = 1;
