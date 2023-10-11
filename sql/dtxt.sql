-- 系统管理
CREATE TABLE `sys_user`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) COMMENT '创建时间',
    `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3) COMMENT '更新时间',
    `is_delete`   tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除0:否1:是',
    `user_name`   varchar(128) NOT NULL COMMENT '用户名',
    `password`    varchar(128) NOT NULL COMMENT 'pwd',
    `status`      int(11) NOT NULL DEFAULT '1' COMMENT '用户状态',
    PRIMARY KEY (`id`)
) COMMENT='系统用户表'


create table sys_role
(
    id          int auto_increment comment '主键'
        primary key,
    create_time datetime(3) default CURRENT_TIMESTAMP (3) not null comment '创建时间',
    update_time datetime(3) default CURRENT_TIMESTAMP (3) not null on update CURRENT_TIMESTAMP (3) comment '更新时间',
    is_delete   tinyint      default 0 not null comment '是否删除0:否1:是',
    value       varchar(255) default '' null comment '权限值',
    description varchar(255) default '' null comment '描述'
) comment '系统角色表';

create table sys_permission
(
    id          int auto_increment comment '主键'
        primary key,
    create_time datetime(3) default CURRENT_TIMESTAMP (3) not null comment '创建时间',
    update_time datetime(3) default CURRENT_TIMESTAMP (3) not null on update CURRENT_TIMESTAMP (3) comment '更新时间',
    is_delete   tinyint      default 0 not null comment '是否删除0:否1:是',
    value       varchar(255) default '' null comment '权限值',
    description varchar(255) default '' null comment '描述'
) comment '系统权限表';


create table sys_user_role
(
    id          int auto_increment comment '主键'
        primary key,
    create_time datetime(3) default CURRENT_TIMESTAMP (3) not null comment '创建时间',
    update_time datetime(3) default CURRENT_TIMESTAMP (3) not null on update CURRENT_TIMESTAMP (3) comment '更新时间',
    is_delete   tinyint default 0 not null comment '是否删除0:否1:是',
    user_id     int               not null comment '用户id',
    role_id     int               not null comment '角色id'
) comment '系统用户-角色关联表';



create table sys_log
(
    id          int auto_increment comment '主键' primary key,
    create_time datetime(3) default CURRENT_TIMESTAMP (3) not null comment '创建时间',
    update_time datetime(3) default CURRENT_TIMESTAMP (3) not null on update CURRENT_TIMESTAMP (3) comment '更新时间',
    is_delete   tinyint      default 0    not null comment '是否删除0:否1:是',
    op_user_id  int(11) not null comment '操作人',
    op_type     varchar(128) default '操作' not null comment '操作类型',
    op_value    varchar(255) default ''   not null comment '操作信息'
) comment '系统日志表';


-- 基础数据管理
create table ta_org
(
    id                   int auto_increment comment '主键' primary key,
    create_time          datetime(3) default CURRENT_TIMESTAMP (3) not null comment '创建时间',
    update_time          datetime(3) default CURRENT_TIMESTAMP (3) not null on update CURRENT_TIMESTAMP (3) comment '更新时间',
    is_delete            tinyint      default 0  not null comment '是否删除0:否1:是',
    org_name             varchar(255) default '' not null comment '企业名称',
    org_num              varchar(128) default '' comment '企业信用码',
    org_origin           varchar(128) default '' comment '企业所在区域',
    org_dept             varchar(128)            not null comment '所属组织单位',
    custom_num           varchar(255)            not null comment '客户号码',
    custom_elect_address varchar(255) null comment '用电地址',
    custom_elect_type    varchar(128) null comment '用电类型'
) comment '企业信息表';

create table ta_org_elect
(
    id                int auto_increment comment '主键' primary key,
    create_time       datetime(3) default CURRENT_TIMESTAMP (3) not null comment '创建时间',
    update_time       datetime(3) default CURRENT_TIMESTAMP (3) not null on update CURRENT_TIMESTAMP (3) comment '更新时间',
    is_delete         tinyint default 0 not null comment '是否删除0:否1:是',
    org_id            int(11) not null comment '企业ID',
    org_elect_consume varchar(255)      not null comment '电量信息',
    block_tx_hash     varchar(255) comment '区块链交易哈希',
    block_height      varchar(255) comment '区块链号'
) comment '企业用电量表';


create table ta_org_elect_green
(
    id              int auto_increment comment '主键' primary key,
    create_time     datetime(3) default CURRENT_TIMESTAMP (3) not null comment '创建时间',
    update_time     datetime(3) default CURRENT_TIMESTAMP (3) not null on update CURRENT_TIMESTAMP (3) comment '更新时间',
    is_delete       tinyint default 0 not null comment '是否删除0:否1:是',
    org_id          int(11) not null comment '企业ID',
    org_elect_green varchar(255)      not null comment '绿电消纳信息',
    block_tx_hash   varchar(255) comment '区块链交易哈希',
    block_height    varchar(255) comment '区块链号'
) comment '企业绿电消纳表';



create table ta_org_carbon
(
    id                   int auto_increment comment '主键' primary key,
    create_time          datetime(3) default CURRENT_TIMESTAMP (3) not null comment '创建时间',
    update_time          datetime(3) default CURRENT_TIMESTAMP (3) not null on update CURRENT_TIMESTAMP (3) comment '更新时间',
    is_delete            tinyint default 0 not null comment '是否删除0:否1:是',
    org_id               int(11) not null comment '企业ID',
    org_carbon_reduction varchar(255)      not null comment '碳减排信息',
    block_tx_hash        varchar(255) comment '区块链交易哈希',
    block_height         varchar(255) comment '区块链号'
) comment '企业碳减排信息表';

-- 碳排模型
create table ta_carbon_menu
(
    id          int auto_increment comment '主键' primary key,
    create_time datetime(3) default CURRENT_TIMESTAMP (3) not null comment '创建时间',
    update_time datetime(3) default CURRENT_TIMESTAMP (3) not null on update CURRENT_TIMESTAMP (3) comment '更新时间',
    is_delete   tinyint default 0 not null comment '是否删除0:否1:是',
    carbon_menu varchar(255)      not null comment '碳排因子'
) comment '碳排因子管理';

create table ta_contract
(
    id               int auto_increment comment '主键' primary key,
    create_time      datetime(3) default CURRENT_TIMESTAMP (3) not null comment '创建时间',
    update_time      datetime(3) default CURRENT_TIMESTAMP (3) not null on update CURRENT_TIMESTAMP (3) comment '更新时间',
    is_delete        tinyint default 0 not null comment '是否删除0:否1:是',
    contract_code    text              not null comment '智能合约链码',
    contract_address varchar(128)      not null comment '智能合约地址',
    modified_id      int(11) not null comment '智能合约创建者'
) comment '智能合约管理';

create table ta_cert
(
    id          int auto_increment comment '主键' primary key,
    create_time datetime(3) default CURRENT_TIMESTAMP (3) not null comment '创建时间',
    update_time datetime(3) default CURRENT_TIMESTAMP (3) not null on update CURRENT_TIMESTAMP (3) comment '更新时间',
    is_delete   tinyint default 0 not null comment '是否删除0:否1:是',
    org_id      int(11) not null comment '企业ID',
    cert_url    varchar(255) null comment '',

) comment '智能合约管理';


-- 电碳信息存证


-- 电碳信息溯源


-- 可视化展示








