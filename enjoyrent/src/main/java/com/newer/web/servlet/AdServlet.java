package com.newer.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class AdServlet extends HttpServlet {
    public AdServlet(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        PrintWriter out=resp.getWriter();
        System.out.println(username+"--"+password);
        if ("admin".equals(username)&&"123456".equals(password)){
            out.print("登陆成功");

        }else {
            out.print("用户名或者密码错误");
        }
        out.close();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
