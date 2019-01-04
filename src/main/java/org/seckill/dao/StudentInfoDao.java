package org.seckill.dao;

import org.seckill.entity.StudentInfoEntity;

/**
 * Student Info DAO -> Mapper
 */
public interface StudentInfoDao {

    /**
     * add some student info
     * @param studentInfoEntity
     * @return
     */
    Integer insertStudentInfo(StudentInfoEntity studentInfoEntity);

    /**
     * query by student id or no
     * @param id
     * @return
     */
    StudentInfoEntity queryById(Integer id);

    /**
     * update studentInfo
     * @param studentInfoEntity
     * @return
     */
    Integer updateStudent(StudentInfoEntity studentInfoEntity);

    /**
     * deleteStudent
     * @param id
     * @return
     */
    Integer deleteStudent(Integer id);

}
