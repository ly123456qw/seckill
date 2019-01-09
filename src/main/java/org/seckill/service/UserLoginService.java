package org.seckill.service;

import org.seckill.entity.UserLoginEntity;
import org.springframework.stereotype.Service;

public interface UserLoginService {
    /**
     * 通过用户名查询
     * @param user
     * @return
     */
    UserLoginEntity queryByuser(String user);
}
