package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.UserDao;
import org.seckill.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class UserServiceTest {

    @Autowired
    UserDao userDao;
    @Test
    public void queryByNum() {
        UserEntity userEntity = userDao.queryByNum("1606090540002");
        /*System.out.println(userEntity.getPassword());
        System.out.println(userEntity.getUsername());
        System.out.println(userEntity.getAcademic());
        System.out.println(userEntity.getUserEmail());*/

    }

    @Test
    public void insertUser() {
       /* UserEntity userEntity = new UserEntity();
        userEntity.setNum("1506090540003");
        userEntity.setUsername("王五");
        userEntity.setPassword("123");
        userEntity.setMajor("电子信息工程");
        userEntity.setAcademic("物电学院");
        userEntity.setUserEmail("123090@qq.com");
        userDao.insertUser(userEntity);*/

    }
}