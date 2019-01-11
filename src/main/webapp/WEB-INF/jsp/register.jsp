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
    <title>注册页面</title>

</head>
<body>
<div class="panel panel-default box" >
    <form id="addMessage">
        <div class="form-group">
            <label for="number">学号：</label>
            <input type="number" class="form-control" id="number" name="number" placeholder="请输入学号" >
        </div>
        <div class="form-group">
            <label for="username">用户名：</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名" >
        </div>
        <div class="form-group">
            <label for="email">邮箱：</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="请输入邮箱" >
        </div>
        <div class="form-group">
            <label for="pwdword">密码：</label>
            <input type="password" class="form-control" id="pwdword" name="password" placeholder="输入密码" >
        </div>

        <div class="form-group">
            <label for="pwd">确认密码：</label>
            <input type="password" class="form-control" id="pwd" name="pwd" placeholder="请输入密码" >
        </div>
        <div class="form-group">
            <label for="role">用户身份：</label>
            <input type="text" class="form-control" id="role" name="role"
                   placeholder="请输入用户身份" readonly = "readonly" value="学生">
        </div>

        <a class="btn btn-default" type="button" onclick="register()">保存</a>
    </form>
</div>

<script type="text/javascript">
    function register() {
        var all = $('#addMessage').serialize();
        console.log(all);
        $.ajax({
            url: "registerInfoSuccess.action",
            type: "POST",
            data : all,
            dataType : "json",
            success : function (data) {
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

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
