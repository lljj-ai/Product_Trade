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
 * @description 删除商品信息
 * @date 2020/8/10 15:16
 */
@WebServlet("/ProductDeleteServlet")
public class ProductDeleteServlet extends HttpServlet {
    /**
     * 删除操作，使用get方式
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
            productManageService.deleteProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/Product_Trade/ProductShowServlet");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
