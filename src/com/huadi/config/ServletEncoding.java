package com.huadi.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author 刘杰
 * @description 设置编码
 * @date 2020/8/5 9:04
 */
public class ServletEncoding {
    /**
     * Servlet编码设置
     * @param request
     * @param response
     * @throws UnsupportedEncodingException
     */
    public static void setEncoding(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html,utf-8");
    }
}
