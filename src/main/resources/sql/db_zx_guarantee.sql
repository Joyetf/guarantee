/*
Navicat MySQL Data Transfer

Source Server         : MySQL5.7
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : db_zx_guarantee

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2022-06-25 18:11:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                               `product_id` varchar(100) DEFAULT NULL COMMENT '省综合服务平台产品id标识',
                               `company_name` varchar(50) DEFAULT NULL COMMENT '企业名称',
                               `company_credit_code` varchar(50) DEFAULT NULL COMMENT '企业统一社会信用代码',
                               `company_address` varchar(500) DEFAULT NULL COMMENT '企业地址',
                               `handler_name` varchar(50) DEFAULT NULL COMMENT '经办人姓名',
                               `handler_mobile` varchar(20) DEFAULT NULL COMMENT '经办人手机号',
                               `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='投保申请表';

-- ----------------------------
-- Table structure for guarantee
-- ----------------------------
DROP TABLE IF EXISTS `guarantee`;
CREATE TABLE `guarantee` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                             `product_id` varchar(255) DEFAULT NULL COMMENT '省综合服务平台产品id标识',
                             `order_no` varchar(255) DEFAULT NULL COMMENT '中鑫中科订单号',
                             `company_name` varchar(255) DEFAULT NULL COMMENT '企业名称',
                             `project_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
                             `project_area` varchar(255) DEFAULT NULL COMMENT '项目属地行政区域代码',
                             `project_type` varchar(255) DEFAULT NULL COMMENT '金融产品类型',
                             `institution_name` varchar(255) DEFAULT NULL COMMENT '金融机构名称',
                             `bond` varchar(255) DEFAULT NULL COMMENT '保证金金额',
                             `premium` varchar(255) DEFAULT NULL COMMENT '费用',
                             `rate` varchar(255) DEFAULT NULL COMMENT '费率',
                             `insure_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '投保时间，格式:yyyy-MM-dd HH:mm:ss',
                             `effective_time` varchar(255) DEFAULT NULL COMMENT '保函时效（月）',
                             `order_status` varchar(255) DEFAULT NULL COMMENT '订单状态',
                             `reason` varchar(255) DEFAULT NULL COMMENT '原因',
                             `guarantee_no` varchar(255) DEFAULT NULL COMMENT '保函编号',
                             `guarantee_url` varchar(255) DEFAULT NULL COMMENT '保函文件下载地址',
                             `guarantee_file` varchar(255) DEFAULT NULL COMMENT '保函文件的base64码',
                             `issue_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '出函时间，格式:yyyy-MM-dd HH:mm:ss',
                             `surrender_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '退保结果通知时间，格式:yyyy-MM-dd HH:mm:ss',
                             `claims_applicant` varchar(255) DEFAULT NULL COMMENT '理赔申请人',
                             `payer_account` varchar(255) DEFAULT NULL COMMENT '收款账号',
                             `payer_amount` varchar(255) DEFAULT NULL COMMENT '赔付金额',
                             `file_list` varchar(255) DEFAULT NULL COMMENT '理赔文件列表',
                             `apply_user_name` varchar(255) DEFAULT NULL COMMENT '理赔联系人',
                             `apply_user_phone` varchar(255) DEFAULT NULL COMMENT '理赔联系人电话',
                             `claims_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '理赔结果通知时间，格式:yyyy-MM-dd HH:mm:ss',
                             `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='保函表';

-- ----------------------------
-- Table structure for invoice
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                           `order_no` varchar(100) DEFAULT NULL COMMENT '中鑫中科订单号',
                           `guarantee` varchar(100) DEFAULT NULL COMMENT '保函编号',
                           `invoice_url` varchar(255) DEFAULT NULL COMMENT '发票下载地址，专票可不传',
                           `invoice_code` varchar(50) DEFAULT NULL COMMENT '发票代码',
                           `invoice_no` varchar(50) DEFAULT NULL COMMENT '发票号码',
                           `apply_status` tinyint(1) DEFAULT '0' COMMENT '是否申请成功 1：审核通过 0：审核不通过',
                           `applicant_name` varchar(50) DEFAULT NULL COMMENT '投保人名称',
                           `applicant_code` varchar(50) DEFAULT NULL COMMENT '投保人统一社会信用代码',
                           `amount` varchar(50) DEFAULT NULL COMMENT '开票金额，格式：数字格式字符串',
                           `type` tinyint(1) DEFAULT '0' COMMENT '0：普票；1：专票',
                           `address` varchar(100) DEFAULT NULL COMMENT '公司地址，专票时必填',
                           `phone` varchar(20) DEFAULT NULL COMMENT '公司电话，专票时必填',
                           `bank` varchar(50) DEFAULT NULL COMMENT '开户行，专票时必填',
                           `account` varchar(100) DEFAULT NULL COMMENT '账号，专票时必填',
                           `email` varchar(50) DEFAULT NULL COMMENT '接收电子发票的email',
                           `contact_mobile` varchar(20) DEFAULT NULL COMMENT '联系电话（收件人联系电话，专票时必填）',
                           `contact_name` varchar(50) DEFAULT NULL COMMENT '收件人联系电话姓名，专票时必填',
                           `contact_address` varchar(500) DEFAULT NULL COMMENT '收件人地址，专票时必填',
                           `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
                           `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='发票表';

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                           `product_id` varchar(64) DEFAULT NULL COMMENT '省综合服务平台产品id标识',
                           `product_name` varchar(300) DEFAULT NULL COMMENT '产品名称',
                           `product_status` char(2) DEFAULT NULL COMMENT '产品状态（1：正常，0：下架）',
                           `product_type` varchar(2) DEFAULT NULL COMMENT '金融产品类型',
                           `product_desc` varchar(500) DEFAULT NULL COMMENT '产品介绍描述',
                           `institution_name` varchar(100) DEFAULT NULL COMMENT '金融机构名称',
                           `institution_type` varchar(2) DEFAULT NULL COMMENT '金融机构类型',
                           `rate_list` varchar(200) DEFAULT NULL COMMENT '费率列表',
                           `limit_area` varchar(500) DEFAULT NULL COMMENT '适用区域的行政区域代码',
                           `limit_max_bond` varchar(18) DEFAULT NULL COMMENT '最大保证金金额',
                           `product_features_desc` varchar(500) DEFAULT NULL COMMENT '产品特色描述',
                           `apply_condition_desc` varchar(500) DEFAULT NULL COMMENT '申请条件描述',
                           `file_desc` varchar(500) DEFAULT NULL COMMENT '提交材料描述',
                           `customer_desc` varchar(500) DEFAULT NULL COMMENT '适用客户描述',
                           `source` varchar(500) DEFAULT NULL COMMENT '产品来源',
                           `product_picture` blob COMMENT '产品图片文件的base64码',
                           `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                           `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='产品表';
