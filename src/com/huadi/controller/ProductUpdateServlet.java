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
 * @description 修改商品信息
 * @date 2020/8/10 15:13
 */
@WebServlet("/ProductUpdateServlet")
public class ProductUpdateServlet extends HttpServlet {
    /**
     * 修改商品的回调查询
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletEncoding.setEncoding(req, resp);
        int productId = Integer.parseInt(req.getParameter("goods_id"));
        Product product=new Product(productId);
        ProductManageService productManageService=new ProductManageServiceImp();
        try {
            Product product1=productManageService.selectProduct(product);
            req.setAttribute("product",product1);
            req.getRequestDispatcher("/ProductUpdate.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 修改商品操作，使用post方式
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletEncoding.setEncoding(req, resp);
        int productId=Integer.parseInt(req.getParameter("productId"));
        String productName=req.getParameter("productName");
        int costPrice=Integer.parseInt(req.getParameter("costPrice"));
        int sellingPrice=Integer.parseInt(req.getParameter("sellingPrice"));
        String manufacture=req.getParameter("manufacture");
        Product product=new Product(productId,productName,costPrice,sellingPrice,manufacture);
        ProductManageService productManageService=new ProductManageServiceImp();
        try {
            productManageService.updateProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/Product_Trade/ProductShowServlet");
    }
}
