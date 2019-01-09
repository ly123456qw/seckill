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
    <title>修改测试</title>
    <%@include file="common/head.jsp" %>

</head>
<body>
<div class="panel panel-default box" >
    <form id="addMessage">
        <div class="form-group">
            <label for="user">用户名</label>
            <input type="user" class="form-control" id="user" name="user" placeholder="请输入用户名" >
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
            url: "user.action",
            type: "POST",
            data : all,
            dataType : "json",
            success : function (data) {
                if (data === 1) {
                    alert("登录成功");
                    self.location = "./list";
                } else if (data === 0) {
                    alert("没有修改任何的数据");
                } else {
                    alert("保存失败，ID：" + "data: " + data);
                }
            }
        })
    }
</script>

</body>
</html>