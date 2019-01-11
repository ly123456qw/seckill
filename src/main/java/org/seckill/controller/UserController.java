package org.seckill.controller;

import org.seckill.entity.User;
import org.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "/")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(ModelAndView modelAndView) {
        return "login";
    }

    /**
     * 校验用户
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
     *
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

    /**
     * Forword to registerInfo
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/register")
    public String registerInfo(HttpServletRequest request, Model model) {
        return "register";
    }

    @ResponseBody
    @RequestMapping(value = "/registerInfoSuccess")
    public String registerInfoSuccess(HttpServletRequest request, Model model) {
        User user = new User();
        String number = request.getParameter("number");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordAgain = request.getParameter("pwd");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

//        Matcher decideNumber = Pattern.compile(userName).matcher(User.DECIDE_USER_NAME);
        if (number.length() == 8 && userName != null && ! userName.equals("") &&
                password != null && ! password.equals("") &&
                passwordAgain != null && ! passwordAgain.equals("") &&
                email != null && ! email.equals("") &&
                role != null && ! role.equals("")) {

            if (! password.equals(passwordAgain)) {
                return "-2";
            }

            user.setNumber(number);
            user.setEmail(email);
            user.setStatus(1);
            user.setRole("学生");
            user.setUsername(userName);
            user.setPassword(password);
            try {
                userService.addUser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "1";
        } else {
            return "-3";
        }
    }
}