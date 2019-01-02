<%--
  Created by IntelliJ IDEA.
  User: Sori
  Date: 2018/10/15
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>

<html>
<head>
    <title>添加用户</title>
    <%@include file="common/head.jsp" %>

</head>
<body>
<div class="panel panel-default box" >
    <form id="addMessage">
        <div class="form-group">
            <label for="userName">用户名</label>
            <input type="text" class="form-control" id="userName" name="userName" placeholder="输入用户名">
        </div>
        <div class="form-group">
            <label for="userPassword">密码</label>
            <input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="输入密码">
        </div>
        <div class="form-group">
            <label for="createTime">创建时间</label>
            <input type="text" class="form-control" id="createTime" name="createTime" value="${createTime}" readonly="readonly">
        </div>
        <a class="btn btn-default" type="button" onclick="save()">保存</a>
        <a class="btn btn-success" href="${pageContext.request.contextPath}/seckill/list">取消</a>
    </form>
</div>

<script type="text/javascript">

    function save() {
        $.ajax({
            url: "save.action",
            type: "POST",
            data : $('#addMessage').serialize(),
            dataType : "json",
            success : function (data) {
                if (data === 0) {
                    alert("保存成功");
                    self.location = "/seckill/list";
                } else {
                    alert("保存失败，ID：" + "data: " + data);
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

