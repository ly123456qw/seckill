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
    <title>添加测试</title>
    <%@include file="common/head.jsp" %>

</head>
<body>
<div class="panel panel-default box" >
    <form id="addMessage">
        <div class="form-group">
            <label for="number">学号</label>
            <input type="number" class="form-control" id="number" name="number" placeholder="输入学号">
        </div>
        <div class="form-group">
            <label for="name">姓名</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="输入姓名">
        </div>
        <div class="form-group">
            <label for="sex">性别</label>
            <input type="text" class="form-control" id="sex" name="sex" placeholder="输入性别">
        </div>
        <a class="btn btn-default" type="button" onclick="save()">保存</a>
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
                if (data === 1) {
                    alert("保存成功");
                    self.location = "./list";
                } else {
                    alert("保存失败，ID：" + "data: " + data);
                }
            }
        })
    }
</script>

</body>
</html>