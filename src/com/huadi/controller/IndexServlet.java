package com.huadi.controller;


import com.huadi.config.ServletEncoding;
import com.huadi.service.IndexService;
import com.huadi.serviceImp.IndexServiceImp;
import com.huadi.util.RoleInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 刘杰
 * @description 登录
 * @date 2020/8/3 16:37
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    /**
     * 使用post进行前端和servlet的传递
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletEncoding.setEncoding(request, response);
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        RoleInfo roleInfo=new RoleInfo(phone,password);
        String remeberMe=request.getParameter("remeberMe");
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("user1", roleInfo);
        if (remeberMe!=null) {
            httpSession.setAttribute("user", roleInfo);
            httpSession.setMaxInactiveInterval(60*60*24*7);
        }else{
            RoleInfo user = (RoleInfo) request.getSession().getAttribute("user");
            if(user==null){
                System.out.println("第一次登录");
            }else {
                if(phone.equals(user.getPhoneNum())){
                    httpSession.removeAttribute("user");
                }
            }
        }
        response.sendRedirect("/Product_Trade/ProductTradeShowServlet");
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        RoleInfo user = (RoleInfo) request.getSession().getAttribute("user");
        System.out.println("doGetLoginUser: "+user);
        if (user == null) {
            response.getWriter().write("you without login");
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }
}
