package org.seckill.controller;

import org.seckill.entity.StudentInfoEntity;
import org.seckill.entity.UserEntity;
import org.seckill.service.StudentInfoService;
import org.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/")
public class UserController {

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

    /**
     * 注册
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/register")
    public String registerInfo(HttpServletRequest request, Model model) {
        return "register";
    }

    /**
     * 注册 - 将注册的信息写入数据库
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/registerInfoSuccess")
    public String registerInfoSuccess(HttpServletRequest request) {
        UserEntity userEntity = new UserEntity();
        String number = request.getParameter("number");
        String password = request.getParameter("password");
        String pwd = request.getParameter("pwd");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String academic = request.getParameter("academic");
        String major = request.getParameter("major");


       // 判断输入的学号和密码不为空
        if (number != null && !"".equals(number) &&
                password != null && !"".equals(password) &&
                pwd != null && !"".equals(pwd)) {

            StudentInfoEntity studentInfoEntity = studentInfoService.queryByNum(number);

            // 判断两个密码是否相等和学号是否在学生表中存在
            if (number.equals(studentInfoEntity.getStudentNum())&& password.equals(pwd)) {
                userEntity.setUserNumber(number);
                userEntity.setUserPassword(password);
                userEntity.setUserIntro(email);
                try {
                    userService.insertUser(userEntity);
                    return "1";
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return "-1";

    }


    /**
     * 登录
     *
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(ModelAndView modelAndView) {
        // 这里留空用作后面做安全判断，预防劫持
        return "login";
    }


    /**
     * 登录验证
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/enterUser")
    @ResponseBody
    public String enterUser(HttpServletRequest request, HttpSession session) {
        String number = request.getParameter("number");
        String password = request.getParameter("password");
        if (null != number && !"".equals(number) &&
                null != password && !"".equals(password)) {
            UserEntity userEntity = userService.queryByNum(number);
            if (null != userEntity && password.equals(userEntity.getUserPassword()) &&
                    (number != null && number.equals(userEntity.getUserNumber()))) {
                session.setAttribute("number", userEntity.getUserNumber());
                session.setAttribute("email", userEntity.getUserEmail());
                return "1";
            } else {
                // 0 代表 学号或者密码输入错误
                return "0";
            }
        } else {
            // -1 代表输入框没有任何的输入操作
            return "-1";
        }
    }


    /**
     * 登录成功跳转的页面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/studentSuccessInfo")
    public String studentSuccessInfo(HttpServletRequest request, Model model) {
        String usersession = (String) request.getSession().getAttribute("name");
        model.addAttribute("name", usersession);
        return "director";
    }

}
