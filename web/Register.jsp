<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/8/14
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册页面</title>
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
          crossorigin="anonymous">
    <link rel="stylesheet" href="css/index.css">
    <script src="js/Register.js"></script>
    <script src="jQuery/js/jquery-3.4.1.min.js"></script>
    <style>
        .content_login {
            width: 420px;
            height: 400px;
            background-color: rgba(0, 0, 100, 0.4);
            margin-top: 180px;
            margin-left: 36%;
            color: white;
        }
        .content_top{
            height:40px;
            background-color:black;
        }
        .content_regist {
            padding-top:8px;
            padding-left: 89%;
            color:white;
            font-size: 15pt;
        }
    </style>
    <script type="text/javascript">
        function change() {
            var pic = document.getElementById("picture");
            var i = Math.random();//目的是使页面不一样
            pic.src = "Validate.jsp?id=" + i;
        }
    </script>
</head>
<body style="background:url(./image/5.jpg);background-size: 100% 100%; background-attachment: fixed;">
<div class="content_top">
    <div class="content_regist">
        <a href="index.jsp" ><span>登录</span></a>
    </div>
</div>
<div class="content_main">
    <div class="content_login">
        <center>
            <form name="form" action="RegisterServlet" class="form-horizontal" method="post">
                <table>
                    <tr>
                        <td colspan="2" align="center" style="color: white"><h2><b>注册信息</b></h2></td>
                    </tr>
                    <tr>
                        <span style="color: red;font-size: 13pt">${message}</span>
                        <div class="form-group help">
                            <td align="right" style="color: white">手&nbsp;机&nbsp;号：</td>
                            <td><input required="required" type="text" name="phone"  class="form-control"
                                       placeholder="请输入你的手机号码" onblur="checkFiled(this.name)">
                                <span id="phone_msg" style="font-size: 8pt;color: red;"></span>
                            </td>
                        </div>
                    </tr>

                    <tr>
                        <div class="form-group help">
                            <td align="right" style="color: white">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                            <td><input required="required" type="password" class="form-control"  name="password"
                                       placeholder="请输入密码" onblur="checkFiled(this.name)">
                                <span id="password_msg" style="font-size: 8pt;color: red;"></span>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="form-group help">
                            <td align="right" style="color: white">确认密码：</td>
                            <td><input required="required" type="password" class="form-control"   name="confirmPW"
                                       placeholder="请再次输入密码" onblur="checkFiled(this.name)">
                                <span id="confirmPW_msg" style="font-size: 8pt;color: red;"></span>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="form-group help">
                            <td align="right" style="color: white">验&nbsp;证&nbsp;码：</td>
                            <td><div class="form-inline"><input required="required" type="password" class="form-control"  name="valiateNum"
                                       placeholder="请输入验证码"  style="width: 120px;" onblur="checkFiled(this.name)">&nbsp;&nbsp;&nbsp;
                                <img src="Validate.jsp" id="picture" onClick="change()"></image>
                            </div>
                                <span id="valiateNum_msg" style="font-size: 8pt;color: red;"></span>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input class="form-control" type="submit" value="注册"
                                                              onsubmit="checkFiled('submit')"
                                                              style="width:100px ;font-size: 13pt;"></td>
                    </tr>

                </table>
            </form>
        </center>
    </div>
</div>
<div class="content"></div>
</body>
</html>
