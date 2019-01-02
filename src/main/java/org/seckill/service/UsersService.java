package org.seckill.service;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Users;

import java.util.List;

/**
 * 用户相关逻辑
 */
public interface UsersService {

    /**
     * 用户列表
     * @return
     */
    List<Users> queryAll();

    /**
     * 增加用户
     * @param users
     * @return
     */
    Integer insertUser(Users users);

    /**
     * 根据ID获取单个用户
     * @param id
     * @return
     */
    Users queryUsersById(Integer id);

    /**
     * 根据用户名和密码来匹配登录用户
     * @param userName
     * @param userPassword
     * @return
     */
    Users queryLogin(@Param("userName") String userName, @Param("userPassword") String userPassword);
}
