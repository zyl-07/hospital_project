-- grant all on hospital.* to 'root'@ '%' identified by '123456' with grant option ;-- 创建数据库
-- 创建数据库
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%'WITH GRANT OPTION;
flush privileges ;
use hospital;
-- 建表
drop table if exists  login_log;
drop table if exists  manager_system_log;
drop table if exists  operation_log;
CREATE TABLE `login_log`
(
    `login_log_id` int NOT NULL AUTO_INCREMENT,
    `ip_address`   varchar(200)  DEFAULT NULL COMMENT '登录的ip地址',
    `login_time`   datetime      DEFAULT NULL COMMENT '登录时间',
    `log_level`    varchar(30)   DEFAULT NULL COMMENT '该记录的等级',
    `user_id`      varchar(10)   DEFAULT NULL COMMENT '当前操作的人的id',
    `message`      varchar(4000) DEFAULT NULL COMMENT '操作的信息',
    `delete_flag`  char(5)       DEFAULT '0' COMMENT '删除标志位，0为存在，1为删除',
    PRIMARY KEY (`login_log_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
    COMMENT ='登录日志表，记录使用该系统的用户的登录操作(是谁登录的，登录是否成功，什么时候登录的)';

CREATE TABLE `manager_system_log`
(
    `manager_system_log_id` int NOT NULL AUTO_INCREMENT,
    `class_name`            varchar(200)  DEFAULT NULL COMMENT '发生错误的类名',
    `method_name`           varchar(100)  DEFAULT NULL COMMENT '发生错误的方法名',
    `create_time`           datetime      DEFAULT NULL COMMENT '发生的时间',
    `log_level`             varchar(30)   DEFAULT NULL COMMENT '该记录的等级',
    `message`               varchar(4000) DEFAULT NULL COMMENT '错误的信息',
    `delete_flag`           char(5)       DEFAULT '0' COMMENT '删除标志位，0为存在，1为删除',
    PRIMARY KEY (`manager_system_log_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='系统日志表，记录使用该系统的运行状况，如果出现异常则写进该表';

CREATE TABLE `operation_log`
(
    `operation_log_id` int NOT NULL AUTO_INCREMENT,
    `log_level`        varchar(30)   DEFAULT NULL COMMENT '该记录的等级',
    `operation_time`   datetime      DEFAULT NULL COMMENT '操作时间',
    `message`          varchar(4000) DEFAULT NULL COMMENT '操作信息，要包含操作成功与否，如新建项目如果成功为新建项目成功',
    `user_id`          varchar(10)   DEFAULT NULL COMMENT '操作用户id',
    `delete_flag`      char(5)       DEFAULT '0' COMMENT '删除标志位，0为存在，1为删除',
    PRIMARY KEY (`operation_log_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='操作日志表，记录什么用户什么时候做了什么操作';
-- 插入数据
insert into user(addr,brthday,email,invite_code,password,phone_number,rname,sex,username)
values('四川师范大学','1999.4','231@qq.com','2322','d022646351048ac0ba397d12dfafa304','12323231','小王','m','admin');
insert into user(addr,brthday,email,invite_code,password,phone_number,rname,sex,username)
values('四川师范大学','1999.4','231@qq.com','2322','d022646351048ac0ba397d12dfafa304','12323231','小王','m','xw');
insert into user(addr,brthday,email,invite_code,password,phone_number,rname,sex,username)
values('四川师范大学','1999.4','231@qq.com','2322','d022646351048ac0ba397d12dfafa304','12323231','小王','m','xm');
insert into ware(wname) values('西药库');
insert into ware(wname) values('中药库');
insert into ware(wname) values('其他药库');
insert into drugs(dname,dclassify,dnumber,cqnumber,dunit,dprice,jdtime,prodata,duedata,wid)
values('111','感冒药',100,100,'盒',23.5,'2','2020/11/19','2022/11/19',1);
insert into drugs(dname,dclassify,dnumber,cqnumber,dunit,dprice,jdtime,prodata,duedata,wid)
values('222','感冒药',100,100,'盒',23.5,'2','2020/11/19','2022/11/19',1);
insert into drugs(dname,dclassify,dnumber,cqnumber,dunit,dprice,jdtime,prodata,duedata,wid)
values('333','感冒药',100,100,'盒',23.5,'2','2020/11/19','2022/11/19',1);
insert into drugs(dname,dclassify,dnumber,cqnumber,dunit,dprice,jdtime,prodata,duedata,wid)
values('444','感冒药',100,100,'盒',23.5,'2','2020/11/19','2022/11/19',2);
insert into drugs(dname,dclassify,dnumber,cqnumber,dunit,dprice,jdtime,prodata,duedata,wid)
values('555','感冒药',100,100,'盒',23.5,'2','2020/11/19','2022/11/19',2);
insert into drugs(dname,dclassify,dnumber,cqnumber,dunit,dprice,jdtime,prodata,duedata,wid)
values('666','感冒药',100,100,'盒',23.5,'2','2020/11/19','2022/11/19',2);
insert into drugs(dname,dclassify,dnumber,cqnumber,dunit,dprice,jdtime,prodata,duedata,wid)
values('777','感冒药',100,100,'盒',23.5,'2','2020/11/19','2022/11/19',3);
insert into drugs(dname,dclassify,dnumber,cqnumber,dunit,dprice,jdtime,prodata,duedata,wid)
values('888','感冒药',100,100,'盒',23.5,'2','2020/11/19','2022/11/19',3);
insert into drugs(dname,dclassify,dnumber,cqnumber,dunit,dprice,jdtime,prodata,duedata,wid)
values('999','感冒药',100,100,'盒',23.5,'2','2020/11/19','2022/11/19',3);
insert into role(rname) values('admin');
insert into role(rname) values('仓库管理员');
insert into role(rname) values('采购管理员');
insert into role(rname) values('领药管理员');
insert into role(rname)  values('财务管理员');

insert into user_role(uid,rid) values(1,1);

insert into permission(pname) values('查看药品信息');
insert into permission(pname) values('编辑药品信息');
insert into permission(pname) values('编辑出库');
insert into permission(pname) values('编辑入库');
insert into permission(pname) values('编辑采购');
insert into permission(pname) values('编辑领药');
insert into permission(pname) values('药品盘存');






