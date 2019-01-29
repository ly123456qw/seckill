<%--
  Created by IntelliJ IDEA.
  User: LiuYan
  Date: 2019/1/15
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>学生社团管理系统</title>
    <link rel="stylesheet" type="text/css" href="../../resources/static/css/style.css" />
    <script type="text/javascript" src="../../resources/static/js/jquery-1.8.3.min.js"></script>
</head>

<body style="background:#328f46">
<div class="headiv">
    <div class="logotag">
        <a class="logo"><img src="../../resources/static/img/logo.png" width="440" height="65"></a>
        <b class="line"></b>
    </div>
    <a class="username">欢迎登录：<i>admin</i></a>
    <span class="btnbox">
    	<a class="update" href="#" title="修改"></a><a class="exit" href="#" title="退出"></a>
    </span>
    <div class="clear" style="height:20px; background:#328f46"></div>
</div>

<div class="messagebox">
    <div class="messageleft">
        <ul class="Fstage">
            <li><a href="#"><em class="e1"></em>常用操作<div class="clear"></div></a>
                <ul class="Tstage" >
                    <li><a href="index.html">欢迎页面</a></li>
                    <li><a href="Manage_statistics.html">县域统计</a></li>
                </ul>
            </li>
            <li><a href="#"><em class="e2"></em>账号管理<div class="clear"></div></a>
                <ul class="Tstage">
                    <li><a href="Manage_account.html">账户信息</a></li>
                    <li><a href="Manage_safe.html">账户安全</a></li>
                </ul>
            </li>
            <li><a href="#"><em class="e3"></em>县域统计<div class="clear"></div></a>
                <ul class="Tstage">
                    <li><a href="Manage_tiyan.html">县域交易额信息</a></li>
                    <li><a href="Manage_tiyan.html">体验店信息</a></li>
                    <li><a href="Manage_pinkun.html">贫困户信息</a></li>
                    <li><a href="Manage_diansh.html">电商培训</a></li>
                    <li><a href="Manage_wuliu.html">物流车辆</a></li>
                </ul>
            </li>

        </ul>
    </div>
    <div class="messageright">
        <div class="picbig">
            <img src="img/welcome.jpg">
        </div>
    </div>
    <div class="clearh" style="height:0"></div>
</div>

</body>
</html>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>