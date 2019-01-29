<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>社团管理系统</title>
    <link rel="stylesheet" type="text/css" href="../../resources/static/css/style.css" />
    <script type="text/javascript" src="../../resources/static/js/jquery-1.8.3.min.js"></script>
</head>

<body>
<div class="container">
    <div class="loginbox">
        <div class="loginform">
            <div class="clear" style="height:146px"></div>
            <h2>社团管理系统</h2>
            <form id="addMessage">
                <table width="100%" border="0">
                    <tr>
                        <td>
                            <span>用户名</span>
                            <input class="uname" type="text" id="number" name="number" placeholder="请输入学号"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>密码</span>
                            <input class="pword" type="password" id="password" name="password" placeholder="请输入密码"/>
                        </td>
                    </tr>

                    <tr>
                        <td height="80">
                            <a style="margin-top: 10px"  class="logbtn" onclick="login()">登录</a>
                            <a style="margin-top: 20px"  class="logbtn" onclick="register()">注册</a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    function login() {
        var all = $('#addMessage').serialize();
        $.ajax({
            url: "enterUser.action",
            type: "POST",
            data: all,
            dataType: "json",
            success: function (data) {
                if (data === 1) {
                    alert("登录成功");
                    self.location = "./studentSuccessInfo";
                } else if (data === 0) {
                    alert("学号或者密码输入错误");
                    self.location = "./login";
                } else {
                    alert("请输入学号或者密码，ID：" + "data: " + data);
                    self.location = "./login";
                }
            }
        })
    }

    function register() {
        self.location = "./register";
    }
</script>
</body>
</html>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
