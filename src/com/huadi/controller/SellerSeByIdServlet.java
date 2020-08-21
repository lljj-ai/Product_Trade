package com.huadi.controller;

import com.huadi.config.ServletEncoding;
import com.huadi.service.SellerManageService;
import com.huadi.serviceImp.SellerManageServiceImp;
import com.huadi.util.Seller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘杰
 * @description 根据id进行查询
 * @date 2020/8/12 16:02
 */
@WebServlet("/SellerSeByIdServlet")
public class SellerSeByIdServlet extends HttpServlet {
    /**
     * 根据id查询操作，使用get方式
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletEncoding.setEncoding(req, resp);
        int id=Integer.parseInt(req.getParameter("uid"));
        Seller seller1=new Seller(id);
        SellerManageService sellerManageService=new SellerManageServiceImp();
        Seller seller=null;
        try {
             seller=sellerManageService.selectSellerById(seller1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Seller> list=new ArrayList<>();
        list.add(seller);
        req.setAttribute("list",list);
        req.getRequestDispatcher("/SellerManage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
