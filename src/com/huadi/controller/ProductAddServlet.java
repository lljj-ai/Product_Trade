package com.huadi.controller;

import com.huadi.config.ServletEncoding;
import com.huadi.service.ProductManageService;
import com.huadi.serviceImp.ProductManageServiceImp;
import com.huadi.util.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 刘杰
 * @description 添加商品操作
 * @date 2020/8/10 15:11
 */
@WebServlet("/ProductAddServlet")
public class ProductAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    /**
     * 添加商品操作，需要表单提交，使用post方式
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletEncoding.setEncoding(req, resp);
        String productName=req.getParameter("productName");
        int costPrice=Integer.parseInt(req.getParameter("costPrice"));
        int sellingPrice=Integer.parseInt(req.getParameter("sellingPrice"));
        String manufacture=req.getParameter("manufacture");
        Product product=new Product(productName,costPrice,sellingPrice,manufacture);
        ProductManageService productManageService=new ProductManageServiceImp();
        try {
            productManageService.addProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/Product_Trade/ProductShowServlet");
    }
}
