<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 引入 jstl -->
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Recycle bin</title>
    <%@include file="common/head.jsp" %>
</head>
<body>

<!-- 页面显示部分 -->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>选择对应列表还原</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>名称</th>
                    <th>库存</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>创建时间</th>
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
                            <a class="btn btn-success " onclick="restore('${sk.seckillId}');">还原</a>
                            <a class="btn btn-danger" onclick="del('${sk.seckillId}');">彻底删除</a>
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
                        <td><a href="<c:url value="/seckill/recycleBinList?page=${pageNow - 1}"/>">上一页</a></td>
                    </c:if>
                    <c:if test="${pageNow lt totalPage && pageNumber le totalPage}">
                        <td><a href="<c:url value="/seckill/recycleBinList?page=${pageNow + 1}"/>">下一页</a></td>
                    </c:if>
                </tr>
                </thead>
            </table>
        </div>
    </div>

</div>
<script type="text/javascript">

    function restore(id) {
        $.ajax({
            url: "logicallyDeleted.action",	//请求url
            type: "POST",	//请求类型  post|get
            data: {
                "id": id
            },
            dataType: "json",  //返回数据的 类型 text|json|html--
            success: function (data) {	//回调函数 和 后台返回的 数据
                if (data === 0) {
                    alert("还原成功");
                    window.location.reload(true);
                } else {
                    alert("还原失败 id: " + id);
                }
            }
        });
    }

    function del(id) {
        $.ajax({
            url: "del.action",
            type: "POST",
            data: {
                "id": id
            },
            dataType: "json",
            success: function (data) {
                if (data === 0) {
                    alert("彻底删除成功！");
                    window.location.reload(true);
                } else {
                    alert("删除失败，稍后重试 id: " + id);
                }
            }
        })
    }

</script>

</body>

</html>
