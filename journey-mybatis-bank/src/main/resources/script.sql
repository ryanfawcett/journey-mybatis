create table jmb_account
(
    id         bigint auto_increment comment '主键ID'
        primary key,
    account_id varchar(255)   null comment '银行账号ID',
    balance    decimal(15, 2) null comment '余额'
)
    comment '银行账户表' collate = utf8mb4_general_ci;


