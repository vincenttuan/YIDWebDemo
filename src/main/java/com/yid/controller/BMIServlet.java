package com.yid.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 此服務是一個 Web 服務
// 服務網址：/servlet/bmi
@WebServlet(value = "/servlet/bmi")
public class BMIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 導向 bmi_form.jsp 的表單
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/bmi_form.jsp");
        rd.forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 得到 form 表單資料
        doHandler(req, resp);
    }
    
    private void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 得到 form 表單資料
        String myname = req.getParameter("myname");
        String myheight = req.getParameter("myheight");
        String myweight = req.getParameter("myweight");
        // 計算 bmi, 要先將身高、體重由字串 String 轉成 double
        double h = Double.parseDouble(myheight);
        double w = Double.parseDouble(myweight);
        double bmi = w / Math.pow(h/100, 2);
        // 將 bmi 結果回應(response)給 client 端
        System.out.println(bmi);
        
        // 導向 bmi_form.jsp 的表單
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/bmi_form.jsp");
        req.setAttribute("myname", myname);
        req.setAttribute("myheight", myheight);
        req.setAttribute("myweight", myweight);
        req.setAttribute("bmi", bmi);
        rd.forward(req, resp);
        
    }
    
    
}
