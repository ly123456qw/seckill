package org.seckill.controller;

import com.sun.org.apache.xerces.internal.impl.dv.xs.MonthDayDV;
import org.seckill.dao.StudentInfoDao;
import org.seckill.entity.StudentInfoEntity;
import org.seckill.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")  //根路径
public class StudentInfoController {

    @Autowired
    private StudentInfoService studentInfoService;


    @RequestMapping("/list")
    public String AllStudent(Model model) {

        List<StudentInfoEntity> list = studentInfoService.queryAll();
        model.addAttribute("list", list);
        return "StudentInfoIndex"; // TODO
    }

    @RequestMapping(value = "/add")
    public String add() {
        return "add";
    }



    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(HttpServletRequest request) {
        StudentInfoEntity studentInfoEntity = new StudentInfoEntity();
        String number = request.getParameter("number");
        String password = request.getParameter("password");
        String pwd = request.getParameter("pwd");
        String username= request.getParameter("username");
        String email= request.getParameter("email");
        String academic= request.getParameter("academic");
        String major= request.getParameter("major");
        //取性别
        studentInfoEntity.setStudentNum(number);
        studentInfoEntity.setStudentName(username);
        studentInfoEntity.setStudentMajor(major);
//        if (request.getParameter("number") == null) {
//            studentInfoService.inserStudentInfo(studentInfoEntity);
//        } else {
//            if (no.equals(studentInfoEntity.getNo()) &&
//                    name.equals(studentInfoEntity.getName()) &&
//                    sex.equals(studentInfoEntity.getSex())) {
//                return "0";
//            }
//            studentInfoService.updateStudentInfo(studentInfoEntity);
//        }
        return "1"; //TODO
    }

    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request, Map<String, Object> map) {
//        String id = request.getParameter("id");
//        if (null == id) {
//            return null;
//        } else {
//            StudentInfoEntity queryById = studentInfoService.queryByNO(Integer.valueOf(id));
//            String no = queryById.getNo();
//            String name = queryById.getName();
//            String sex = queryById.getSex();
//            map.put("no", no);
//            map.put("name",name);
//            map.put("sex",sex);
//            map.put("id", id);
//            return "edit";
//        }
        return null;//todo
    }

    @RequestMapping(value = "/del")
    @ResponseBody
    public String delete(HttpServletRequest request) {

        String number = request.getParameter("number");
        request.getContextPath();
        if(number == null) {
            return "0";
        } else {
            studentInfoService.deleteStudent(Integer.valueOf(number));
            return "1";
        }
    }

}
