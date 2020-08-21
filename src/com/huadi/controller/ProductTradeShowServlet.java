package com.huadi.controller;

import com.huadi.config.ServletEncoding;
import com.huadi.service.ProductManageService;
import com.huadi.service.ProductTradeService;
import com.huadi.serviceImp.ProductManageServiceImp;
import com.huadi.serviceImp.ProductTradeServiceImp;
import com.huadi.util.TradeInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 刘杰
 * @description 商品交易表显示
 * @date 2020/8/10 15:05
 */
@WebServlet("/ProductTradeShowServlet")
public class ProductTradeShowServlet extends HttpServlet {
    /**
     * 查询操作，使用get方式
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletEncoding.setEncoding(req, resp);
        ProductTradeService productTradeService=new ProductTradeServiceImp();
        try {
            List<TradeInfo> list=productTradeService.tradeProduct();
            List<Integer> listProfit=productTradeService.tradeProfit();
            Object[] object2=listProfit.toArray();
            Iterator<TradeInfo> iterator=list.iterator();
            int i=0;
            while(iterator.hasNext()){
                iterator.next().setProfit((int)object2[i]);
                i=i+1;
            }
            req.setAttribute("list",list);
            req.getRequestDispatcher("/ProductShow.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
