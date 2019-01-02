package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*"})
public class UsersDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(UsersDaoTest.class);

    @Autowired
    private UsersDao usersDao;

    @Test
    public void addUsers() {
        Users users = new Users();
        users.setUserName("A用户");
        users.setUserPassword("123456");
        users.setCreateTime(new Date());
        users.setStatus(0);
        users.setId(0);
        usersDao.addUsers(users);
        logger.info(users.toString());
    }

    @Test
    public void queryAllUsers() {
        List<Users> usersList = usersDao.queryAllUsers(0, 10, 0);
        logger.info(usersList.toString());
    }

    @Test
    public void queryUsersById() {
        Integer id = 0;
        Users users = usersDao.queryUsersById(id);
        logger.info(users.toString());
    }

    @Test
    public void queryLogin() {
        String userName = "B";
        String userPasswd = "123";
        Users users = usersDao.queryLogin(userName, userPasswd);
        logger.info("users -> " + users);
    }
}