package com.kuang.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();

//        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/gp");
//        requestDispatcher.forward(req,resp);//调用forward实现请求转发
        System.out.println("进入了ServletDemo04");
        context.getRequestDispatcher("/gp").forward(req,resp);


    }



}
