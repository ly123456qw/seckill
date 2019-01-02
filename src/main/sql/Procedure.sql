-- 存储过程
DELIMITER $$ -- 把 " ; " 结尾换成 " $$ " 结尾
-- 定义存储过程
create procedure `seckill`.`execute_seckill`
-- 参数 in 代表输入参数  out 代表输出参数
(in v_seckill_id bigint, in v_phone bigint, in v_kill_time timestamp, out r_result int )
begin
  declare insert_count int default 0;
  start transaction ;
  insert ignore into success_killed
    (seckill_id, user_phone, create_time)
    values (v_seckill_id, v_phone, v_kill_time);

  -- row_count(): 返回上一条修改类型 SQL (insert, delete, update) 的影响行数
  -- rown_count: 0 代表未修改数据、>0 代表修改的行数、<0 代表 SQL 错误或者没有执行SQL
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
end ;
$$ -- 代表存储过程定义结束

-- 调用存储过程
declare ; -- 修改回之前的 " ; " 结尾
-- 定义变量
set @r_result = -3;
-- 执行存储过程
call execute_seckill(1005, 12345678900, now(), @r_result);
-- 获取结果
select @r_result;
