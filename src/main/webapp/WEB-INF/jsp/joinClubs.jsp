<%--
  Created by IntelliJ IDEA.
  User: LiuYan
  Date: 2019/1/30
  Time: 15:27
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
        <a class="logo"><img src="img/logo.png" width="440" height="65"></a>
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
                    <li><a href="#">加入社团</a></li>
                    <li><a href="Manage_statistics.html">查看所属社团</a></li>
                    <li><a href="Manage_statistics.html">查看公告</a></li>
                </ul>
            </li>
            <li><a href="#"><em class="e2"></em>社团简介<div class="clear"></div></a>
                <ul class="Tstage">
                    <li><a href="Manage_account.html">社团展示</a></li>
                    <li><a href="Manage_safe.html">申请社团</a></li>
                </ul>
            </li>

        </ul>
    </div>
    <div class="messageright">
        <div class="formpage">
            <div class="clear" style="height:20px"></div>
            <h2>账户信息</h2>
            <div class="clear" style="height:30px"></div>

            <span class="information">
            	<div class="clear" style="height:10px"></div>
            	<a class="headpic1" href="#"><img src="img/sm_headpic.jpg" ></a>
                <form>
                    <table>
                        <tr>
                            <td>登录帐号：</td>
                            <td colspan="2">学生</td></tr>
                        <tr>
                            <td>电子邮箱：</td>
                            <td><input class="textput" type="text"/></td>
                            <td><a class="link" href="#">&nbsp;&nbsp;更换邮箱</a></td></tr>
                        <tr>
                            <td>真实姓名：</td>
                            <td><input class="textput" type="text"/></td>
                            <td><p class="wrrong">*信息有误</p></td>
                        </tr>
                        <tr>
                            <td>性别：</td>
                            <td><label>女<input name="sex" type="radio"></label><label>男<input name="sex" type="radio"></label></td>
                            <td><p class="wrrong">*此处不能为空</p></td>
                        </tr>
                        <tr>
                            <td>生日：</td>
                            <td><input class="textput" type="text"/></td>
                            <td><p class="wrrong"></p></td>
                        </tr>
                        <tr>
                            <td>所在地区：</td>
                            <td class="address"><input id="city-picker3" class="addr" readonly data-toggle="city-picker" type="text"/></td>
                            <td><p class="wrrong"></p></td>
                        </tr>
                        <tr>
                            <td>QQ：</td>
                            <td><input class="textput" type="text"/></td>
                            <td><p class="wrrong"></p></td>
                        </tr>
                        <tr>
                            <td>阿里旺旺：</td>
                            <td><input class="textput" type="text"/></td>
                            <td><p class="wrrong"></p></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td colspan="2"><a class="greenbtn" href="#">保存修改</a></td>
                        </tr>
                    </table>
                </form>
                <div class="clear"></div>
            </span>
            <div class="clear" style="height:50px"></div>


        </div>
    </div>
    <div class="clearh" style="height:0"></div>
</div>

</body>
</html>
