package org.seckill.service.impl;

import org.seckill.dao.UserDao;
import org.seckill.entity.UserEntity;
import org.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public UserEntity queryByNum(String num) {
        return userDao.queryByNum(num);
    }

    @Override
    public Integer insertUser(UserEntity userEntity) {
        return userDao.insertUser(userEntity);
    }
}
