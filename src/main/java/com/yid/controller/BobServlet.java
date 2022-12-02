package com.yid.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
        // req：接收 client 端來的資訊
        String nameOfStudent = req.getParameter("nameOfStudent");
        String ageOfStudent  = req.getParameter("ageOfStudent");
        String subject       = req.getParameter("subject"); // 只會抓第一個
        String[] subjects    = req.getParameterValues("subject");
        
        // resp：回應給 client 端來的資訊
        resp.setCharacterEncoding("UTF-8"); // 支援中文編碼
        PrintWriter out = resp.getWriter();
        out.println("Post Bob");
        out.println("Name of student: " + nameOfStudent);
        out.println("Age of student: " + ageOfStudent);
        out.println("Subject: " + subject);
        out.println("Subjects: " + Arrays.toString(subjects));
        for(int i=0; i < subjects.length ; i++) {
            out.printf("第 %d 科: %s\n", (i+1), subjects[i]);
        }
    }

    
    
}
