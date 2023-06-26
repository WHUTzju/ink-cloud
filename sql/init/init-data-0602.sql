-- 数据初始化表

-- 配置-模版数据
INSERT INTO no_catch.ta_attachment (id, create_time, update_time, is_delete, file_hash, file_name, file_path,
                                    file_type, case_id)
VALUES (1, '2023-06-02 11:31:46.928', '2023-06-02 11:31:46.928', 0,
        '498cdc8f179422ba2beec4ca4e116d0f984233286cf9affc909aaceecd3889ac', 'personImportTemplate.xlsx',
        'personImportTemplate.xlsx', null, null);

-- 部门-初始部门列表
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (29, '2023-05-26 13:34:29.198', '2023-05-26 14:31:16', 0, '武昌区人民检察院', 1, '第一检察部', 101, '超级管理员', '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (31, '2023-05-26 13:34:29.356', '2023-05-26 14:31:20', 0, '武昌区人民检察院', 1, '第二检察部', 103, '超级管理员', '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (32, '2023-05-26 13:34:29.397', '2023-05-26 14:28:52', 0, '武昌区人民检察院', 1, '第七检察部', 104, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (33, '2023-05-26 13:34:29.680', '2023-05-26 14:28:47', 0, '武昌区人民检察院', 1, '司行局', 105, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (34, '2023-05-26 13:49:03.391', '2023-05-26 17:29:27', 0, '武汉市公安局武昌分局', 2, '中华路所', 201, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (35, '2023-05-26 13:49:03.470', '2023-05-28 16:24:38', 0, '武汉市公安局武昌分局', 2, '白沙洲所', 202, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (36, '2023-05-26 13:49:03.509', '2023-05-26 17:29:27', 0, '武汉市公安局武昌分局', 2, '黄鹤楼所', 203, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (37, '2023-05-26 13:49:03.569', '2023-05-26 17:29:27', 0, '武汉市公安局武昌分局', 2, '禁毒大队', 204, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (38, '2023-05-26 13:49:03.613', '2023-06-01 23:47:00', 0, '武汉市公安局武昌分局', 2, '石洞所', 205, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (39, '2023-05-26 13:49:03.674', '2023-05-26 17:29:27', 0, '武汉市公安局武昌分局', 2, '余家头所', 206, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (40, '2023-05-26 13:49:03.893', '2023-05-28 14:53:24', 0, '武汉市公安局武昌分局', 2, '水果湖所', 207, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (41, '2023-05-26 13:49:03.959', '2023-05-26 17:29:27', 0, '武汉市公安局武昌分局', 2, '东亭所', 208, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (42, '2023-05-26 13:49:04.002', '2023-05-26 17:29:27', 0, '武汉市公安局武昌分局', 2, '刑侦大队', 209, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (43, '2023-05-26 13:49:04.073', '2023-05-26 17:29:27', 0, '武汉市公安局武昌分局', 2, '徐家棚所', 210, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (44, '2023-05-26 13:49:04.118', '2023-05-26 17:29:26', 0, '武汉市公安局武昌分局', 2, '南湖所', 211, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (45, '2023-05-26 13:49:04.298', '2023-05-26 17:29:26', 0, '武汉市公安局武昌分局', 2, '梅苑所', 212, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (46, '2023-05-26 13:49:04.340', '2023-05-26 17:29:26', 0, '武汉市公安局武昌分局', 2, '珞珈山所', 213, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (47, '2023-05-26 13:49:04.381', '2023-05-26 17:29:26', 0, '武汉市公安局武昌分局', 2, '凤凰山所', 214, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (48, '2023-05-26 13:49:04.420', '2023-05-26 17:29:26', 0, '武汉市公安局武昌分局', 2, '杨园所', 215, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (49, '2023-05-26 13:49:04.484', '2023-05-26 17:29:27', 0, '武汉市公安局武昌分局', 2, '中南所', 216, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (50, '2023-05-26 13:49:04.527', '2023-05-26 17:29:27', 0, '武汉市公安局武昌分局', 2, '双湖所', 217, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (51, '2023-05-26 13:49:04.597', '2023-05-26 17:29:27', 0, '武汉市公安局武昌分局', 2, '积玉桥所', 218, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (52, '2023-05-26 13:49:04.668', '2023-05-26 17:29:26', 0, '武汉市公安局武昌分局', 2, '粮道所', 219, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (53, '2023-05-26 13:49:04.709', '2023-05-26 17:29:26', 0, '武汉市公安局武昌分局', 2, '首义所', 220, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (54, '2023-05-26 13:49:04.910', '2023-05-26 17:29:26', 0, '武汉市公安局武昌分局', 2, '站前所', 221, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (55, '2023-05-26 13:49:04.982', '2023-05-26 17:29:26', 0, '武汉市公安局武昌分局', 2, '紫阳所', 222, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (56, '2023-05-26 13:49:05.020', '2023-05-26 17:29:26', 0, '武汉市公安局武昌分局', 2, '汉街所', 223, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (61, '2023-05-26 13:49:03.391', '2023-05-26 17:29:27', 0, '武汉市公安局武昌分局', 2, '经侦大队', 225, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (62, '2023-05-26 13:49:03.391', '2023-05-26 17:29:27', 0, '武汉市公安局武昌分局', 2, '治安大队', 224, null, '武汉市武昌区');
INSERT INTO no_catch.ta_department (id, create_time, update_time, is_delete, department_unit, department_unit_code,
                                    department_name, department_number, create_person, department_region)
VALUES (63, '2023-05-26 13:49:03.391', '2023-05-26 17:29:27', 0, '武汉市公安局武昌分局', 2, '武汉市公安局武昌分局', 250, null, '武汉市武昌区');


-- 用户数据
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('0e3c70e3b1742af666161fc675a5f565', '2023-05-28 14:42:23.207', '2023-05-30 10:12:02.556', 0, '龚雪', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 11, 0, 0, '超级管理员', 29, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('0f66a6c9b7c4c7984579973f310926c8', '2023-05-28 14:51:55.933', '2023-05-31 22:15:10.984', 0, '朱以清', '0000-0000',
        '3d032b7e7bddf70ad68440013fcfe3d9', 22, 0, 0, '超级管理员', 63, 2);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('1387ad1a6f4c1bf9915c91150bd69472', '2023-05-28 14:43:06.432', '2023-05-30 09:40:46.038', 0, '陈骞', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 11, 0, 0, '超级管理员', 29, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('28509bf01e83efd43ff846756fef533c', '2023-05-28 14:53:08.294', '2023-05-31 22:15:10.984', 0, '杨波', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 22, 0, 0, '超级管理员', 63, 2);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('352ad6035804638f36d488b28f844b85', '2023-05-28 14:58:37.916', '2023-05-31 22:15:10.984', 0, '包政敏', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 22, 0, 0, '超级管理员', 63, 2);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('37ead15a599d482e2412e098f678ffbf', '2023-05-28 14:42:01.727', '2023-05-30 09:40:54.119', 0, '何伟', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 12, 0, 0, '超级管理员', 29, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('3b9d5e9774ee7525e8ea6b4c61ff6be0', '2023-05-28 14:49:59.946', '2023-05-31 22:15:10.984', 0, '马昊', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 21, 0, 0, '超级管理员', 63, 2);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('3e59397f5f3a36311919c4e7ad8c5af9', '2023-05-28 14:52:50.628', '2023-05-31 22:15:10.984', 0, '龙军', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 22, 0, 0, '超级管理员', 63, 2);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('3edac311d304a66522376c9172366cbf', '2023-05-28 14:58:18.021', '2023-05-31 22:15:10.984', 0, '程凯', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 22, 0, 0, '超级管理员', 63, 2);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('42d5f6a47459f4b6bfaf1346f5cc0c11', '2023-05-28 14:57:25.901', '2023-05-31 22:15:10.984', 0, '陈长峰', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 22, 0, 0, '超级管理员', 63, 2);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('580f0ac8e45b16d260ee8c7425bd19d1', '2023-05-28 14:04:20.123', '2023-05-28 14:04:20.123', 0, '李耿东', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 13, 0, 0, '超级管理员', 29, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('5c50b46f83e43425c8a887a707b750d5', '2023-05-28 14:43:41.553', '2023-05-28 14:43:41.553', 0, '何秋珠', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 11, 0, 0, '超级管理员', 31, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('5c819fa3596356852ccb7a624886d91c', '2023-05-28 14:45:10.223', '2023-05-28 14:45:10.223', 0, '徐永芳', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 12, 0, 0, '超级管理员', 32, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('63cb544a11bc188f64772f9f31e59ace', '2023-05-28 14:44:03.917', '2023-05-28 14:44:03.917', 0, '李廷', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 11, 0, 0, '超级管理员', 31, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('65e3e4f04a44bcb724a2ec58cb6cb418', '2023-05-28 14:45:56.295', '2023-05-28 14:45:56.295', 0, '王丽', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 15, 0, 0, '超级管理员', 29, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('696807672632e423d36b787377a1c8eb', '2023-05-28 14:42:34.207', '2023-05-28 14:42:34.207', 0, '叶涵', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 11, 0, 0, '超级管理员', 29, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('6a04e7df4c446577b982898dc82b3085', '2023-05-28 14:45:26.798', '2023-05-28 14:45:26.798', 0, '刘朝欣', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 11, 0, 0, '超级管理员', 32, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('6aba8de46cf834d5cdf4964ea9f2d7e9', '2023-05-28 14:42:57.745', '2023-05-28 14:42:57.745', 0, '刘磊', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 11, 0, 0, '超级管理员', 29, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('809d0274ca2f444c77d166468d7e67e3', '2023-05-28 14:54:26.066', '2023-05-31 22:15:10.984', 0, '方奕文', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 22, 0, 0, '超级管理员', 63, 2);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('82489a491d6f8ce2d2f2cbc70579ebe5', '2023-05-28 14:46:25.412', '2023-05-28 14:46:25.412', 0, '林晓辉', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 14, 0, 0, '超级管理员', 33, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('85379258ea4c6400711511460146193a', '2023-05-28 14:53:54.599', '2023-05-31 22:15:10.984', 0, '余鹏', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 22, 0, 0, '超级管理员', 63, 2);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('9060637186d1dae07d8650f1fc027a66', '2023-05-28 14:59:03.164', '2023-05-31 22:15:10.984', 0, '柳发达', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 22, 0, 0, '超级管理员', 63, 2);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('91765fdb5e4163a9c041370a4213279b', '2023-05-28 14:44:43.046', '2023-05-28 14:44:43.047', 0, '高素', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 11, 0, 0, '超级管理员', 31, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('984738f54c5844a7bdd5c48c02a257b5', '2023-05-28 14:57:54.161', '2023-05-31 22:15:10.984', 0, '赵子豪', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 22, 0, 0, '超级管理员', 63, 2);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('9dac71e2a5a121cdd920f2403a8bfe2a', '2023-05-28 14:43:31.656', '2023-05-28 14:43:31.656', 0, '张薇', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 12, 0, 0, '超级管理员', 31, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('aaac734b5a5c9392e61b403510659e3b', '2023-05-28 14:59:26.427', '2023-05-31 22:15:10.984', 0, '余杰', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 22, 0, 0, '超级管理员', 63, 2);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('ad4e4982e3e3fe2115d9b35e2199bdfc', '2023-05-28 14:50:16.689', '2023-05-31 22:15:10.984', 0, '贡志杰', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 23, 0, 0, '超级管理员', 63, 2);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('b145640a7ccbd87561820349a4cced28', '2023-05-28 14:51:14.548', '2023-05-31 22:15:10.984', 0, '袁松', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 22, 0, 0, '超级管理员', 63, 2);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('b38b632b66632dd6adc1891d9ab17e2d', '2023-05-28 14:44:51.793', '2023-05-28 14:44:51.793', 0, '曹世兴', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 11, 0, 0, '超级管理员', 31, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('b83f13ab3b5328b7025694f8c283e31f', '2023-05-28 14:43:56.619', '2023-05-28 14:43:56.619', 0, '刘子秋', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 11, 0, 0, '超级管理员', 31, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('b96fc1d57cac020b7f04c1384a1f6731', '2023-05-28 14:59:51.178', '2023-05-31 22:15:10.984', 0, '屈祥喜', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 22, 0, 0, '超级管理员', 63, 2);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('d29157ad62777c11f556748b86d85dff', '2023-05-28 14:53:37.131', '2023-05-31 22:15:10.984', 0, '李娜', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 22, 0, 0, '超级管理员', 63, 2);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('d5b58d01cbbc77edd22c8e45940c7caa', '2023-05-28 14:42:44.765', '2023-05-28 14:42:44.765', 0, '闫倩倩', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 11, 0, 0, '超级管理员', 29, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('eaff8f6990f250d7d8182deed5ed322d', '2023-05-28 14:44:12.804', '2023-05-28 14:44:12.804', 0, '王胄鑫', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 11, 0, 0, '超级管理员', 31, 1);
INSERT INTO no_catch.ta_user (id, create_time, update_time, is_delete, user_name, user_mobile, user_password,
                              user_role, user_status, fail_times, user_creator, user_department_id, user_unit_code)
VALUES ('fa0eb8b2c9a847817f122e735fad9e76', '2023-05-28 15:00:12.632', '2023-05-31 22:15:10.984', 0, '邹倩', '0000-0000',
        '94c62a2df2d47a66f719e52394d1430d', 22, 0, 0, '超级管理员', 63, 2);

-- 管辖单位关系
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (30, '2023-05-28 14:51:14.666', '2023-05-28 14:51:15', 0, 'b145640a7ccbd87561820349a4cced28', '袁松', 34, 2,
        '中华路所', 201, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (31, '2023-05-28 14:51:14.686', '2023-05-28 14:51:15', 0, 'b145640a7ccbd87561820349a4cced28', '袁松', 35, 2, '白沙洲所',
        202, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (32, '2023-05-28 14:51:56.002', '2023-05-28 14:51:56', 0, '0f66a6c9b7c4c7984579973f310926c8', '朱以清', 36, 2,
        '黄鹤楼所', 203, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (33, '2023-05-28 14:51:56.006', '2023-05-28 14:51:56', 0, '0f66a6c9b7c4c7984579973f310926c8', '朱以清', 37, 2,
        '禁毒大队', 204, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (34, '2023-05-28 14:52:50.677', '2023-05-28 14:52:51', 0, '3e59397f5f3a36311919c4e7ad8c5af9', '龙军', 38, 2,
        '石洞所', 205, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (35, '2023-05-28 14:53:08.351', '2023-05-28 14:53:08', 0, '28509bf01e83efd43ff846756fef533c', '杨波', 39, 2,
        '余家头所', 206, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (36, '2023-05-28 14:53:37.205', '2023-05-28 14:53:37', 0, 'd29157ad62777c11f556748b86d85dff', '李娜', 40, 2,
        '水果湖所', 207, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (37, '2023-05-28 14:53:54.659', '2023-05-28 14:53:55', 0, '85379258ea4c6400711511460146193a', '余鹏', 41, 2, '东亭所',
        208, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (38, '2023-05-28 14:54:26.146', '2023-05-28 14:54:26', 0, '809d0274ca2f444c77d166468d7e67e3', '方奕文', 42, 2,
        '刑侦大队', 209, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (39, '2023-05-28 14:54:26.151', '2023-05-28 14:54:26', 0, '809d0274ca2f444c77d166468d7e67e3', '方奕文', 43, 2,
        '徐家棚所', 210, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (40, '2023-05-28 14:57:25.963', '2023-05-28 14:57:26', 0, '42d5f6a47459f4b6bfaf1346f5cc0c11', '陈长峰', 44, 2,
        '南湖所', 211, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (41, '2023-05-28 14:57:25.965', '2023-05-28 14:57:26', 0, '42d5f6a47459f4b6bfaf1346f5cc0c11', '陈长峰', 62, 2,
        '治安大队', 224, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (42, '2023-05-28 14:57:54.274', '2023-05-28 14:57:54', 0, '984738f54c5844a7bdd5c48c02a257b5', '赵子豪', 45, 2,
        '梅苑所', 212, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (43, '2023-05-28 14:57:54.278', '2023-05-28 14:57:54', 0, '984738f54c5844a7bdd5c48c02a257b5', '赵子豪', 61, 2,
        '经侦大队', 225, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (44, '2023-05-28 14:58:18.083', '2023-05-28 14:58:18', 0, '3edac311d304a66522376c9172366cbf', '程凯', 46, 2,
        '珞珈山所', 213, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (45, '2023-05-28 14:58:18.086', '2023-05-28 14:58:18', 0, '3edac311d304a66522376c9172366cbf', '程凯', 47, 2,
        '凤凰山所', 214, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (46, '2023-05-28 14:58:37.964', '2023-05-28 14:58:38', 0, '352ad6035804638f36d488b28f844b85', '包政敏', 48, 2,
        '杨园所', 215, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (47, '2023-05-28 14:59:03.224', '2023-05-28 14:59:03', 0, '9060637186d1dae07d8650f1fc027a66', '柳发达', 49, 2,
        '中南所', 216, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (48, '2023-05-28 14:59:03.226', '2023-05-28 14:59:03', 0, '9060637186d1dae07d8650f1fc027a66', '柳发达', 50, 2,
        '双湖所', 217, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (49, '2023-05-28 14:59:26.485', '2023-05-28 14:59:26', 0, 'aaac734b5a5c9392e61b403510659e3b', '余杰', 51, 2,
        '积玉桥所', 218, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (50, '2023-05-28 14:59:26.488', '2023-05-28 14:59:26', 0, 'aaac734b5a5c9392e61b403510659e3b', '余杰', 52, 2, '粮道所',
        219, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (51, '2023-05-28 14:59:51.242', '2023-05-28 14:59:51', 0, 'b96fc1d57cac020b7f04c1384a1f6731', '屈祥喜', 53, 2,
        '首义所', 220, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (52, '2023-05-28 14:59:51.245', '2023-05-28 14:59:51', 0, 'b96fc1d57cac020b7f04c1384a1f6731', '屈祥喜', 54, 2,
        '站前所', 221, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (53, '2023-05-28 15:00:12.711', '2023-05-28 15:00:13', 0, 'fa0eb8b2c9a847817f122e735fad9e76', '邹倩', 55, 2, '紫阳所',
        222, null, '武汉市武昌区', '武汉市公安局武昌分局');
INSERT INTO no_catch_test.ta_user_department (id, create_time, update_time, is_delete, user_id, user_name,
                                              department_id, department_unit_code, department_name, department_number,
                                              create_person, department_region, department_unit)
VALUES (54, '2023-05-28 15:00:12.714', '2023-05-28 15:00:13', 0, 'fa0eb8b2c9a847817f122e735fad9e76', '邹倩', 56, 2, '汉街所',
        223, null, '武汉市武昌区', '武汉市公安局武昌分局');

























