<%--
  Created by IntelliJ IDEA.
  User: liuyan
  Date: 2019/1/5
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>

<html>
<head>
    <title>登录</title>
    <%@include file="common/head.jsp" %>

</head>
<body>
<div class="panel panel-default box" >
    <form id="addMessage">
        <div class="form-group">
            <label for="number">学号</label>
            <input type="text" class="form-control" id="number" name="number" placeholder="请输入学号" >
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码" >
        </div>

        <a class="btn btn-default" type="button" onclick="login()">登录</a>
    </form>
</div>

<script type="text/javascript">
    function login() {
        var all = $('#addMessage').serialize();
        console.log(all);
        $.ajax({
            url: "enterUser.action",
            type: "POST",
            data : all,
            dataType : "json",
            success : function (data) {
                if (data === 1) {
                    alert("登录成功");
                    self.location = "./studentSuccessInfo";
                } else if (data === 0) {
                    alert("学号或者密码输入错误");
                } else {
                    alert("请输入学号或者密码，ID：" + "data: " + data);
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