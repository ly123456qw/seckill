package org.seckill.entity;

/**
 * Student Info
 */
public class StudentInfoEntity {

    //学生ID
    private Integer studentId;

    //学生姓名
    private String studentName;

    //学院
    private String studentAcdemic;

    //专业
    private String studentMajor;

    //学号
    private String studentNum;

    //电话
    private String studentPhone;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAcdemic() {
        return studentAcdemic;
    }

    public void setStudentAcdemic(String studentAcdemic) {
        this.studentAcdemic = studentAcdemic;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    @Override
    public String toString() {
        return "StudentInfoEntity{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentAcdemic='" + studentAcdemic + '\'' +
                ", studentMajor='" + studentMajor + '\'' +
                ", studentNum='" + studentNum + '\'' +
                ", studentPhone='" + studentPhone + '\'' +
                '}';
    }
}
