package com.newer.web.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.newer.domain.Park;
import com.newer.service.ParkService;
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

@WebServlet("/parks")
public class ParkServlet extends HttpServlet {
    private ParkService parkService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if("findAll".equals(action)) {
            findAll(req,resp);
        }else if("updateP".equals(action)) {
            updateP(req,resp);
        }else if("addP".equals(action)) {
            addP(req,resp);
        }



    }

    private void addP(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Park park=new Park();
        try {
            BeanUtils.populate(park,req.getParameterMap());
            int rows=parkService.addP(park);
            PrintWriter out=resp.getWriter();
            out.print(rows);
            out.close();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void updateP(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Park park=new Park();
        try {
            BeanUtils.populate(park,req.getParameterMap());
            int rows=parkService.updateP(park);
            PrintWriter out=resp.getWriter();
            out.print(rows);
            out.close();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Park> list=parkService.findAll();
        Gson gson=new GsonBuilder().serializeNulls().create();
        PrintWriter out=resp.getWriter();
        out.print(gson.toJson(list));
        out.close();
    }


    @Override
    public void init() throws ServletException {
        parkService=new ParkService();
    }
}
