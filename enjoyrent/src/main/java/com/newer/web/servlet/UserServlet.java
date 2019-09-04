package com.newer.web.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newer.domain.User;
import com.newer.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");


        try {
        if ("addUser".equals(action)){
                addUser(req,resp);
        }else if ("".equals(action)){

            findAll(req,resp);


        }
        } catch (InvocationTargetException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp)throws IOException {
        List<User> list=userService.findAll();
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd hh-mm-ss").create();



        PrintWriter out=resp.getWriter();
        out.print(gson.toJson(list));
        out.close();
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        User user=new User();
        BeanUtils.populate(user,req.getParameterMap());
        int rows=userService.addUser(user);
        PrintWriter out=resp.getWriter();
        out.print(rows);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        userService=new UserService();
    }
}
