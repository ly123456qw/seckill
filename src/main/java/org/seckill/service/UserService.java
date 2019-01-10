package org.seckill.service;

import org.seckill.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 通过id查询
     * @param userId
     * @return
     */
     User selectUser(Integer userId);

    /**
     * 查询所用用户
     * @return
     */
     List<User> selectAllUser();

    /**
     * 通过用户邮箱查询
     * @param email
     * @return
     */
     User selectUserByEmail(String email);

    /**
     * 添加用户
     * @param user
     * @return
     */
     Integer addUser(User user);

    /**
     * delete user
     * @param userId
     * @return
     */
     Integer removeUser(Integer userId);

    /**
     * update user
     * @param user
     * @return
     */
     Integer modifyUser(User user);

    /**
     * query by number
     * @param number
     * @return
     */
     User queryNumber(String number);

}
