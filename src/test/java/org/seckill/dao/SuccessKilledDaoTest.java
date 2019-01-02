package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

// 告诉 Junit4 在启动的时候加载 Spring IOC 容器
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉 Junit4 Spring 的路径位置
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() {
        long id = 1004L;
        long phone = 12345678900L;
        int insertSuccessKilleds = successKilledDao.insertSuccessKilled(id, phone);
        System.out.println("insertSuccessKilleds -> " + insertSuccessKilleds);
    }

    @Test
    public void queryByIdWithSeckill() {
        long id = 1004L;
        long phone = 12345678900L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }
}