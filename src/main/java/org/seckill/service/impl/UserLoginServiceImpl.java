package org.seckill.service.impl;

import org.seckill.dao.UserLoginDao;
import org.seckill.entity.UserLoginEntity;
import org.seckill.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginDao userLoginDao;
    @Override
    public UserLoginEntity queryByuser(String user) {

        return userLoginDao.selectUser(user);
    }
}
