package org.seckill.dao;

import org.seckill.entity.UserLoginEntity;

import java.util.List;

public interface UserLoginDao {

    /**
     * 实现注册用户
     * @param userLoginEntity
     * @return
     */
   Integer inserUser (UserLoginEntity userLoginEntity);

    /**
     * 实现查询用户后实现登录
     * @param user
     * @return
     */
   UserLoginEntity selectUser(String user);


}
