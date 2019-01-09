package org.seckill.service;

import org.seckill.entity.StudentInfoEntity;

import java.util.List;

public interface StudentInfoService {

    /**
     * 通过No查询到当前数据
     * @param id
     * @return
     */
    StudentInfoEntity queryByNO(Integer id);

    /**
     * queryAll StudentInfo
     * @return
     */
    List<StudentInfoEntity> queryAll();

    /**
     * insertStudentInfo
     * @return
     */
    Integer inserStudentInfo(StudentInfoEntity studentInfoEntity);

    /**
     * updateStudentInfo
     * @param studentInfoEntity
     * @return
     */
    Integer updateStudentInfo(StudentInfoEntity studentInfoEntity);

    /**
     * deleteStudentInfo
     * @param id
     * @return
     */
    Integer deleteStudent(Integer id);

}
