package com.huadi.controller;

import com.alibaba.fastjson.JSON;
import com.huadi.config.ServletEncoding;
import com.huadi.service.ProductTradeService;
import com.huadi.serviceImp.ProductTradeServiceImp;
import com.huadi.util.TradeInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘杰
 * @description
 * @date 2020/8/13 14:59
 */
@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletEncoding.setEncoding(req,resp);
        ProductTradeService productTradeService=new ProductTradeServiceImp();
        List<TradeInfo> list=null;
        List<Integer> profitList=null;
        try {
             list=productTradeService.tradeProduct();
             profitList=productTradeService.tradeProfit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<String> nameList=new ArrayList<>();
        for(TradeInfo tradeInfo:list){
            nameList.add(tradeInfo.getProductName());
        }
        Map<String,Object> map=new HashMap<>();
        map.put("nameList",nameList);
        map.put("profitList",profitList);
        PrintWriter printWriter=resp.getWriter();
        printWriter.write(JSON.toJSONString(map));
    }
}
