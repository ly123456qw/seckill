package org.seckill.controller;

import org.seckill.service.StudentInfoService;
import org.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {

    /**
     * 用户信息
     */
    @Autowired
    private UserService userService;

    /**
     * 学生信息
     */
    @Autowired
    private StudentInfoService studentInfoService;



}
