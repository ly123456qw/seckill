package org.seckill.service.impl;

import org.seckill.dao.UserDao;
import org.seckill.entity.User;
import org.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 根据用户的 id 来查询具体的用户
     * @param userId
     * @return
     */
    @Override
    public User selectUser(Integer userId) {
        return userDao.selectUser(userId);
    }

    /**
     * 获取所有的用户
     * @return
     */
    @Override
    public List<User> selectAllUser() {
        List<User> userList = userDao.selectAllUser();
        return userList;
    }

    /**
     * 查询邮箱 根据邮箱来找回密码
     * @param email
     * @return
     */
    @Override
    public User selectUserByEmail(String email) {
        return userDao.selectUserByEmail(email);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @Override
    public Integer removeUser(Integer userId) {
        return userDao.romoveUser(userId);
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @Override
    public Integer modifyUser(User user) {
        return userDao.modifyUser(user);
    }
}
