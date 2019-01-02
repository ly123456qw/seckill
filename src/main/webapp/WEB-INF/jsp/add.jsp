<%--
  Created by IntelliJ IDEA.
  User: Sori
  Date: 2018/10/10
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>

<html>
<head>
    <title>ADD</title>
    <%@include file="common/head.jsp" %>

</head>
<body>
<div class="panel panel-default box" >
    <form id="addMessage">
        <div class="form-group">
            <label for="name">名称</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="输入名称">
        </div>
        <div class="form-group">
            <label for="number">库存</label>
            <input type="number" class="form-control" id="number" name="number" placeholder="输入数量">
        </div>
        <div class="form-group">
            <label for="startTime">开始时间</label>
            <input type="text" class="form-control" id="startTime" name="startTime" placeholder="输入开始时间">
        </div>
        <div class="form-group">
            <label for="endTime">结束时间</label>
            <input type="text" class="form-control" id="endTime" name="endTime" placeholder="输入结束时间">
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
