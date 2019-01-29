package org.seckill.service.impl;

import org.seckill.dao.StudentInfoDao;
import org.seckill.entity.StudentInfoEntity;
import org.seckill.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    private StudentInfoDao studentInfoDao;

    @Override
    public Integer insertStudentInfo(StudentInfoEntity studentInfoEntity) {
        return studentInfoDao.insertStudentInfo(studentInfoEntity);
    }

    @Override
    public StudentInfoEntity queryByNum(String num) {
        return studentInfoDao.queryByNum(num);
    }

    @Override
    public String queryById(Integer id) {
        return studentInfoDao.queryById(id);
    }

    @Override
    public StudentInfoEntity findById(Integer id) {
        return studentInfoDao.findById(id);
    }

    @Override
    public List<StudentInfoEntity> queryAll() {
        return studentInfoDao.queryAll();
    }

    @Override
    public Integer updateStudent(StudentInfoEntity studentInfoEntity) {
        return studentInfoDao.updateStudent(studentInfoEntity);
    }

    @Override
    public Integer deleteStudent(Integer id) {
        return studentInfoDao.deleteStudent(id);
    }
}
