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
 * @description 买方信息修改
 * @date 2020/8/12 14:51
 */
@WebServlet("/SellerUpdateServlet")
public class SellerUpdateServlet extends HttpServlet {
    /**
     * 根据id查询一个卖方的完整信息，使用get方式
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletEncoding.setEncoding(req, resp);
        int id=Integer.parseInt(req.getParameter("uuid"));
        Seller seller1=new Seller(id);
        SellerManageService sellerManageService=new SellerManageServiceImp();
        Seller seller=null;
        try {
            seller=sellerManageService.selectSellerById(seller1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("list",seller);
        req.getRequestDispatcher("/SellerUpdate.jsp").forward(req,resp);
    }

    /**
     * 修改操作，表单提交，采用post方式
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletEncoding.setEncoding(req, resp);
        int id=Integer.parseInt(req.getParameter("userId"));
        String name=req.getParameter("name");
        int age=Integer.parseInt(req.getParameter("age"));
        String sex=req.getParameter("sex");
        String area=req.getParameter("area");
        int tel=Integer.parseInt(req.getParameter("tel"));
        Seller seller=new Seller(id,name,age,sex,area,tel);
        SellerManageService sellerManageService=new SellerManageServiceImp();
        try {
            sellerManageService.updateSellers(seller);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/Product_Trade/SellerShowServlet");
    }
}
