use azuapi;

-- 接口信息表
create table if not exists azuapi.`interface_info`
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `name` varchar(256) not null comment '接口名称',
    `url` varchar(512) not null comment '接口地址',
    `method` varchar(256) not null comment '请求类型',
    `description` varchar(256) null comment '接口描述信息',
    `requestHeader` text null comment '请求头信息',
    `reponseHeader` text null comment '响应头信息',
    `userId` bigint not null comment '创建人',
    `status` tinyint not null comment '接口状态（0 关闭，1开启）',
    `create_time` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `update_time` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `is_deleted` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
    ) comment '接口信息表';
-- 接口信息表 模拟数据
insert into azuapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `reponseHeader`, `userId`, `status`) values ('BW', 'www.tenesha-gutkowski.com', '2Dv', 'Un', 'K0IT', 'Hz', 4584, 1);
insert into azuapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `reponseHeader`, `userId`, `status`) values ('JBI', 'www.bobby-schroeder.co', '1OiSP', '36u2', 'zY', 'xWr1k', 265809, 1);
insert into azuapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `reponseHeader`, `userId`, `status`) values ('z4US', 'www.darell-harber.net', 'sCgt', 'y8s', 'f1x0B', 'VhnY', 69405, 1);
insert into azuapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `reponseHeader`, `userId`, `status`) values ('coyJN', 'www.pearlene-grady.org', 'N5CI', 'kxP', 'Ak', 'ND2', 438062635, 1);
insert into azuapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `reponseHeader`, `userId`, `status`) values ('dJHg', 'www.duane-powlowski.net', 'J9x', 'rZlw', 'f7mnF', 'B1Ae', 3587562, 1);
insert into azuapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `reponseHeader`, `userId`, `status`) values ('KrKTs', 'www.shelby-emmerich.info', 'yo', '5nA', '0OsRt', 'TnO', 43366662, 1);
insert into azuapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `reponseHeader`, `userId`, `status`) values ('LnvrG', 'www.jewell-stark.name', '8CR', 'TjbW', '8M', 'cqh', 80337, 1);
insert into azuapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `reponseHeader`, `userId`, `status`) values ('vk', 'www.bruno-weimann.org', 'WCf5J', '5Xk', 'tqP', 'cgI', 2329173, 1);
insert into azuapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `reponseHeader`, `userId`, `status`) values ('A5Wj', 'www.barrett-kuhic.com', 'Jjh', '4rgq', 'j0X', 'E6OAu', 749041, 1);
insert into azuapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `reponseHeader`, `userId`, `status`) values ('15', 'www.karl-shields.net', '2MFIl', 'oTG1', '0KZ', 'OIc', 7, 1);