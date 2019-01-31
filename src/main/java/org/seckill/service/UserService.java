package org.seckill.service;

import org.seckill.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    /**
     * 通过学号查询所有信息
     * @param num
     * @return
     */
    UserEntity queryByNum(String num);

    /**
     * 插入学生用户的信息
     * @param userEntity
     * @return
     */
    Integer insertUser(UserEntity userEntity);

    /**
     * 查询所有
     * @return
     */
    List<UserEntity> queryAll();
}
