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
 * @description 删除买方信息
 * @date 2020/8/12 14:47
 */
@WebServlet("/SellerDeleteServlet")
public class SellerDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    /**
     * ，删除操作，表单传输，采用post方式
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletEncoding.setEncoding(req, resp);
        int id=Integer.parseInt(req.getParameter("uuuid"));
        Seller seller=new Seller(id);
        SellerManageService sellerManageService=new SellerManageServiceImp();
        try {
            sellerManageService.deleteSellers(seller);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/Product_Trade/SellerShowServlet");
    }
}
