package org.seckill.dao;


import org.seckill.entity.UserEntity;

import java.util.List;

public interface UserDao {



    /**
     *  通过用户学号查询所有信息
     * @param number
     * @return
     */
    UserEntity queryByNum(String number);

    /**
     * 添加学生用户信息
     * @param userEntity
     * @return
     */
    Integer insertUser(UserEntity userEntity);

    /**
     * 查询所有用户信息
     * @return
     */
    List<UserEntity> queryAllUser();
}
