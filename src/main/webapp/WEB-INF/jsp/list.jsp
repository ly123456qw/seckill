<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 引入 jstl -->
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>管理系统练习</title>
    <%@include file="common/head.jsp" %>
</head>
<body>

<!-- 页面显示部分 -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>管理系统练习</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th><a class="btn btn-primary" onclick="addOrders();" data-toggle="popover">增加</a></th>
                    <th><a class="btn btn-danger" onclick="recycleBin();" data-toggle="popover">回收站</a></th>
                    <th><a class="btn btn-success" href="<c:url value="/users/addUsers"/>" data-toggle="popover">添加用户</a></th>
                </tr>
                <tr>
                    <th>名称</th>
                    <th>库存</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>创建时间</th>
                    <th>详情页</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="sk" items="${list}">
                    <tr>
                        <td>${sk.name}</td>
                        <td>${sk.number}</td>
                        <td>
                            <fmt:formatDate value="${sk.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td>
                            <fmt:formatDate value="${sk.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td>
                            <fmt:formatDate value="${sk.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td>
                            <a class="btn btn-info" href="/seckill/${sk.seckillId}/detail" target="_blank">link</a>
                        </td>
                        <td>
                            <a class="btn btn-success" onclick="edit('${sk.seckillId}');"
                               data-toggle="popover">修改</a>
                            <a class="btn btn-danger" onclick="logicallyDeleted('${sk.seckillId}');">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <table class="table table-hover">
                <thead>
                <tr>
                    <td><a href="<c:url value="/seckill/list"/>">首页</a></td>
                    <c:if test="${pageNow gt 1}">
                        <td><a href="<c:url value="/seckill/list?page=${pageNow - 1}"/>">上一页</a></td>
                    </c:if>
                    <c:if test="${pageNow lt totalPage && pageNumber le totalPage}">
                        <td><a href="<c:url value="/seckill/list?page=${pageNow + 1}"/>">下一页</a></td>
                    </c:if>
                </tr>
                </thead>
            </table>
        </div>
    </div>

</div>
<script type="text/javascript">

    function addOrders() {
        self.location = "./add";
    }

    function edit(id) {
        $.ajax({
            url: "getId.action",	//请求url
            type: "GET",	//请求类型  post|get
            data: {
                "id": id
            },
            dataType: "json",  //返回数据的 类型 text|json|html--
            success: function (data) {	//回调函数 和 后台返回的 数据
                if (data === 0) {
                    console.log(data);
                    self.location = "./edit?id=" + id;
                } else {
                    alert("删除失败" + id);
                }
            }
        });
    }

    function logicallyDeleted(id) {
        $.ajax({
            url: "logicallyDeleted.action",
            type: "POST",
            data: {
                "id": id
            },
            dataType: "json",
            success: function (data) {
                if (data === 0) {
                    window.location.reload(true);
                } else {
                    alert("删除失败, id: " + id);
                }
            }
        })
    }

    function recycleBin() {
        self.location = "./recycleBinList";
    }
</script>

</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
