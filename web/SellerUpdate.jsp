<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/8/12
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <title>修改界面</title>
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="css/Manage.css">
    <script src="js/SellerVa.js"></script>
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
            window.location.href="/Product_Trade/SellerShowServlet";
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
<div class="demo">
    <div class="container">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <form class="form-horizontal" action="/Product_Trade/SellerUpdateServlet" method="post">
                    <span class="heading">买方信息修改</span>
                    <div class="form-group help">
                        <input readonly="readonly" type="text" class="form-control" name="userId" value="${list.userId}">
                        <b><i class="fa fa-id-card"></i></b>
                    </div>
                    <div class="form-group help">
                        <input  type="text" required="required" class="form-control" name="name" id="name" value="${list.name}" placeholder="请输入新的买方名称" onblur="check(this.name)">
                        <b><i class="fa fa-user-md"></i></b>
                        <span id="name_msg" style="font-size: 12pt;color: red;"></span>
                    </div>
                    <div class="form-group">
                        <input  type="text" required="required" class="form-control" name="age" id="age" value="${list.age}" placeholder="请输入新的买方年龄" onblur="check(this.name)">
                        <b><i class="fa fa-address-card" aria-hidden="true"></i></b>
                        <span id="age_msg" style="font-size: 12pt;color: red;"></span>
                    </div>
                    <div class="form-group help">
                        <input type="text" required="required" class="form-control" name="sex" id="sex" value="${list.sex}" placeholder="请输入新的买方性别" onblur="check(this.name)">
                        <b><i class="fa fa-transgender"></i></b>
                        <span id="sex_msg" style="font-size: 12pt;color: red;"></span>
                    </div>
                    <div class="form-group">
                        <input  type="text" required="required" class="form-control" name="area" id="area" value="${list.area}" placeholder="请输入新的区域" onblur="check(this.name)">
                        <b><i class="fa fa-subway" aria-hidden="true"></i></b>
                        <span id="area_msg" style="font-size: 12pt;color: red;"></span>
                    </div>
                    <div class="form-group">
                        <input  type="text" required="required" class="form-control" name="tel" id="tel" value="${list.tel}" placeholder="请输入新的数量" onblur="check(this.name)">
                        <b><i class="fa fa-adn" aria-hidden="true"></i></b>
                        <span id="tel_msg" style="font-size: 12pt;color: red;"></span>
                    </div>
                    <div class="form-group">
                        <button type="button"  class="btn btn-default" onclick="forword()">取消</button>
                        <button type="submit" class="btn btn-default" onclick="">修改</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
