package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SeckillDao {

    /**
      * @author Sori
      * @Description 减库存操作
      * @Date 15:44 2018/4/25
      * @Param
      * @return
      */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
      * @author Sori
      * @Description 根据ID查询秒杀对象
      * @Date 15:44 2018/4/25
      * @Param
      * @return
      */
    Seckill queryById(long seckillId);

    /**
      * @author Sori
      * @Description 根据偏移量查询秒杀商品列表
      * @Date 15:44 2018/4/25
      * @Param
      * @return
      */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit, @Param("status") int status);

    /**
     * 更新商品列表信息
     * @param seckill
     * @return
     */
    int updateOrders(Seckill seckill);

    /**
     * 删除对应列表信息
     * @param id
     * @return
     */
    int deleteOrders(Integer id);

    /**
     * 添加信息
     * @param seckill
     * @return
     */
    Integer addorders(Seckill seckill);

    /**
     * 逻辑删除
     * @param status
     * @return
     */
    Integer logicallyDeleted(Seckill status);

    /**
     * 使用存储过程执行操作
     * @param paramMap
     */
    void killByProcedure(Map<String, Object> paramMap);
}
