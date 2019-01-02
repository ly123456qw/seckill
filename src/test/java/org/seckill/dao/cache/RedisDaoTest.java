package org.seckill.dao.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.SeckillDao;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


// 告诉 Junit4 在启动的时候加载 Spring IOC 容器
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉 Junit4 Spring 的路径位置
@ContextConfiguration({"classpath*:spring/spring-dao.xml"})
public class RedisDaoTest {

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private SeckillDao seckillDao;

    private final static Logger logger = LoggerFactory.getLogger(RedisDaoTest.class);

    @Test
    public void testSeckill() {
        long id = 1000L;
        Seckill seckill = redisDao.getSeckill(id);
        if (null == seckill) {
            // 如果 Redis 中没有数据就根据 Id 查询数据库中是否有对应的数据
            seckill = seckillDao.queryById(id);
            if (null != seckill) {
                // 如果查到了数据，就直接把数据放到 Redis 里面
                String result = redisDao.putSeckill(seckill);
                logger.info("=======写入=====> " + result);
                seckill = redisDao.getSeckill(id);
                logger.info("=======拿到====> " + seckill);
            }
        }
    }

}