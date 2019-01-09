package org.seckill.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.StudentInfoEntity;
import org.seckill.entity.UserLoginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class UserLoginDaoTest {

    @Autowired
    private  UserLoginDao userLoginDao;
    @Test
    public void selectUser() {
        UserLoginEntity userLoginEntity = userLoginDao.selectUser("liuyan");
        System.out.println(userLoginEntity.getId());
        System.out.println(userLoginEntity.getStatus());
        System.out.println(userLoginEntity.getUser());
        System.out.println(userLoginEntity.getPassword());
    }
}
