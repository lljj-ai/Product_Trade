<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/8/3
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录页面</title>
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
    <script src="js/index.js"></script>
    <script src="jQuery/js/jquery-3.4.1.min.js"></script>
    <style>
        .content_login {
            width: 420px;
            height: 350px;
            background-color: rgba(0, 0, 100, 0.4);
            margin-top: 200px;
            margin-left: 36%;
            color: white;
        }
    </style>
</head>
<body style="background:url(./image/5.jpg);background-size: 100% 100%; background-attachment: fixed;">
<div class="content_main">
    <div class="content_login">
        <center>
            <form name="form" action="IndexServlet" class="form-horizontal" method="post">
                <table>
                    <tr>
                        <td colspan="2" align="center" style="color: white"><h2><b>登录信息</b></h2></td>
                    </tr>
                    <tr>
                        <span style="color: red;font-size: 13pt">${message}</span>
                        <div class="form-group help">
                            <td align="right" style="color: white">手机号：</td>
                            <td><input required="required" type="text" name="phone" value="${user.phoneNum}" class="form-control"
                                       placeholder="请输入手机号码" onblur="checkFiled(this.name)">
                                <span id="phone_msg" style="font-size: 8pt;color: red;"></span>
                            </td>
                        </div>
                    </tr>

                    <tr>
                        <div class="form-group help">
                            <td align="right" style="color: white">密码：</td>
                            <td><input required="required" type="password" class="form-control" value="${user.password}" name="password"
                                       placeholder="请输入密码" onblur="checkFiled(this.name)">
                                <span id="password_msg" style="font-size: 8pt;color: red;"></span>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="form-group help">
                       <td align="right"><input  type="radio" name="remeberMe" id="remeberMe" value="1" ></td>
                            <td><span style="color: white">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;记住密码</span></td>
                        </div>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input class="form-control" type="submit" value="登录"
                                                              onsubmit="checkFiled('submit')"
                                                              style="width:100px ;font-size: 13pt;"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><a href="./Register.jsp"><span style="color: white;">点击此处进行注册</span></a></td>
                    </tr>
                </table>
            </form>
        </center>
    </div>
</div>
<div class="content"></div>
</body>
</html>
