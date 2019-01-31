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
        String id = studentInfoDao.queryById(17);
        StudentInfoEntity studentInfoEntity = new StudentInfoEntity();
        if (null != id && ! "".equals(id)) {
            StudentInfoEntity byId = studentInfoDao.findById(Integer.valueOf(id));

            byId.setStudentName("ZOOM4");
            try {
                studentInfoDao.updateStudent(byId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            studentInfoEntity.setStudentName("李可");
            studentInfoEntity.setStudentAcdemic("经济学院");
            studentInfoEntity.setStudentMajor("经济");
            studentInfoEntity.setStudentNum("14015099");
            studentInfoEntity.setStudentPhone("18678552661");
            studentInfoDao.insertStudentInfo(studentInfoEntity);
        }

    }

    @Test
    public  void  queryByNum () {
        StudentInfoEntity studentInfoEntity = studentInfoDao.queryByNum("1506090540017");
        studentInfoEntity.getStudentId();
        studentInfoEntity.getStudentAcdemic();
        studentInfoEntity.getStudentName();
    }

//    @Test
//    public void queryById() {
//        StudentInfoEntity studentInfoEntity = studentInfoDao.queryById(1);
//        System.out.println(studentInfoEntity.getStudentNum());
//    }
//
//    @Test
//    public void delete() {
//        StudentInfoEntity studentInfoEntity = studentInfoDao.queryById(2);
//        System.out.println(studentInfoEntity.getStudentName());
//        studentInfoDao.deleteStudent(studentInfoEntity.getStudentId());
//    }

    @Test
    public void queryAll() {
        System.out.println(studentInfoDao.queryAll());
    }
}
