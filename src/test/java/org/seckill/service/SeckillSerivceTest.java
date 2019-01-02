package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class SeckillSerivceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillSerivce seckillSerivce;

    @Test
    public void getSeckillList() {
        List<Seckill> list = seckillSerivce.getSeckillList();
        logger.info("list = {}", list);
    }

    @Test
    public void getById() {
        long id = 1005L;
        Seckill seckill = seckillSerivce.getById(id);
        logger.info("seckill = {}", seckill);
    }

    @Test
    public void exposerSeckillUrl() {
        long id = 1007L;
        long phone = 12345678901L;
        Exposer exposer = seckillSerivce.exposerSeckillUrl(id);
        String md5 = exposer.getMd5();
        if (exposer.isExposed()) {
            logger.info("exposer:{}", exposer);
            try {
                SeckillExecution seckill = seckillSerivce.executionSeckill(id, phone, md5);
                logger.info("seckill:{}", seckill);
            } catch (RepeatKillException e) {
                logger.error(e.getMessage());
            } catch (SeckillCloseException e1) {
                logger.error(e1.getMessage());
            }
        } else {
            logger.warn("exposer:{}", exposer);
        }
    }

    @Test
    public void exposerProcedure() {
        long id = 1030L;
        long phone = 12345678900L;
        Exposer exposer = seckillSerivce.exposerSeckillUrl(id);
        if (exposer.isExposed()) {
            String md5 = exposer.getMd5();
            SeckillExecution seckillExecution = seckillSerivce.executionSeckillProcedure(id, phone, md5);
            logger.info("============> " + seckillExecution.getStateInfo());
        }
    }

}