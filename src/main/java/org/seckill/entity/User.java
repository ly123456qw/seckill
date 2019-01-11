package org.seckill.entity;

public class User {

    // 正则表达式判断
    public static final String DECIDE_USER_NAME = "//^[a-zA-Z\\u4E00-\\u9FA5]+$/\n";

    private Integer id; //用户id
    private String email; //用户邮箱
    private String password;//用户密码
    private String username;//用户名称
    private String role;//用户身份
    private Integer status;//用户状态
    // 学号
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", number='" + number + '\'' +
                ", status=" + status +
                '}';
    }
}
