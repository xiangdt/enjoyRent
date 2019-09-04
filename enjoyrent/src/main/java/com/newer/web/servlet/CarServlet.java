package com.newer.web.servlet;

import com.google.gson.Gson;
import com.newer.domain.Car;
import com.newer.service.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/cars")
public class CarServlet extends HttpServlet {

    private CarService carService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if("find".equals(action)){
            List<Car> list=carService.find();

            Gson gson=new Gson();
            PrintWriter out = resp.getWriter();
            out.print(gson.toJson(list));
            out.close();
        }
    }

    @Override
    public void init() throws ServletException {
        carService = new CarService();
    }
}
