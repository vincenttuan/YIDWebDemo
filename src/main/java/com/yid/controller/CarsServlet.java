package com.yid.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cars")
public class CarsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        URL url = new URL("http://192.168.1.246:20100/cars");
        
        String data = new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next();
        
        resp.getWriter().print(data);
    }
    
}
