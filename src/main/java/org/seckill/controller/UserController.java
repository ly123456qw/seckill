package org.seckill.controller;

import org.seckill.entity.User;
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

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(ModelAndView modelAndView) {
        return "login";
    }

    /**
     * 校验用户
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/enterUser")
    @ResponseBody
    public String enterUser(HttpServletRequest request, HttpSession session) {
        String number = request.getParameter("number");
        String password = request.getParameter("password");
        if (null != number && ! "".equals(number) &&
                null != password &&  !"".equals(password)) {
            User user = userService.queryNumber(number);
            if (null != user &&
                    password.equals(user.getPassword()) &&
                    (number != null && number.equals(user.getNumber()))
                    && user.getStatus() == 1) {
                session.setAttribute("name", user.getUsername());
                session.setAttribute("number", user.getNumber());
                session.setAttribute("email", user.getEmail());

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
     * 学生登录成功
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/studentSuccessInfo")
    public String studentSuccessInfo(HttpServletRequest request, Model model) {
        String usersession = (String) request.getSession().getAttribute("name");
        model.addAttribute("name", usersession);
        return "studentSuccessInfo";
    }
}
