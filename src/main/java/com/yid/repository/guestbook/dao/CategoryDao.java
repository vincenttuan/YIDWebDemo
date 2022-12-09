package com.yid.repository.guestbook.dao;

import com.yid.repository.YIDConnection;
import com.yid.repository.guestbook.entity.Category;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    private static Connection conn =  YIDConnection.getConnection();
    
    // 查詢單筆
    public Category getById(Integer id) {
        Category category = null;
        String sql  = "select id, name from category where id=?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) { // rs.next() 若是 true 表示有資料
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
            }
            rs.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return category;
    }
    
    // 全部查詢
    public List<Category> queryAll() {
        List<Category> categories = new ArrayList<>();
        String sql = "select id, name from category order by id";
        try(PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();) {
            
            while (rs.next()) {                
                Category category = new Category(); // 建立 Category 物件
                // O/R Mapping
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                
                categories.add(category); // 放入到 categories 集合中
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return categories;
    }
    
}
