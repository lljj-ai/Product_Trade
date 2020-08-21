<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/8/14
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <title>修改密码界面</title>
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="css/Manage.css">
    <script src="js/ProductVa.js"></script>
    <style type="text/css">
        .content_left1{
            float: left;
            margin-top: 8px;
            font-size: 20px;
            color: white;
        }
        .content_right1{
            float: right;
            margin-top: 8px;
            font-size: 20px;
            color: white;
        }
        .content_top{
            height:40px;
            background-color:black;
        }
    </style>
    <script>
        function forword() {
            window.location.href="/Product_Trade/ProductTradeShowServlet";
        }
        function checkFiled(obj){
            if("password"==obj){
                var password=document.form.password;
                var reg=/(?=.*([a-zA-Z].*))(?=.*[0-9].*)[a-zA-Z0-9-*/+.~!@#$%^&*()]{6,20}$/;
                if(password.value==""){
                    document.getElementById("password_msg").innerHTML="密码不能为空";
                    password.focus();
                }else if(!reg.test(password.value)){
                    document.getElementById("password_msg").innerHTML="密码格式不正确";
                    password.focus();
                }else{
                    document.getElementById("password_msg").innerHTML="";
                }
            }
        }
    </script>
</head>
<body style="background:url(./image/1.jpg);background-size: 100% 100%; background-attachment: fixed;">
<div class="content_top">
    <div class="content_left1">
        <a href="/Product_Trade/ProductTradeShowServlet" ><span>关闭</span></a>&nbsp;&nbsp;&nbsp;
    </div>
    <div class="content_right1">
        <a href="index.jsp" ><span>注销</span></a>&nbsp;&nbsp;&nbsp;
    </div>
</div>
<br>
<br>
<br>
<br>
<div class="demo">
    <div class="container">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <form name="form" class="form-horizontal" action="/Product_Trade/UpdatePasswordServlet" method="post">
                    <span class="heading">密码修改</span>
                    <div class="form-group help">
                        <input readonly="readonly"  type="text" class="form-control" name="phone" value="${phone}">
                        <b><i class="fa fa-user"></i></b>
                    </div>
                    <div class="form-group help">
                        <input  type="password" required="required" class="form-control" name="password"  placeholder="请输入新的密码" onblur="checkFiled(this.name)">
                        <b><i class="fa fa-lock"></i></b>
                        <span id="password_msg" style="font-size: 12pt;color: red;"></span>
                    </div>
                    <div class="form-group">
                        <button type="button"  class="btn btn-default" onclick="forword()">取消</button>
                        <button type="submit" class="btn btn-default">修改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
