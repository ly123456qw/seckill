<%--
  Created by IntelliJ IDEA.
  User: liuyan
  Date: 2019/1/5
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 引入 jstl -->
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>社团管理系统 - 测试页面</title>
    <%@include file="common/head.jsp" %>
</head>
<body>

<!-- 页面显示部分 -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>社团管理系统测试</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>
                        <a class="btn btn-success" onclick="add();"
                           data-toggle="popover">增加</a>
                    </td>
                </tr>
                <tr>
                    <th>序列号</th>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="sk" items="${list}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${sk.no}</td>
                        <td>${sk.name}</td>
                        <td>${sk.sex}</td>
                        <td>
                            <a class="btn btn-success" onclick="edit('${sk.id}');"
                               data-toggle="popover">修改</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>

</div>

<script type="text/javascript">
    function add() {
        self.location = "./add?id=1";
    }
    function edit(id) {
        self.location = "./edit?id=" + id;
    }
</script>

</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
