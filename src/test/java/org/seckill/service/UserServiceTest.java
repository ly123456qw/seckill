package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void selectUser() {
        Integer id = 1;
        System.out.println(userService.selectUser(id));
    }

    @Test
    public void selectAllUser() {
        System.out.println(userService.selectAllUser());
    }

    @Test
    public void selectUserByEmail() {
        System.out.println(userService.selectUserByEmail("cnperish@gmail.com"));
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setPassword("123");
        user.setUsername("位于");
        user.setRole("Student");
        user.setStatus(1);
        user.setEmail("123@qq.com");
        user.setNumber("123");
        userService.addUser(user);
    }

    @Test
    public void removeUser() {
        userService.removeUser(6);
    }

    @Test
    public void modifyUser() {
        User getUser = userService.selectUser(5);
        if (getUser != null) {
            getUser.setEmail("test@gmail.com");
            userService.modifyUser(getUser);
        }
    }

    @Test
    public void queryNumber() {
        User queryById = userService.selectUser(7);
        System.out.println(userService.queryNumber(queryById.getNumber()));
    }
}
