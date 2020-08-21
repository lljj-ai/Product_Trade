<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/8/12
  Time: 7:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="itcast" uri="http://itcast.cn/common/"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>页面</title>
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
          crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <link rel="stylesheet" href="css/Main.css">
    <style>
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
        #add{
            margin-left:54%;
        }
        .form-bg{
            background: #00BBFF;
        }
        .form-horizontal{
            background: rgba(0,0,255,0.5);
            padding-bottom: 40px;
            border-radius: 15px;
            text-align: center;
        }
        .form-horizontal .heading{
            display: block;
            font-size: 35px;
            font-weight: 700;
            padding: 35px 0;
            border-bottom: 1px solid #f0f0f0;
            margin-bottom: 30px;
        }
        .form-horizontal .form-group{
            padding: 0 40px;
            margin: 0 0 25px 0;
            position: relative;
        }
        .form-horizontal .form-control{
            background: #f0f0f0;
            border: none;
            border-radius: 20px;
            box-shadow: none;
            padding: 0 20px 0 45px;
            height: 40px;
            transition: all 0.3s ease 0s;
        }
        .form-horizontal .form-control:focus{
            background: #e0e0e0;
            box-shadow: none;
            outline: 0 none;
        }
        .form-horizontal .form-group i{
            position: absolute;
            top: 12px;
            left: 60px;
            font-size: 17px;
            color: #c8c8c8;
            transition : all 0.5s ease 0s;
        }
        .form-horizontal .form-control:focus + i{
            color: #00b4ef;
        }
        .form-horizontal .fa-question-circle{
            display: inline-block;
            position: absolute;
            top: 12px;
            right: 60px;
            font-size: 20px;
            color: #808080;
            transition: all 0.5s ease 0s;
        }
        .form-horizontal .fa-question-circle:hover{
            color: #000;
        }
        .form-horizontal .main-checkbox{
            float: left;
            width: 20px;
            height: 20px;
            background: #11a3fc;
            border-radius: 50%;
            position: relative;
            margin: 5px 0 0 5px;
            border: 1px solid #11a3fc;
        }
        .form-horizontal .main-checkbox label{
            width: 20px;
            height: 20px;
            position: absolute;
            top: 0;
            left: 0;
            cursor: pointer;
        }
        .form-horizontal .main-checkbox label:after{
            content: "";
            width: 10px;
            height: 5px;
            position: absolute;
            top: 5px;
            left: 4px;
            border: 3px solid #fff;
            border-top: none;
            border-right: none;
            background: transparent;
            opacity: 0;
            -webkit-transform: rotate(-45deg);
            transform: rotate(-45deg);
        }
        .form-horizontal .main-checkbox input[type=checkbox]{
            visibility: hidden;
        }
        .form-horizontal .main-checkbox input[type=checkbox]:checked + label:after{
            opacity: 1;
        }
        .form-horizontal .text{
            float: left;
            margin-left: 7px;
            line-height: 20px;
            padding-top: 5px;
            text-transform: capitalize;
        }
        .form-horizontal .btn{
            float: right;
            font-size: 14px;
            color: #fff;
            background: #00b4ef;
            border-radius: 30px;
            padding: 10px 25px;
            border: none;
            text-transform: capitalize;
            transition: all 0.5s ease 0s;
        }
        @media only screen and (max-width: 479px){
            .form-horizontal .form-group{
                padding: 0 25px;
            }
            .form-horizontal .form-group i{
                left: 45px;
            }
            .form-horizontal .btn{
                padding: 10px 20px;
            }

        }
    </style>
    <script type="text/javascript">
        function selectById() {
            var value=document.getElementById("uid").value;
            window.location.href="/Product_Trade/SellerSeByIdServlet?uid="+value;
        }
        function add() {
            window.location.href="/Product_Trade/SellerAdd.jsp";
        }
        function showAll() {
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

<div class="content_right2">
    <br>
    <div class="search">
        <div class="form-inline">
            <input class="form-control" type="text"  id="uid" name="uid" placeholder="请输入要查询的id">&nbsp;&nbsp;
            <button type="button" class="btn btn-primary " onclick="selectById()"  >
                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
            </button>
            <button type="button" id="button1" class="btn btn-primary " onclick="showAll()"  >显示全部</button>
            <button id="add" type="submit" class="btn btn-primary"  data-toggle="modal" data-target="#myModal" >
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span><%--onclick="add()"--%>
            </button>
        </div>
    </div>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        添加买家信息
                    </h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="/Product_Trade/SellerAddServlet" method="post">
                        <span class="heading">添加买方信息</span>
                        <div class="form-group help">
                            <input  type="text" required="required" class="form-control" name="name" id="name" placeholder="请输入买方名称" onblur="check(this.name)">
                            <b><i class="fa fa-user-md"></i></b>
                            <span id="name_msg" style="font-size: 12pt;color: red;"></span>
                        </div>
                        <div class="form-group">
                            <input  type="text" required="required" class="form-control" name="age" id="age"   placeholder="请输入买方年龄" onblur="check(this.name)">
                            <b><i class="fa fa-address-card" aria-hidden="true"></i></b>
                            <span id="age_msg" style="font-size: 12pt;color: red;"></span>
                        </div>
                        <div class="form-group help">
                            <input type="text" required="required" class="form-control" name="sex" id="sex"  placeholder="请输入买方性别" onblur="check(this.name)">
                            <b><i class="fa fa-transgender"></i></b>
                            <span id="sex_msg" style="font-size: 12pt;color: red;"></span>
                        </div>
                        <div class="form-group">
                            <input  type="text" required="required" class="form-control" name="area" id="area"  placeholder="请输入区域" onblur="check(this.name)">
                            <b><i class="fa fa-subway" aria-hidden="true"></i></b>
                            <span id="area_msg" style="font-size: 12pt;color: red;"></span>
                        </div>
                        <div class="form-group">
                            <input  type="text" required="required" class="form-control" name="tel" id="tel"  placeholder="请输入数量" onblur="check(this.name)">
                            <b><i class="fa fa-adn" aria-hidden="true"></i></b>
                            <span id="tel_msg" style="font-size: 12pt;color: red;"></span>
                        </div>
                        <div class="form-group">
                            <button type="button"  class="btn btn-default" onclick="forword()">取消</button>
                            <button type="submit" class="btn btn-default">添加</button>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" class="btn btn-primary">
                        提交更改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    <div class="table_c">
        <table align="center" class="table table-bordered">
            <caption><h2>买方信息显示表</h2></caption>
            <tr>
                <th>买方id</th>
                <th>买方姓名</th>
                <th>买方年龄</th>
                <th>买方性别</th>
                <th>区域</th>
                <th>数量</th>
                <th colspan="2">操作</th>
            </tr>
            <c:forEach items="${list}" var="list">
            <tr>
                <td>${list.userId}</td>
                <td>${list.name}</td>
                <td>${list.age}</td>
                <td>${list.sex}</td>
                <td>${list.area}</td>
                <td>${list.tel}</td>
                <td>
                    <form action="/Product_Trade/SellerUpdateServlet?uuid=${list.userId}" method="get">
                        <input type="hidden" name="uuid" value="${list.userId}">
                        <button type="submit" class="btn btn-primary ">
                        <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                        </button>
                    </form>
                </td>
                <td>
                    <form action="/Product_Trade/SellerDeleteServlet?uuuid=${list.userId}" method="post">
                        <input type="hidden" name="uuuid" value="${list.userId}">
                        <button type="submit" class="btn btn-danger">
                        <b><span class="glyphicon glyphicon-remove"
                                 aria-hidden="true"></span></b>
                        </button>
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table>
        <div class="text-center">
            <itcast:page url="/Product_Trade/SellerShowServlet"></itcast:page>
        </div>
    </div>
</div>
</body>
</html>
