-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE seckill;

-- 使用数据库
use seckill;

-- 创建秒杀库存表
create table seckill (
`seckill_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
`name` VARCHAR (120) NOT NULL COMMENT '库存名称',
`number` INT NOT NULL COMMENT '库存数量',
`start_time` TIMESTAMP NOT NULL COMMENT '秒杀开启时间',
`end_time` TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (seckill_id),
KEY idx_start_time(start_time),
KEY idx_end_time(end_time),
KEY idx_create_time(create_time)
)ENGINE = InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET = UTF8 COMMENT = '秒杀库存表';

-- 添加一条字段
ALTER TABLE `seckill`
        ADD COLUMN `status` INT(1) NOT NULL DEFAULT '0' COMMENT '状态信息' AFTER `create_time`;


-- 初始化数据
INSERT INTO seckill (name, number, start_time, end_time)
VALUES ('1000 抢购ROG', 100, '2018-4-1 00:00:00', '2018-5-1 00:00:00'),
        ('2000 抢购MacBook Air', 200, '2018-4-8 00:00:00', '2018-5-9 00:00:00'),
        ('3000 抢购MacBook', 300, '2018-4-12 00:00:00', '2018-5-3 00:00:00'),
        ('5000 抢购ThinkPad E', 400, '2018-4-9 00:00:00', '2018-6-5 00:00:00'),
        ('6000 抢购ThinkPad X', 200, '2018-4-6 00:00:00', '2018-6-9 00:00:00'),
        ('2000 抢购iMac', 600, '2018-4-7 00:00:00', '2018-5-9 00:00:00'),
        ('3000 抢购MacBook Pro', 300, '2018-4-12 00:00:00', '2018-5-3 00:00:00'),
        ('5000 抢购ThinkPad E1', 4080, '2018-4-19 00:00:00', '2018-6-5 00:00:00'),
        ('6000 抢购ThinkPad X1', 2000, '2018-4-16 00:00:00', '2018-6-9 00:00:00'),
        ('2000 抢购MacBook 2018', 2100, '2018-4-28 00:00:00', '2018-5-9 00:00:00'),
        ('3000 抢购MacBook Pro 2019', 5300, '2018-4-22 00:00:00', '2018-5-3 00:00:00'),
        ('5000 抢购ThinkPad E2', 4060, '2018-4-19 00:00:00', '2018-6-5 00:00:00'),
        ('6000 抢购ThinkPad X2', 20, '2018-3-6 00:00:00', '2018-6-9 00:00:00');

-- 秒杀成功明细表
-- 用户登陆认证相关的信息
CREATE TABLE success_killed(
`seckill_id` BIGINT NOT NULL COMMENT '秒杀商品ID',
`user_phone` BIGINT NOT NULL COMMENT '用户手机号',
`state` TINYINT NOT NULL DEFAULT -1 COMMENT '-1表示无效，0表示成功，1表示已付款',
`create_time` TIMESTAMP NOT NULL COMMENT '创建时间',
PRIMARY KEY(seckill_id, user_phone), /* 联合主键 */
KEY idx_create_time(create_time)
)ENGINE = InnoDB DEFAULT CHARSET = UTF8 COMMENT = '秒杀成功明细表';
