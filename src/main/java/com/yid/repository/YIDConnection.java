package com.yid.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class YIDConnection {
    private static Connection conn =  null;
    
    static {
        
        try {
            // 取得 mysql 的驅動物件
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立連線物件
            String url = "jdbc:mysql://localhost:3306/YID?serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true";
            String user = "root";
            String password = "12345678";
            conn = DriverManager.getConnection(url, user, password);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static Connection getConnection() {
        return conn;
    }
}
