package com.huadi.filter;

import com.huadi.config.FilterEncoding;
import com.huadi.service.IndexService;
import com.huadi.serviceImp.IndexServiceImp;
import com.huadi.util.RoleInfo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 刘杰
 * @description 登录过滤器
 * @date 2020/8/5 11:15
 */
@WebFilter(filterName = "IndexFilter", urlPatterns = {"/IndexServlet"})
public class IndexFilter implements Filter {
    /**
     * 初始化
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("登录过滤器初始化");
    }

    /**
     * 执行
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器执行前");
        FilterEncoding.setEncoding(servletRequest, servletResponse);
        String phone = servletRequest.getParameter("phone");
        String password = servletRequest.getParameter("password");
        RoleInfo roleInfo = new RoleInfo(phone, password);
        IndexService indexService = new IndexServiceImp();
        try {
            if (indexService.index(roleInfo)) {
                filterChain.doFilter(servletRequest, servletResponse);
                System.out.println("通过");
            } else {
                servletRequest.setAttribute("message", "登录失败，请重新登录");
                servletRequest.getRequestDispatcher("/index.jsp").forward(servletRequest, servletResponse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 销毁
     */
    @Override
    public void destroy() {
        System.out.println("销毁过滤器");
    }
}
