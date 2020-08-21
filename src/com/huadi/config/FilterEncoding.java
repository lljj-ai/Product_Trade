package com.huadi.config;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author 刘杰
 * @description
 * @date 2020/8/5 11:30
 */
public class FilterEncoding {
    /**
     * 过滤器的编码格式配置
     * @param request
     * @param response
     * @throws UnsupportedEncodingException
     */
    public static void setEncoding(ServletRequest request, ServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html,utf-8");
    }
}
