-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.19-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  过程 seckill.execute_seckill 结构
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `execute_seckill`(in v_seckill_id bigint, in v_phone bigint, in v_kill_time timestamp, out r_result int )
begin
  declare insert_count int default 0;
  start transaction ;
  insert ignore into success_killed
    (seckill_id, user_phone, create_time)
    values (v_seckill_id, v_phone, v_kill_time);

  
  
  select row_count() into insert_count;
  if (insert_count = 0) then
    rollback ;
    set r_result = -1;
  elseif (insert_count < 0) then
    rollback ;
    set r_result = -2;
  else
    update seckill.seckill
      set number = number - 1
      where seckill_id = v_seckill_id
      and end_time > v_kill_time
      and start_time < v_kill_time
      and number > 0;
    select row_count() into insert_count;
    if (insert_count = 0) then
      rollback ;
      set r_result = -1;
    elseif (insert_count < 0) then
      rollback ;
      set r_result = -2;
    else
      commit ;
      set r_result = 1;
    end if;
  end if;
end//
DELIMITER ;

-- 导出  表 seckill.seckill 结构
CREATE TABLE IF NOT EXISTS `seckill` (
  `seckill_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
  `name` varchar(120) NOT NULL COMMENT '库存名称',
  `number` int(11) NOT NULL COMMENT '库存数量',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '秒杀开启时间',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '秒杀结束时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '状态信息',
  PRIMARY KEY (`seckill_id`),
  KEY `idx_start_time` (`start_time`),
  KEY `idx_end_time` (`end_time`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1031 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

-- 正在导出表  seckill.seckill 的数据：~22 rows (大约)
/*!40000 ALTER TABLE `seckill` DISABLE KEYS */;
INSERT INTO `seckill` (`seckill_id`, `name`, `number`, `start_time`, `end_time`, `create_time`, `status`) VALUES
	(1000, '测', 2, '2018-10-15 10:57:06', '2018-10-21 00:00:00', '2018-04-25 15:11:13', 1),
	(1001, '2000 抢购MacBook Air', 200, '2018-10-15 10:59:23', '2018-05-09 00:00:00', '2018-04-25 15:11:13', 0),
	(1002, '3000 抢购MacBook', 300, '2018-10-15 10:57:17', '2018-05-03 00:00:00', '2018-04-25 15:11:13', 1),
	(1003, '5000 抢购ThinkPad E', 400, '2018-10-15 10:57:18', '2018-06-05 00:00:00', '2018-04-25 15:11:13', 1),
	(1004, '6000 抢购ThinkPad X', 200, '2018-10-15 10:57:19', '2018-06-09 00:00:00', '2018-04-25 15:11:13', 1),
	(1005, '2000 抢购iMac', 598, '2018-10-15 10:57:20', '2018-05-09 00:00:00', '2018-04-25 15:11:13', 1),
	(1006, '3000 抢购MacBook Pro', 300, '2018-04-12 00:00:00', '2018-05-03 00:00:00', '2018-04-25 15:11:13', 0),
	(1007, '5000 抢购ThinkPad E1', 4080, '2018-04-19 00:00:00', '2018-06-05 00:00:00', '2018-04-25 15:11:13', 0),
	(1008, '6000 抢购ThinkPad X1', 2000, '2018-04-16 00:00:00', '2018-06-09 00:00:00', '2018-04-25 15:11:13', 0),
	(1009, '2000 抢购MacBook 2018', 1, '2018-04-28 00:00:00', '2018-05-09 00:00:00', '2018-04-25 15:11:13', 0),
	(1010, '3000 抢购MacBook Pro 2019', 5300, '2018-04-22 00:00:00', '2018-05-03 00:00:00', '2018-04-25 15:11:13', 0),
	(1011, '5000 抢购ThinkPad E2', 4060, '2018-04-19 00:00:00', '2018-06-05 00:00:00', '2018-04-25 15:11:13', 0),
	(1012, '6000 抢购ThinkPad X2', 20, '2018-03-06 00:00:00', '2018-06-09 00:00:00', '2018-04-25 15:11:13', 0),
	(1013, '1000 抢购ROG', 100, '2018-10-24 13:11:23', '2018-05-01 00:00:00', '2018-04-25 15:12:28', 1),
	(1014, '2000 抢购MacBook Air', 200, '2018-10-15 15:39:13', '2018-05-09 00:00:00', '2018-04-25 15:12:28', 1),
	(1015, '3000 抢购MacBook', 300, '2018-04-12 00:00:00', '2018-05-03 00:00:00', '2018-04-25 15:12:28', 0),
	(1016, '50抢购ThinkPad E', 400, '2018-10-15 10:00:00', '2018-12-05 00:00:00', '2018-04-25 15:12:28', 0),
	(1017, '6000 抢购ThinkPad X', 200, '2018-10-15 10:35:12', '2018-06-09 00:00:00', '2018-04-25 15:12:28', 1),
	(1018, '2000 抢购iMac', 600, '2018-10-15 10:35:11', '2018-05-09 00:00:00', '2018-04-25 15:12:28', 1),
	(1019, '3000 抢购', 3, '2018-10-15 10:33:39', '2018-10-03 00:00:00', '2018-04-25 15:12:28', 1),
	(1020, '5000 抢购ThinkPad E1', 4080, '2018-10-15 10:35:10', '2018-06-05 00:00:00', '2018-04-25 15:12:28', 1),
	(1029, 'T1-Try', 20, '2018-10-24 10:04:30', '2029-10-10 10:10:10', '2018-10-15 10:24:51', 0),
	(1030, 'TYHJD123', 12, '2018-10-26 10:54:09', '2018-12-26 10:54:09', '2018-10-26 10:54:09', 0);
/*!40000 ALTER TABLE `seckill` ENABLE KEYS */;

-- 导出  表 seckill.success_killed 结构
CREATE TABLE IF NOT EXISTS `success_killed` (
  `seckill_id` bigint(20) NOT NULL COMMENT '秒杀商品ID',
  `user_phone` bigint(20) NOT NULL COMMENT '用户手机号',
  `state` tinyint(4) NOT NULL DEFAULT '-1' COMMENT '-1表示无效，0表示成功，1表示已付款',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`seckill_id`,`user_phone`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';

-- 正在导出表  seckill.success_killed 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `success_killed` DISABLE KEYS */;
INSERT INTO `success_killed` (`seckill_id`, `user_phone`, `state`, `create_time`) VALUES
	(1000, 12345678900, -1, '2018-04-26 14:36:28'),
	(1001, 12345678900, 0, '2018-04-26 14:49:25'),
	(1002, 12345678900, 0, '2018-04-26 14:57:54'),
	(1003, 12345678900, 0, '2018-04-26 14:50:30'),
	(1004, 12345678900, 0, '2018-04-26 15:02:10'),
	(1005, 12345678900, 0, '2018-04-28 11:05:17'),
	(1005, 12345678901, 0, '2018-04-28 11:09:42');
/*!40000 ALTER TABLE `success_killed` ENABLE KEYS */;

-- 导出  表 seckill.users_message 结构
CREATE TABLE IF NOT EXISTS `users_message` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户创建时间',
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '用户状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户信息';

-- 正在导出表  seckill.users_message 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `users_message` DISABLE KEYS */;
INSERT INTO `users_message` (`id`, `name`, `password`, `create_time`, `status`) VALUES
	(1, 'A用户', '123456', '2018-10-15 16:26:47', 0),
	(2, 'B', '123', '2018-10-16 09:02:00', 0),
	(3, 'C', '123', '2018-10-16 09:07:55', 0),
	(4, '大夫', '123', '2018-10-24 12:57:34', 0),
	(5, 'test', '123', '2018-10-25 12:15:20', 0),
	(6, 'admin', '123', '2018-12-21 21:26:11', 0);
/*!40000 ALTER TABLE `users_message` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
