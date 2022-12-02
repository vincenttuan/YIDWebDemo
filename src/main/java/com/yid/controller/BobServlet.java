package com.yid.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/bob")
public class BobServlet extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req：接收 client 端來的資訊 (Ex: /bob?name=Java&age=29)
        String name = req.getParameter("name");
        String age  = req.getParameter("age");
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        
        // resp：回應給 client 端來的資訊
        PrintWriter out = resp.getWriter();
        out.println("Get Bob");
        out.println("name: " + name);
        out.println("age: " + age);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    
    
}
