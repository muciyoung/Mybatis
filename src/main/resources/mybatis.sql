-- 创建数据库
create database if not exists `mybatis`;
-- 使用数据库
use mybatis;
-- 创建员工表
create table if not exists `employee`
(
    `id` bigint not null auto_increment comment '员工编号' primary key,
    `name` varchar(256) not null comment '员工姓名',
    `age` int not null comment '员工年龄',
    `position` varchar(256) not null comment '员工职位'
    ) comment '员工表';