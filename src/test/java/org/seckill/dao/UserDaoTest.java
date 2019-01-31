package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.UserEntity;
import org.seckill.util.Verify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;
    @Test
    public void queryByNum() {
        UserEntity userEntity = userDao.queryByNum("123");
        System.out.println(userEntity.getUserPassword());
        System.out.println(userEntity.getUserID());
        System.out.println(userEntity.getUserStatus());
    }

    @Test
    public void inserUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserNumber("123456");
        userEntity.setUserPassword("1234");
        userEntity.setStudentId(4);
        userEntity.setUserEmail("123445@qq.com");
        userEntity.setUserStatus(1);
        userEntity.setUserIntro("qqww");

        userDao.insertUser(userEntity);

        System.out.println(userEntity.getUserNumber());
    }

    @Test
    public void queryAllUser() {
        System.out.println(userDao.queryAllUser());
    }

}