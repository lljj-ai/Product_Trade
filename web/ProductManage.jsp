<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/8/10
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="itcast" uri="http://itcast.cn/common/"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>页面</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
          crossorigin="anonymous">

    <link rel="stylesheet" href="css/Main.css">
    <script src="jQuery/js/jquery-3.4.1.min.js"></script>
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
    </style>
    <script>
        function dele() {
/*            var productId=document.getElementById("gd_id").value;
            if(productId==null||productId==""){
                alert("请选择一件商品")
            }else {
                window.open("http://localhost:8080/Product_Trade/ProductDeleteServlet?goods_id="+productId);
            }*/
            var item = $(":radio:checked");
            var len=item.length;
            if(len>0){
                window.location.href="/Product_Trade/ProductDeleteServlet?goods_id="+$(":radio:checked").val();
                //window.open("http://localhost:8080/Product_Trade/ProductDeleteServlet?goods_id="+$(":radio:checked").val());
            }else{
                alert("请选择一个商品");
            }
        }
        function  update() {
            var item = $(":radio:checked");
            var len=item.length;
            if(len>0){
                window.location.href="/Product_Trade/ProductUpdateServlet?goods_id="+$(":radio:checked").val();
            }else{
                alert("请选择一个商品");
            }
        }
        function  add() {
            window.location.href="/Product_Trade/ProductAdd.jsp";
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
<div class="content">
    <br>
    <div class="table_c">
        <h2 style="color: white;margin-left: 40%;">商品信息管理</h2>
        <button class="btn btn-primary" style="width: 100px;height: 50px;font-size: 20px;" type="button" id="addProduct" onclick="add()" >添加</button>
        &nbsp;&nbsp;&nbsp;<button class="btn btn-primary" style="width: 100px;height: 50px;font-size: 20px;" type="updateProduct" onclick="update()">修改</button>
        &nbsp;&nbsp;&nbsp;<button class="btn btn-primary" style="width: 100px;height: 50px;font-size: 20px;" type="deleteProduct" onclick="dele()">删除</button>
        <table align="center" class="table table-bordered">
            <tr>
                <th>选择</th>
                <th>商品名称</th>
                <th>成本价</th>
                <th>销售价</th>
                <th>制造商</th>
            </tr>
            <c:forEach items="${list}" var="list">
                <tr>
                    <td>
                        <%--<input id="gd_id" name="gd_id"  type="hidden">--%>
                        <input   type="radio" id="gd_id" name="goods_id" value="${list.productId}"  >
                    </td>
                    <td>${list.productName}</td>
                    <td>${list.costPrice}</td>
                    <td>${list.sellingPrice}</td>
                    <td>${list.manufacture}</td>
                </tr>
            </c:forEach>
        </table>
        <div class="text-center">
            <itcast:page url="/Product_Trade/ProductShowServlet"></itcast:page>
        </div>
    </div>
</div>
</body>
</html>
