package com.huadi.controller;

import com.huadi.config.ServletEncoding;
import com.huadi.service.SellerManageService;
import com.huadi.serviceImp.SellerManageServiceImp;
import com.huadi.util.Seller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 刘杰
 * @description 添加卖方信息
 * @date 2020/8/12 14:49
 */
@WebServlet("/SellerAddServlet")
public class SellerAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    /**
     * 添加操作，表单传输，使用post方式
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletEncoding.setEncoding(req, resp);
        String name=req.getParameter("name");
        int age=Integer.parseInt(req.getParameter("age"));
        String sex=req.getParameter("sex");
        String area=req.getParameter("area");
        int tel=Integer.parseInt(req.getParameter("tel"));
        Seller seller=new Seller(name,age,sex,area,tel);
        SellerManageService sellerManageService=new SellerManageServiceImp();
        try {
            sellerManageService.addSellers(seller);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/Product_Trade/SellerShowServlet");
    }
}
