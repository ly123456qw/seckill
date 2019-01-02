package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Users;

import java.util.List;

/**
 * 用户信息
 */
public interface UsersDao {

    /**
     * 添加用户信息
     * @param users
     * @return
     */
    Integer addUsers(Users users);

    /**
     * 查询所有用户信息
     * @param offset
     * @param limit
     * @return
     */
    List<Users> queryAllUsers(@Param("offset") Integer offset, @Param("limit") Integer limit, @Param("status") Integer status);

    /**
     * 根据ID来查询对应用户
     * @param id
     * @return
     */
    Users queryUsersById(Integer id);

    /**
     * 查询登录用户是否匹配
     * @param userName
     * @param userPassword
     * @return
     */
    Users queryLogin(@Param("userName") String userName, @Param("userPassword") String userPassword);
}
