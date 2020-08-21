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
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 刘杰
 * @description 注册操作
 * @date 2020/8/14 10:34
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    /**
     * 添加操作，采用post方式
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletEncoding.setEncoding(req, resp);
        String valiateNum=req.getParameter("valiateNum");
        //int valiateNum=Integer.parseInt(req.getParameter("valiateNum"));
        String phone=req.getParameter("phone");
        String password=req.getParameter("password");
        RoleInfo roleInfo=new RoleInfo(phone,password);
        HttpSession session=req.getSession();
        String vala= (String) session.getAttribute("randomCode");
        RegisterService registerService=new RegisterServiceImp();
        if(valiateNum.equals(vala)){
            try {
                if(!registerService.selectExit(roleInfo)){
                    registerService.registerUser(roleInfo);
                    resp.sendRedirect("/Product_Trade/index.jsp");
                }else{
                    req.setAttribute("message", "账号已存在，请进入登录页面");
                    req.getRequestDispatcher("/Register.jsp").forward(req, resp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            req.setAttribute("message", "验证码输入错误");
            req.getRequestDispatcher("/Register.jsp").forward(req, resp);
        }
    }
}
