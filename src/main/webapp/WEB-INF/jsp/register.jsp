<%--
  Created by IntelliJ IDEA.
  User: liuyan
  Date: 2019/1/11
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>注册信息</title>
    <%@include file="common/head.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<style>
    #form{
        position: relative;
        left: 450px;
    }
</style>
<body style="background-image: url(../resources/static/img/register.jpg);">
<div class="formpage">
    <h2 style="text-align:center; margin-top: 40px;">欢迎注册</h2>
</div>
<center>
<div style="text-align: center; margin-top: 80px;">
    <form id="addMessage" method="post">
        <table>
            <tr>
                <td>学号：</td>
                <td ><input class="textput" type="text" id="number" name="number" placeholder="请输入学号"/></td>

            <tr>
            <tr>
                <td>密码：</td>
                <td ><input class="password" id="password" name="password" placeholder="请输入密码"/></td>

            <tr>
            <tr>
            <td>确认密码：</td>
            <td ><input class="password" id="pwd" name="pwd" placeholder="请确认密码"/></td>

            <tr>
            <tr>
                <td>用户名：</td>
                <td ><input class="textput" id="username" name="username" placeholder="请输入用户名"/></td>

            <tr>
            <tr>
                <td>电子邮箱：</td>
                <td><input class="textput" id="email" name="email" type="text"/></td>
                <td><span class="link" >&nbsp;&nbsp;更换邮箱</span></td></tr>
            <tr>
                <td>学院：</td>
                <td><input class="textput" id="academic" name="academic" type="text"/></td>
            </tr>
            <tr>
                <td>专业：</td>
                <td><input class="textput" id="major" name="major" type="text"/></td>
                <td><p class="wrrong"></p></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td><label>女<input name="sex" type="radio" checked="checked" ></label><label>男<input name="sex" type="radio"></label></td>
            </tr>

            <tr>
                <td></td>
                <td colspan="2">
                    <button class="btn btn-success" type="button" onclick="register()">注册</button></td>
            </tr>
        </table>
    </form>
</div>
</center>

<script type="text/javascript">
    function register() {
        $.ajax({
            url: "registerInfoSuccess.action",
            type: "POST",
            data : $('#addMessage').serialize(),
            dataType : "json",
            success : function (data) {
                alert("====> " + data);
                if (data === 1) {
                    alert("注册成功，自动跳转到登录界面");
                    self.location = "./login";
                } else if (data === 0) {
                    alert("学号或者密码输入错误");
                } else if (data == "-2") {
                    alert("两次密码输入的不一样")
                } else {
                    alert("输入格式不正确");
                }
            }
        })
    }

</script>
</body>

</html>

<%--<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->--%>
<%--<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>--%>

<%--<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->--%>
<%--<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
