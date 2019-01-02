package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;
import java.util.Map;

/**
 * 业务接口：站在 “使用者” 的角度来设计
 * 三个方面：方法定义粒度、参数、返回类型
 */
public interface SeckillSerivce {

    /**
     * @return
     * @author Sori
     * @Description 需要个列表，查询所有秒杀记录
     * @Date 15:26 2018/4/26
     * @Param
     */
    List<Seckill> getSeckillList();

    /**
     * @return
     * @author Sori
     * @Description 查询单个秒杀记录
     * @Date 15:28 2018/4/26
     * @Param
     */
    Seckill getById(long seckillId);

    /**
     * @return
     * @author Sori
     * @Description 秒杀开始则暴露输出秒杀地址，否则就输出当前时间和秒杀时间
     * @Date 15:37 2018/4/26
     * @Param
     */
    Exposer exposerSeckillUrl(long seckillId);

    /**
     * @return
     * @author Sori
     * @Description 执行秒杀操作
     * @Date 15:46 2018/4/26
     * @Param * @param null
     */
    SeckillExecution executionSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException;

    /**
     * 更新商品列表信息
     * @param seckill
     * @return
     */
    int updateOrders(Seckill seckill);

    /**
     * 删除对应列表
     * @param id
     * @return
     */
    int deleteOrders(Integer id);

    /**
     * 添加信息
     * @param seckill
     * @return
     */
    Integer addOrders(Seckill seckill);

    /**
     * 查询还待原的列表
     * @return
     */
    List<Seckill> recycleBinList();

    /**
     * 逻辑删除
     * @param status
     * @return
     */
    Integer logicallyDeleted(Seckill status);

    /**
     * 执行操作调用存储过程
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    SeckillExecution executionSeckillProcedure(long seckillId, long userPhone, String md5);

}
