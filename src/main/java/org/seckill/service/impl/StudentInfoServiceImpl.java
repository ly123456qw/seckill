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
    public StudentInfoEntity queryByNO(Integer id) {

        return studentInfoDao.queryById(id);
    }

    @Override
    public List<StudentInfoEntity> queryAll() {
        List<StudentInfoEntity> infoEntityList = studentInfoDao.queryAll();
        return infoEntityList; //TODO
    }

    @Override
    public Integer inserStudentInfo(StudentInfoEntity studentInfoEntity) {
        return studentInfoDao.insertStudentInfo(studentInfoEntity);
    }

    @Override
    public Integer updateStudentInfo(StudentInfoEntity studentInfoEntity) {
        return  studentInfoDao.updateStudent(studentInfoEntity);
    }

    @Override
    public Integer deleteStudentInfo(int id) {
        return null;
    }
}
