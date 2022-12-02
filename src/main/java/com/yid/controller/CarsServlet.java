package com.yid.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        
        PrintWriter out = resp.getWriter();
        out.println(data);
        
        /*
        -1,-1,0,-1,0,-1<br>
        1,1002,36,100,2,0<br>
        -1,-1,0,-1,0,-1<br>
        */
        
        String[] cars = data.split("<br>");
        out.println(Arrays.toString(cars));
        
        List<String[]> carList = new ArrayList<>();  // 建立 carList  動態陣列（用來收集每一組 carArray）
        for(String carString : cars) {
            // 每一筆 carString 字串的樣式：Ex: "-1,-1,0,-1,0,-1"
            String[] carArray = carString.split(",");  // 變成陣列：[-1,-1,0,-1,0,-1]
            carList.add(carArray); // 將 carArray  放到 carList  動態陣列中
        }
        
        out.println(carList);
        
    }
    
}
