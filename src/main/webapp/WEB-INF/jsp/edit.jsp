<%--
  Created by IntelliJ IDEA.
  User: liuyan
  Date: 2019/1/5
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>修改测试</title>


</head>
<body>
<div class="panel panel-default box" >
    <form id="addMessage">
        <div class="form-group">
            <label for="number">学号</label>
            <input type="number" class="form-control" id="number" name="number" placeholder="输入学号" value="${no}">
        </div>
        <div class="form-group">
            <label for="name">姓名</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="输入姓名" value="${name}">
        </div>
        <div class="form-group">
            <label for="sex">性别</label>
            <input type="text" class="form-control" id="sex" name="sex" placeholder="输入性别" value="${sex}">
        </div>
        <a class="btn btn-default" type="button" onclick="save()">保存</a>
    </form>
</div>

<script type="text/javascript">
    function save() {
        var all = $('#addMessage').serialize();
        console.log(all);
        $.ajax({
            url: "save.action",
            type: "POST",
            data : {
                no: '${no}',
                name: '${name}',
                sex: '${sex}',
                id: '${id}'
            },
            dataType : "json",
            success : function (data) {
                if (data === 1) {
                    alert("保存成功");
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