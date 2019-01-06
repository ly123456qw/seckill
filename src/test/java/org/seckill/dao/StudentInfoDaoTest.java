package org.seckill.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.StudentInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class StudentInfoDaoTest {

    @Autowired
    private StudentInfoDao studentInfoDao;

    // replace system.out.println()
//    private static final Logger logger = LoggerFactory.getLogger(StudentInfoDaoTest.class);

    @Test
    public void insertStudentInfo() {
        StudentInfoEntity studentInfoEntity = studentInfoDao.queryById(1);
        if (studentInfoEntity.getId() == null) {
            studentInfoEntity.setName("Terminal");
            studentInfoEntity.setNo("2435454111");
            studentInfoEntity.setSex("M");
            studentInfoDao.insertStudentInfo(studentInfoEntity);
        } else {
            studentInfoEntity.setName("ZOOM4");
            studentInfoDao.updateStudent(studentInfoEntity);
        }

    }

    @Test
    public void queryById() {
        StudentInfoEntity studentInfoEntity = studentInfoDao.queryById(1);
        System.out.println(studentInfoEntity.getName());
    }

    @Test
    public void delete() {
        StudentInfoEntity studentInfoEntity = studentInfoDao.queryById(2);
        System.out.println(studentInfoEntity.getId());
        studentInfoDao.deleteStudent(studentInfoEntity.getId());
    }

    @Test
    public void queryAll() {
        System.out.println(studentInfoDao.queryAll());
    }

}
