package com.wz.controller;

import com.wz.domain.Emp;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.LogRecord;

public class ffilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        if ("login".indexOf(requestURI) != -1 ||"errpr".indexOf(requestURI) !=-1) {
            filterChain.doFilter(servletRequest, servletResponse);
       return;
        }
          HttpSession session = request.getSession(false);
         if (session != null) {

         filterChain.doFilter(servletRequest, servletResponse);
         return ;
            }
       request.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
        }

    @Override
    public void destroy() {

    }
}
