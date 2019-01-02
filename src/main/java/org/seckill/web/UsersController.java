package org.seckill.web;

import org.seckill.entity.Users;
import org.seckill.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
    private final static Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/login")
    public ModelAndView login(ModelAndView model, HttpServletRequest request) {
        Users users = (Users) request.getSession().getAttribute("userName");
        if (null != users) {
            model.addObject("error", "ERROR");
        }
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "loginSuccess", method = RequestMethod.POST)
    @ResponseBody
    public String loginSuccess(HttpServletRequest request, HttpSession httpSession) {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        if (null != userName || null != userPassword) {

            Users users = usersService.queryLogin(userName, userPassword);
            if (null != users) {
                httpSession.setAttribute("USERS_SESSION", users);
                return "0";
            } else {
                return "-2";
            }
        } else {
            return "-1";
        }
    }

    /**
     * 添加用户时自动获取用户创建时间
     * @param model
     * @return
     */
    @RequestMapping(value = "/addUsers", method = RequestMethod.GET)
    public String addUsers(Model model) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("createTime", simpleDateFormat.format(new Date()));
        return "addUsers";

    }

    /**
     * 保存用户
     * @param request
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(HttpServletRequest request) throws ParseException {
        String id = request.getParameter("id");
        if (null != id) {
            return "-1"; //TODO
        }
        Users users = new Users();
        users.setUserName(request.getParameter("userName"));
        users.setUserPassword(request.getParameter("userPassword"));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        users.setCreateTime(simpleDateFormat.parse(request.getParameter("createTime")));
        users.setStatus(0);
        logger.info(users.toString());
        usersService.insertUser(users);
        return "0";
    }
}