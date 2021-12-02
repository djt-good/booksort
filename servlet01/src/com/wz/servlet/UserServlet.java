package com.wz.servlet;

import com.wz.domain.User;
import com.wz.service.UserSsrvice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
@WebServlet("/userAdd")
public class UserServlet extends HttpServlet {
    UserSsrvice userSsrvice = new UserSsrvice();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = new User(null,name,password);
        int i = 0;
        try {
            i = userSsrvice.UserAdd(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = resp.getWriter();
        if(i >0){
             out.write("<h1>添加成功<h1>");
        }else {
            out.write("<h1>添加失败<h1>");
        }

    }
}
