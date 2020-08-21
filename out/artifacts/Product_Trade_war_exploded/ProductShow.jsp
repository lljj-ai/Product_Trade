<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/8/10
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8");%>
<%response.setCharacterEncoding("utf-8");%>
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
    <script src="echarts/echarts.js"></script>
    <script type="text/javascript">
        $("document").ready(function () {
            $("#productManage").click(function () {
                window.location.href="/Product_Trade/ProductShowServlet";
            });
        });
        function sellerMan() {
            window.location.href="/Product_Trade/SellerShowServlet";
        }
        function getLine(){
            var main=document.getElementById("main");
            main.style.display='block';
            var div1=echarts.init(document.getElementById("main1"));
            $.ajax({
                url:"/Product_Trade/ReportServlet",
                type:"post",
                dataType:"json",
                success: function (json) {
                    var nameList=json.nameList;
                    var profitList=json.profitList;
                    var option={
                        title:{
                            text:"利润线图"
                        },
                        xAxis:{
                            name:"商品名称",
                            data:nameList
                        },
                        yAxis:{
                            type:"value",
                        },
                        series:[
                            {
                              name:"总利润",
                              type:"line",
                              data:profitList
                        }
                        ]
                    }
                    div1.setOption(option);
                }
            });
        }
        function getPie() {
            var main=document.getElementById("main");
            main.style.display='block';
            var div1=echarts.init(document.getElementById("main2"));
            $.ajax({
                url:"/Product_Trade/ReportServlet",
                type:"post",
                dataType:"json",
                success: function (json) {
                    var nameList=json.nameList;
                    var profitList=json.profitList;
                    var value=[];
                    for(var i=0;i<nameList.length;i++){
                        value[i]={"name":nameList[i],"value":profitList[i]};
                    }
                    var option={
                        tooltip: {
                            show:true
                        },
                        legend: {
                            data:nameList
                        },
                        series:[
                            {
                                radius:"50%",
                                name:"利润饼图",
                                type:"pie",
                                data:value
                            }
                        ]
                    }
                    div1.setOption(option);
                }
            });
        }
        function getBar() {
            var main=document.getElementById("main");
            main.style.display='block';
            var div1=echarts.init(document.getElementById("main3"));
            $.ajax({
                url:"/Product_Trade/ReportServlet",
                type:"post",
                dataType:"json",
                success: function (json) {
                    var nameList=json.nameList;
                    var profitList=json.profitList;
                    var option = {
                        title:{
                            text:"利润柱状图"
                        },
                        xAxis: {
                            type: 'category',
                            data: nameList
                        },
                        yAxis: {
                            type: 'value',
                        },
                        series: [{
                            data: profitList,
                            type: 'bar'
                        }]
                    };
                    div1.setOption(option);
                }
            });
        }
        function updatePassword() {
            var id=document.getElementById("page222").value;
            window.location.href="/Product_Trade/UpdatePasswordServlet？page222="+id;
        }
    </script>
</head>
<body style="background:url(./image/1.jpg);background-size: 100% 100%; background-attachment: fixed;">
<div class="content_top">
    <div class="content_regist">
        <a href="index.jsp" ><span>注销</span></a>&nbsp;&nbsp;&nbsp;
        <a href="/Product_Trade/UpdatePasswordServlet" ><span>修改密码</span></a>
    </div>
</div>
<div style="height:400px ;display: none" id="main">
    <div id="main1" class="col-md-4"style="width: 33%;height:400px;"></div>
    <div id="main2" class="col-md-4" style="width: 33%;height:400px;"></div>
    <div id="main3" class="col-md-4" style="width: 33%;height:400px;"></div>
</div>
<div class="content">
    <br>
    <div class="table_c">
        <table align="center" class="table table-bordered">
            <caption><h2>简易商品报表</h2></caption>
            <tr>
                <th>商品ID</th>
                <th>商品名称</th>
                <th>交易数量</th>
                <th>交易次数</th>
                <th>商品利润</th>
            </tr>
            <c:forEach items="${list}" var="list">
            <tr>
                <td>${list.productId}</td>
                <td>${list.productName}</td>
                <td>${list.tradeNumber}</td>
                <td>${list.tradeTimes}</td>
                <td>${list.profit}</td>
            </tr>
            </c:forEach>
        </table>
        <button class="btn btn-primary" type="button" id="productManage">商品管理</button>
        <button class="btn btn-primary" type="button" onclick="sellerMan()">买方信息管理</button>
        <button class="btn btn-primary" type="button" onclick="getBar()">生成柱状图</button>
        <button class="btn btn-primary" type="button" onclick="getPie()">生成饼图</button>
        <button class="btn btn-primary" type="button" onclick="getLine()">生成折线图</button>
    </div>
</div>
</body>
</html>
