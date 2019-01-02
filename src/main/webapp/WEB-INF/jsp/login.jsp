<%--
  Created by IntelliJ IDEA.
  User: Sori
  Date: 2018/10/16
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>LOGIN</title>
    <%@include file="common/head.jsp" %>
</head>
<body>

<!-- 页面显示部分 -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>Login</h2>
        </div>
        <div class="panel-body">
            <form id="users">
                <div class="form-group">
                    <label for="userName">用户名</label>
                    <input type="text" class="form-control" id="userName" name="userName" placeholder="输入用户名">
                </div>
                <div class="form-group">
                    <label for="userPassword">密码</label>
                    <input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="输入密码">
                </div>
                <a class="btn btn-default" type="button" onclick="login()">Login</a>
            </form>
        </div>
    </div>

</div>
<script type="text/javascript">
    function login() {
        $.ajax({
            url: "loginSuccess.action",
            type: "POST",
            data: $('#users').serialize(),
            dataType: "json",
            success: function (data) {
                if (data === 0) {
                    alert("登录成功");
                    self.location.href = "/seckill/list";
                } else {
                    alert("失败");
                }
            }
        })
    }
</script>

</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
