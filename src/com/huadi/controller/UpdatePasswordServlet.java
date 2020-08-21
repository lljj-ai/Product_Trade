package com.huadi.controller;

import com.huadi.config.ServletEncoding;
import com.huadi.service.RegisterService;
import com.huadi.serviceImp.RegisterServiceImp;
import com.huadi.util.RoleInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 刘杰
 * @description
 * @date 2020/8/14 11:51
 */
@WebServlet("/UpdatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletEncoding.setEncoding(req, resp);
        HttpSession session=req.getSession();
        RoleInfo roleInfo=(RoleInfo) session.getAttribute("user1");
        String phone = roleInfo.getPhoneNum();
        System.out.println(phone);
        req.setAttribute("phone",phone);
        req.getRequestDispatcher("/UpdatePassword.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletEncoding.setEncoding(req, resp);
        String phone=req.getParameter("phone");
        String password=req.getParameter("password");
        RoleInfo roleInfo=new RoleInfo(phone,password);
        RegisterService registerService=new RegisterServiceImp();
        try {
            registerService.updatePassword(roleInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session=req.getSession();
        RoleInfo user = (RoleInfo) req.getSession().getAttribute("user");
        if(user==null){
            System.out.println("第一次登录");
        }else {
            if(phone.equals(user.getPhoneNum())){
                session.removeAttribute("user");
            }
        }
        resp.sendRedirect("/Product_Trade/ProductTradeShowServlet");
    }
}
