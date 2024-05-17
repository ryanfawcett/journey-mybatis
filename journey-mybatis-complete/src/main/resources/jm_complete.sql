create database if not exists journey_mybatis;

use journey_mybatis;

create table if not exists jmc_user
(
    id       bigint primary key auto_increment comment '主键ID',
    username varchar(48) comment '用户名',
    password varchar(255) comment '密码'
);