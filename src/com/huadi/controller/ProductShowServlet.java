package com.huadi.controller;

import cn.itcast.utils.Page;
import com.huadi.config.ServletEncoding;
import com.huadi.service.ProductManageService;
import com.huadi.serviceImp.ProductManageServiceImp;
import com.huadi.toolUtil.QueryVo;
import com.huadi.util.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 刘杰
 * @description 商品信息显示
 * @date 2020/8/10 15:08
 */
@WebServlet("/ProductShowServlet")
public class ProductShowServlet extends HttpServlet {
    /**
     *查询商品信息操作，使用get方式
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletEncoding.setEncoding(req, resp);
        ProductManageService productManageService=new ProductManageServiceImp();
        List<Product> list= null;
        int num=0;
        QueryVo queryVo=new QueryVo();
        String nowPage=req.getParameter("page");
        if(nowPage==null){
            queryVo.setStart(0);
        }else {
            queryVo.setStart((Integer.parseInt(nowPage)-1)*queryVo.getSize());
        }
        try {
            list = productManageService.showProduct(queryVo);
            num = productManageService.totalNum();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Page<Product> page=new Page<>();
        if(nowPage!=null){
            page.setPage(Integer.parseInt(nowPage));
        }
        page.setRows(list);
        page.setSize(queryVo.getSize());
        page.setTotal(num);
        req.setAttribute("page",page);
        req.setAttribute("list",list);
        req.getRequestDispatcher("/ProductManage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
