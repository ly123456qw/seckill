package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

// 在 Junit 启动的时候加载 Spring 容器
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉 Junit Spring 的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    // 注入 DAO 实现类依赖
    @Resource
    private SeckillDao seckillDao;

    private final static Logger logger = LoggerFactory.getLogger(SeckillDaoTest.class);
    @Test
    public void queryById() throws Exception{
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {

        // Java 不能识别多个形参参数，  List<Seckill> queryAll(int offset, int limit) 会被 Java 当作 List<Seckill> queryAll(args0, args1);，所以需要加上 @Param("offset")
        List<Seckill> seckills = seckillDao.queryAll(0, 100, 0);
        for (Seckill seckill : seckills) {
            System.out.println(seckill);
        }
    }

    @Test
    public void reduceNumber() {
        Date killTime = new Date();
        int reduceNumbers = seckillDao.reduceNumber(1000L, killTime);
        System.out.println("reduceNumbers -> " + reduceNumbers);
    }

    /**
     * 更新测试
     */
    @Test
    public void updateOrders() {
        Long id = 1000L;
        Seckill seckill = seckillDao.queryById(id);
        seckill.setName("测");
        seckill.setNumber(2);
        seckill.setStartTime(new Date());
        seckillDao.updateOrders(seckill);
        logger.info(seckill.toString());
    }

    /**
     * 删除测试
     */
    @Test
    public void deleteOrders() {
        Integer id = 1025;
        Seckill seckill = seckillDao.queryById(id);
        logger.info("FIND NAME: " + seckill.getName());
        seckillDao.deleteOrders(id);
        logger.info("DELETE NAME: " + seckill.getName());

    }

    /**
     * 添加测试
     */
    @Test
    public void addOrders() {
        Seckill seckill = new Seckill();
        seckill.setName("NAME");
        seckill.setNumber(2);
        seckill.setStartTime(new Date());
        seckill.setEndTime(new Date());
        seckill.setCreateTime(new Date());
        seckillDao.addorders(seckill);
        logger.info("id -> " + seckill.getSeckillId());
    }

    /**
     * 逻辑删除测试
     */
    @Test
    public void logicallyDeleted() {
        Integer id = 1028;
        Seckill seckill = seckillDao.queryById(id);
        logger.info("id -> " + seckill.getSeckillId() + " &status -> " + seckill.getStatus());
        seckill.setStatus(1);
        seckillDao.logicallyDeleted(seckill);
    }

}