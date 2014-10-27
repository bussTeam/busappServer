package com.springapp.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by thanks_bin on 2014/10/25.
 */
public class UrlFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest)servletRequest;
            String context = request.getContextPath();
            String uri = request.getRequestURI();
            CallBackContentHolder.setCallBackFuncName(request.getParameter("callback"));
            String path = uri.substring(context.length());
            request.getRequestDispatcher(path).forward(servletRequest, servletResponse);
        }

    @Override
    public void destroy() {

    }
}
