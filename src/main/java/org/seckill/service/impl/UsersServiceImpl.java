package org.seckill.service.impl;

import org.seckill.dao.UsersDao;
import org.seckill.entity.Users;
import org.seckill.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private final static Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Autowired
    private UsersDao usersDao;
    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<Users> queryAll() {
        return usersDao.queryAllUsers(0, 10, 0);
    }

    /**
     * 增加用户
     * @param users
     * @return
     */
    @Override
    public Integer insertUser(Users users) {
        return usersDao.addUsers(users);
    }

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @Override
    public Users queryUsersById(Integer id) {
        if (null != id) {
            logger.info("id ->" + id);
            return usersDao.queryUsersById(id);
        }
        return null;
    }

    @Override
    public Users queryLogin(String userName, String userPassword) {
        if (userName != null && userPassword != null) {
            logger.info("userName -> " + userName + " &userPassword -> " + userPassword);
            return usersDao.queryLogin(userName, userPassword);
        } else {
            logger.info("userName -> " + userName + " &userPassword -> " + userPassword);
            return null;
        }
    }
}
