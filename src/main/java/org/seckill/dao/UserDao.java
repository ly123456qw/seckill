package org.seckill.dao;

import org.seckill.entity.User;

import java.util.List;

public interface UserDao {
    /**
     * 通过id进行查询
     * @param id
     * @return
     */
    User selectUser(Integer id);

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAllUser();

    /**
     * 通过 Email 查询用户相关
     * @param email
     * @return
     */
    User selectUserByEmail(String email);

    /**
     * 增加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    Integer romoveUser(Integer id); // FIXME DONT DELETE

    /**
     * 更新用户相关信息
     * @param user
     * @return
     */
    Integer modifyUser(User user);
}
