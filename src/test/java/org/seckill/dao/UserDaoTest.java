package org.seckill.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {
   @Autowired
    private UserDao userDao;

    @Test
    public void selectUser() {
        User user = userDao.selectUser(1);
        System.out.println(user.getId());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
        System.out.println("hhh");
    }

    @Test
    public void selectAllUser() {
        System.out.println(userDao.selectAllUser());
    }

    @Test
    public void selectUserByEmail() {
        User user = userDao.selectUserByEmail("cnperish@gmail.com");
        System.out.println(user);
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("Tina");
        user.setEmail("cnhonker@qq.com");
        user.setStatus(0);
        user.setRole("Teacher");
        user.setPassword("Join Chengdu");
        userDao.addUser(user);
    }

    @Test
    public void romoveUser() {
        User findId = userDao.selectUser(2);
        if (findId != null) {
            userDao.romoveUser(findId.getId());
        } else {
            return;
        }
    }

    @Test
    public void modifyUser() {
        User getMessage = userDao.selectUser(1);
        if (getMessage != null) {
            getMessage.setEmail("cnperish@gmail.com");
            getMessage.setUsername("柳艳");
            userDao.modifyUser(getMessage);
        }
    }

}
