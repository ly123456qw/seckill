package org.seckill.controller;

import org.seckill.entity.UserLoginEntity;
import org.seckill.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/login")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;


    @RequestMapping(value = "/user")
    public String queryByuser(HttpServletRequest request) {

        String name = request.getParameter("user");
        UserLoginEntity queryuser = userLoginService.queryByuser(name);
        if (queryuser != null) {
            return "list";
        } else {
            return "login";//todo
        }
    }
}
