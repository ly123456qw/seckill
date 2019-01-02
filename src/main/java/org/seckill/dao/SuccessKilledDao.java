package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * @author Sori
 */
public interface SuccessKilledDao {

    /**
      * @author Sori
      * @Description 插入购买明细，可过滤重复（联合唯一主键）
      * @Date 15:44 2018/4/25
      * @Param
      * @return
      */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
      * @author Sori
      * @Description 根据 ID 查询 SuccessKilled 并携带秒杀产品对象实体
      * @Date 15:43 2018/4/25
      * @Param
      * @return
      */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
