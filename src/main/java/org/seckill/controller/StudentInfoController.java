package org.seckill.controller;

import com.sun.org.apache.xerces.internal.impl.dv.xs.MonthDayDV;
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
@RequestMapping("/")
public class StudentInfoController {

    @Autowired
    private StudentInfoService studentInfoService;

    /**
     * management index
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String AllStudent(Model model) {

        List<StudentInfoEntity> list = studentInfoService.queryAll();
        model.addAttribute("list", list);
        return "StudentInfoIndex"; // TODO
    }

    /**
     * insert sth info
     * @return
     */
    @RequestMapping(value = "/add")
    public String add() {
        return "add";
    }

    /**
     * save sth info
     * @param request
     * @param studentInfoEntity
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(HttpServletRequest request) {
        StudentInfoEntity studentInfoEntity = new StudentInfoEntity();
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String id = request.getParameter("id");

        studentInfoEntity.setNo(no);
        studentInfoEntity.setName(name);
        studentInfoEntity.setSex(sex);
        if (request.getParameter("id") == null) {
            studentInfoService.inserStudentInfo(studentInfoEntity);
        } else {
            if (no.equals(studentInfoEntity.getNo()) &&
                    name.equals(studentInfoEntity.getName()) &&
                    sex.equals(studentInfoEntity.getSex())) {
                return "0";
            }
            studentInfoService.updateStudentInfo(studentInfoEntity);
        }
        return "1"; //TODO
    }

    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request, Map<String, Object> map) {
        String id = request.getParameter("id");
        if (null == id) {
            return null;
        } else {
            StudentInfoEntity queryById = studentInfoService.queryByNO(Integer.valueOf(id));
            String no = queryById.getNo();
            String name = queryById.getName();
            String sex = queryById.getSex();
            map.put("no", no);
            map.put("name",name);
            map.put("sex",sex);
            map.put("id", id);
            return "edit";
        }
    }

}