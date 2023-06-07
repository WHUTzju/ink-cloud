-- 创建数据库
create
database no_catch character set utf8mb4;

-- 创建数据表
CREATE TABLE `no_catch_test`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) COMMENT '创建时间',
    `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3) COMMENT '更新时间',
    `is_delete`   tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除0:否1:是',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='测试表';

-- 附件表
CREATE TABLE `ta_attachment`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) COMMENT '创建时间',
    `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3) COMMENT '更新时间',
    `is_delete`   tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除0:否1:是',
    `file_hash`   varchar(128) NOT NULL COMMENT '文件哈希 SHA256',
    `file_name`   varchar(128) NOT NULL COMMENT '文件名称',
    `file_path`   varchar(128) NOT NULL COMMENT '文件路径',
    `file_type`   int(11) DEFAULT NULL COMMENT '文件类型 \n1 撤销案件决定书\n2 快速移交起诉意见书\n3 侦查相关书',
    `case_id`     bigint(20) DEFAULT NULL COMMENT '文件所属案件/人',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COMMENT='附件表';

-- 跟踪信息表
CREATE TABLE `ta_case_message`
(
    `id`                bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '预警表Id',
    `create_time`       datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '创建时间',
    `update_time`       datetime(3) DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3) COMMENT '更新时间',
    `is_delete`         tinyint(2) DEFAULT '0' COMMENT '是否删除0:否1:是',
    `case_id`           bigint(20) DEFAULT NULL COMMENT '案件Id',
    `case_message_type` tinyint(2) DEFAULT NULL COMMENT '消息类型\n1-侦查消息\n2-跟踪消息',
    `case_message`      text COMMENT '消息内容',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4 COMMENT='消息表。侦查消息，跟踪消息';

-- 案件流程表
CREATE TABLE `ta_case_process`
(
    `id`                      bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `create_time`             datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '创建时间',
    `update_time`             datetime(3) DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3) COMMENT '更新时间',
    `is_delete`               tinyint(2) DEFAULT '0' COMMENT '是否删除0:否1:是',
    `case_id`                 bigint(20) DEFAULT NULL COMMENT '案件Id',
    `case_number`             varchar(255) DEFAULT NULL COMMENT '受案号',
    `case_name`               varchar(255) DEFAULT NULL COMMENT '案件名',
    `case_supervisory_stream` int(12) DEFAULT NULL COMMENT '监管的流程信息 \n 1：不构成犯罪不捕：11-档案创建 ，12-上传撤销案件裁决书 ，13-完成\n\n 2：无逮捕必要不捕：21-档案创建， 22-是否制作快速移送起诉意见书， 23-填写案件跟踪信息， 24-移送起诉 ，25-完成\n\n3：证据不足不捕：31-档案创建，32-填写案件类型，33-填写案件跟踪信息，34-撤销并上传案件决定书，25-完成',
    `case_person_type`        tinyint(2) DEFAULT NULL COMMENT '办案人员类型 1-检察官 2-公安',
    `case_warn_color`         tinyint(2) DEFAULT NULL COMMENT '2-黄色预警 3红色预警',
    `case_warn_msg`           varchar(255) DEFAULT NULL COMMENT '预警信息',
    `case_process_status`     int(11) DEFAULT '2' COMMENT '流程状态 0-已完成、1-进行中、2-未开始',
    `case_process_node_code`  int(11) DEFAULT '11' COMMENT '三类不捕案件的流程节点值 代表当前节点的信息',
    `case_choose_type`        int(11) DEFAULT NULL COMMENT '仅32用到，案件类型选择：重大、一般',
    `case_deal_type`          int(11) DEFAULT NULL COMMENT '仅34用到：案件处理类型 撤案、终止侦查、报步或直诉',
    `case_baobu_type`         int(11) DEFAULT NULL COMMENT '仅34用到，1-报捕，2-直诉',
    `case_is_quick`           tinyint(1) DEFAULT '1' COMMENT '是否快速移送',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2149 DEFAULT CHARSET=utf8mb4 COMMENT='案件流程信息表';


-- 案件待办表
CREATE TABLE `ta_case_todo`
(
    `id`                bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `create_time`       datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) COMMENT '创建时间',
    `update_time`       datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3) COMMENT '更新时间',
    `is_delete`         tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除0:否1:是',
    `case_id`           bigint(20) NOT NULL COMMENT '案件Id',
    `case_todo_type`    tinyint(3) NOT NULL COMMENT '待办事项类型 见CaseTodotype',
    `case_todo_msg`     varchar(255) NOT NULL COMMENT '待办事项描述 ',
    `case_person_type`  tinyint(2) DEFAULT NULL COMMENT '办案人员类型 1-检察官 2-公安',
    `case_to_user_id`   varchar(127) DEFAULT NULL COMMENT '待办提醒 用户ID',
    `case_to_user_name` varchar(128) DEFAULT NULL COMMENT '待办提醒 用户名',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=869 DEFAULT CHARSET=utf8mb4 COMMENT='待办事项表';

-- 已处置案件表
CREATE TABLE `ta_disposed_of_case`
(
    `id`                         bigint(20) NOT NULL COMMENT '主键',
    `create_time`                datetime(3) DEFAULT NULL COMMENT '创建时间',
    `update_time`                datetime(3) DEFAULT NULL COMMENT '更新时间',
    `is_delete`                  tinyint(3) DEFAULT NULL COMMENT '是否删除 0表示为删除，1表示已删除',
    `case_id`                    bigint(20) NOT NULL COMMENT '案件id',
    `no_catch_person_status`     tinyint(2) DEFAULT NULL COMMENT '不捕人员状态（1：处置中；2：已完结）',
    `no_catch_person_name`       varchar(255) DEFAULT NULL COMMENT '不捕人员姓名',
    `case_name`                  varchar(512) DEFAULT NULL COMMENT '案件名称',
    `case_number`                varchar(255) DEFAULT NULL COMMENT '受案号',
    `no_catch_first_type`        int(11) DEFAULT NULL COMMENT '案件所属不捕类型  1：不构成犯罪不捕；2：无逮捕必要不捕；3：证据不足不捕',
    `case_send_date`             datetime(3) DEFAULT NULL COMMENT '送达日期',
    `case_execute_date`          datetime(3) DEFAULT NULL COMMENT '执行日期',
    `case_actual_deal_with_date` datetime(3) DEFAULT NULL COMMENT '处置日期',
    `case_procurator_name`       varchar(255) DEFAULT NULL COMMENT '检察官姓名',
    `case_police_name`           varchar(255) DEFAULT NULL COMMENT '承办法制员姓名',
    `case_hear_date`             datetime(3) DEFAULT NULL COMMENT '审结日期',
    `case_department`            varchar(255) DEFAULT NULL COMMENT '所属检察部门',
    `case_police_depart`         varchar(255) DEFAULT NULL COMMENT '所属派出所',
    `case_trans_person`          varchar(255) DEFAULT NULL COMMENT '移送人及电话',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 不捕人员表
CREATE TABLE `ta_no_catch_person`
(
    `case_id`                 bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键,案件id',
    `create_time`             datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '创建时间',
    `update_time`             datetime(3) DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3) COMMENT '更新时间',
    `is_delete`               tinyint(2) DEFAULT '0' COMMENT '是否删除0:否1:是',
    `no_catch_person_name`    varchar(512) NOT NULL COMMENT '不捕人员姓名',
    `no_catch_person_status`  int(11) DEFAULT NULL COMMENT '人员状态， 用 1 表示未处置，2表示处理中，3表示已办结  ',
    `case_number`             varchar(512) DEFAULT NULL COMMENT '受案号',
    `case_name`               varchar(512) NOT NULL COMMENT '案件名称',
    `case_department`         varchar(255) DEFAULT NULL COMMENT '承办检察部门',
    `case_procurator_name`    varchar(255) NOT NULL COMMENT '承办检察官姓名',
    `case_police_name`        varchar(255) DEFAULT NULL COMMENT '承办法制人（公安）',
    `case_police_depart`      varchar(255) DEFAULT NULL COMMENT '所属派出所',
    `case_trans_person`       varchar(255) DEFAULT NULL COMMENT '移送人及电话',
    `no_catch_first_type`     tinyint(3) DEFAULT NULL COMMENT '案件所属不捕类型  1：不构成犯罪不捕；2：无逮捕必要不捕；3：证据不足不捕',
    `no_catch_second_type`    tinyint(3) DEFAULT NULL COMMENT '案件所属不捕情形  1：不构成犯罪不捕：没有犯罪事实不捕、符合刑诉法第16条不捕； 2：无逮捕必要不捕：调查后排除非法证据不捕、证据不足其他情形不捕；3：证据不足不捕：认罪认罚或刑事和解不捕、无社会危险性其他情形不捕',
    `no_catch_details`        varchar(512) DEFAULT NULL COMMENT '不捕情形',
    `case_accept_date`        datetime(3) DEFAULT NULL COMMENT '受理日期',
    `case_hear_date`          datetime(3) DEFAULT NULL COMMENT '审结日期',
    `case_send_date`          datetime(3) DEFAULT NULL COMMENT '送达日期',
    `case_plan_solve_date`    datetime(3) DEFAULT NULL COMMENT '执行日期',
    `case_actual_solve_date`  datetime(3) DEFAULT NULL COMMENT '处置日期（实际处置时间）',
    `case_execute_date`       datetime(3) DEFAULT NULL COMMENT '执行日期(废弃)',
    `case_plan_solve_cz_date` datetime(3) DEFAULT NULL COMMENT '计划处置日期',
    `case_choose_type`        int(11) DEFAULT NULL COMMENT '案件类型：一般、重大',
    `case_deal_type`          int(11) DEFAULT NULL COMMENT '案件处理方式：撤案、终止、报捕或直诉',
    `case_baobu_type`         int(11) DEFAULT NULL COMMENT '报捕、直诉',
    `case_is_quick`           tinyint(1) DEFAULT NULL COMMENT '是否快速移送',
    PRIMARY KEY (`case_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=542 DEFAULT CHARSET=utf8mb4 COMMENT='不捕人员表';

-- 超期未处置表
CREATE TABLE `ta_timeout_case`
(
    `id`                      bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `create_time`             datetime(3) DEFAULT NULL COMMENT '创建时间',
    `update_time`             datetime(3) DEFAULT NULL COMMENT '更新时间',
    `is_delete`               tinyint(3) DEFAULT NULL COMMENT '是否删除 0表示未删除，1表示已删除',
    `case_id`                 bigint(20) NOT NULL COMMENT '案件id',
    `case_over_days`          int(11) DEFAULT NULL COMMENT '超期天数',
    `no_catch_person_name`    varchar(128) DEFAULT NULL COMMENT '不捕人员姓名',
    `no_catch_first_type`     int(3) DEFAULT NULL COMMENT '不捕人员类型',
    `case_send_date`          datetime(3) DEFAULT NULL COMMENT '送达日期',
    `case_plan_solve_cz_date` datetime(3) DEFAULT NULL COMMENT '计划处置日期',
    `case_police_name`        varchar(255) DEFAULT NULL COMMENT '承办法制人',
    `case_procurator_name`    varchar(255) DEFAULT NULL COMMENT '承办检察官',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8mb4;

-- 用户表
CREATE TABLE `ta_user`
(
    `id`                 varchar(127) NOT NULL COMMENT '主键',
    `create_time`        datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) COMMENT '创建时间',
    `update_time`        datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3) COMMENT '更新时间',
    `is_delete`          tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除0:否1:是',
    `user_name`          varchar(128) NOT NULL COMMENT '用户名',
    `user_mobile`        varchar(32)  NOT NULL DEFAULT '0000-0000' COMMENT '（废弃字段）用户登录手机号码',
    `user_password`      varchar(128) NOT NULL COMMENT '用户登录密码（加盐md5）',
    `user_role`          int(11) NOT NULL DEFAULT '0' COMMENT '用户角色 0-管理员 1-检察官 2-公安',
    `user_status`        int(11) NOT NULL DEFAULT '0' COMMENT '用户状态 0-正常 1-冻结',
    `fail_times`         int(11) NOT NULL DEFAULT '0' COMMENT '用户登陆失败次数',
    `user_creator`       varchar(64)           DEFAULT '超级管理员' COMMENT '用户创建人',
    `user_department_id` int(11) DEFAULT NULL COMMENT '用户所属部门ID',
    `user_unit_code`     int(11) DEFAULT '1' COMMENT '所属单位 1-检察、2-公安',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理用户表';

-- 部门表
CREATE TABLE `ta_department`
(
    `id`                   bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `create_time`          datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) COMMENT '部门创建时间',
    `update_time`          datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '部门更新时间',
    `is_delete`            tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除部门 0-否 1-是',
    `department_unit`      varchar(256) NOT NULL COMMENT '检察院、公安',
    `department_unit_code` int(11) DEFAULT '1' COMMENT '所属单位code 1-武昌区检察院 2-武汉市武昌区公安局',
    `department_name`      varchar(512)          DEFAULT NULL COMMENT '部门名称、管辖单位',
    `department_number`    int(11) NOT NULL COMMENT '部门编号',
    `create_person`        varchar(255)          DEFAULT NULL COMMENT '部门创建人',
    `department_region`    varchar(512) NOT NULL DEFAULT '武汉市武昌区' COMMENT '部门区域',
    PRIMARY KEY (`id`),
    UNIQUE KEY `department_number` (`department_number`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COMMENT='部门及单位总表';

-- 用户部门表
CREATE TABLE `ta_user_department`
(
    `id`                   bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `create_time`          datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP (3) COMMENT '部门创建时间',
    `update_time`          datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '部门更新时间',
    `is_delete`            tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除部门 0-否 1-是',
    `user_id`              varchar(127)          DEFAULT NULL COMMENT '用户ID',
    `user_name`            varchar(128)          DEFAULT NULL COMMENT '用户名',
    `department_id`        int(11) DEFAULT NULL COMMENT '部门ID',
    `department_unit_code` int(11) DEFAULT '1' COMMENT '所属单位code 1-武昌区检察院 2-武汉市武昌区公安局',
    `department_name`      varchar(512)          DEFAULT NULL COMMENT '部门名称',
    `department_number`    int(11) NOT NULL COMMENT '部门编号',
    `create_person`        varchar(255)          DEFAULT NULL COMMENT '部门创建人',
    `department_region`    varchar(512) NOT NULL DEFAULT '武汉市武昌区' COMMENT '部门区域',
    `department_unit`      varchar(256) NOT NULL COMMENT '检察院、公安',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COMMENT='法治人管辖单位表';

-- 预警表
CREATE TABLE `ta_warn`
(
    `id`                   bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '预警表Id',
    `create_time`          datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '创建时间',
    `update_time`          datetime(3) DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3) COMMENT '更新时间',
    `is_delete`            tinyint(2) DEFAULT '0' COMMENT '是否删除0:否1:是',
    `case_id`              bigint(20) DEFAULT NULL COMMENT '案件Id',
    `case_number`          varchar(255) DEFAULT NULL COMMENT '受案号',
    `case_name`            varchar(255) DEFAULT NULL COMMENT '案件名',
    `case_process_node`    int(11) NOT NULL COMMENT '预警所在的案件流程节点',
    `warn_to_user_id`      varchar(127) NOT NULL COMMENT '预警用户ID',
    `warn_to_user_name`    varchar(128) NOT NULL COMMENT '预警用户名称 保留字段',
    `warn_type`            int(11) NOT NULL COMMENT '预警类型 见WarnType',
    `warn_color_type`      int(11) NOT NULL COMMENT '预警颜色 见WarnColorType',
    `warn_rule_start_time` datetime(3) NOT NULL COMMENT '预警规则 起算时间 最初为送达时间',
    `warn_status`          tinyint(2) DEFAULT '0' COMMENT '预警状态 0-生效 1- 失效',
    `warn_last_days`       int(11) DEFAULT '0' COMMENT '剩余天数',
    `warn_over_days`       int(11) DEFAULT NULL COMMENT '超过天数',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=613 DEFAULT CHARSET=utf8mb4 COMMENT='预警表';

-- 预警记录表
CREATE TABLE `ta_warn_record`
(
    `id`                      bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '预警表Id',
    `create_time`             datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '创建时间',
    `update_time`             datetime(3) DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3) COMMENT '更新时间',
    `is_delete`               tinyint(2) DEFAULT '0' COMMENT '是否删除0:否1:是',
    `case_id`                 bigint(20) DEFAULT NULL COMMENT '案件Id',
    `case_number`             varchar(255) DEFAULT NULL COMMENT '受案号',
    `case_name`               varchar(255) DEFAULT NULL COMMENT '案件名',
    `case_send_date`          datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '送达时间',
    `case_color`              tinyint(3) DEFAULT NULL COMMENT '预警颜色 1-蓝色 2-黄色预警 3红色预警',
    `case_warn_start_time`    datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '预警开始时间',
    `case_warn_status`        tinyint(2) DEFAULT '0' COMMENT '预警状态 0-不生效 1- 失效',
    `case_department`         varchar(255) DEFAULT NULL COMMENT '承办部门',
    `case_procurator_name`    varchar(255) DEFAULT NULL COMMENT '检察官姓名',
    `case_police_name`        varchar(255) DEFAULT NULL COMMENT '警官/承办人',
    `case_plan_solve_date`    datetime(3) DEFAULT NULL COMMENT '计划处置时间',
    `case_actual_solve_date`  datetime(3) DEFAULT NULL COMMENT '实际处置时间 | 执行时间',
    `case_file_status`        tinyint(2) DEFAULT NULL COMMENT '案件裁决书\\案件移送书 0-未上传，1-已上传',
    `case_supervisory_stream` tinyint(3) DEFAULT NULL COMMENT '监管的流程信息 1-档案创建 2-上传撤销案件裁决书 3-完成',
    `case_agent_type`         tinyint(3) DEFAULT NULL COMMENT '1-检察官 2-公安民警',
    `case_process_start_time` datetime(3) DEFAULT CURRENT_TIMESTAMP (3) COMMENT '操作员开始操作时间\n',
    `case_follow_info`        int(32) DEFAULT '0' COMMENT '案件跟踪信息表',
    `case_detection_info`     int(32) DEFAULT '0' COMMENT '案件侦查信息代填数',
    `no_catch_first_type`     tinyint(3) DEFAULT NULL COMMENT '案件所属不捕类型  1：不构成犯罪不捕；2：无逮捕必要不捕；3：证据不足不捕',
    `no_catch_second_type`    tinyint(3) DEFAULT NULL COMMENT '案件所属不捕情形  1：不构成犯罪不捕：没有犯罪事实不捕、符合刑诉法第16条不捕； 2：无逮捕必要不捕：调查后排除非法证据不捕、证据不足其他情形不捕；3：证据不足不捕：认罪认罚或刑事和解不捕、无社会危险性其他情形不捕',
    `no_catch_details`        varchar(512) DEFAULT NULL COMMENT '不捕情形',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COMMENT='预警表'














