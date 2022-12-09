package com.yid.repository.guestbook.dao;

import com.yid.repository.YIDConnection;
import com.yid.repository.guestbook.entity.Category;
import com.yid.repository.guestbook.entity.GuestBook;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuestBookDao {
    
    private static Connection conn = YIDConnection.getConnection();
    private CategoryDao categoryDao = new CategoryDao();
    
    // 新增
    public int add(GuestBook guestBook) {
        String sql = "insert into guestBook(category_id, username, email, message) values(?, ?, ?, ?)";
        int rowcount = 0;
        try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, guestBook.getCategory().getId());
            pstmt.setString(2, guestBook.getUsername());
            pstmt.setString(3, guestBook.getEmail());
            pstmt.setString(4, guestBook.getMessage());
            rowcount = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowcount;
    } 
    
    // 修改
    public int update(GuestBook guestBook) {
        String sql = "update guestBook set category_id=?, username=?, email=?, message=?, updatetime=? where id = ?";
        int rowcount = 0;
        try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, guestBook.getCategory().getId());
            pstmt.setString(2, guestBook.getUsername());
            pstmt.setString(3, guestBook.getEmail());
            pstmt.setString(4, guestBook.getMessage());
            pstmt.setDate(5, new java.sql.Date(new Date().getTime()));
            pstmt.setInt(6, guestBook.getId());
            rowcount = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowcount;
    } 
    
    // 刪除
    public int deleteById(Integer id) {
        String sql = "delete from guestBook where id = ?";
        int rowcount = 0;
        try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, id);
            rowcount = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowcount;
    } 
    
    // 單筆查詢
    public GuestBook getById(Integer id) {
        GuestBook guestBook = null;
        String sql = "select id, category_id, username, email, message, updatetime, createtime from guestbook where id=?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()) {
                guestBook = new GuestBook();
                guestBook.setId(rs.getInt("id"));
                guestBook.setUsername(rs.getString("username"));
                guestBook.setEmail(rs.getString("email"));
                guestBook.setMessage(rs.getString("message"));
                guestBook.setUpdatetime(rs.getDate("updatetime"));
                guestBook.setCreatetime(rs.getDate("createtime"));
                // 對應 Category 物件, 要透過 category_id 來查找
                Category category = categoryDao.getById(rs.getInt("category_id"));
                guestBook.setCategory(category);
            }
            
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return guestBook;
    }
    
    
    // 全部查詢
    public List<GuestBook> queryAll() {
        List<GuestBook> guestBooks = new ArrayList<>();
        
        String sql = "select id, category_id, username, email, message, updatetime, createtime from guestbook order by id";
        try(PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();) {
            
            while(rs.next()) {
                GuestBook guestBook = new GuestBook();
                guestBook.setId(rs.getInt("id"));
                guestBook.setUsername(rs.getString("username"));
                guestBook.setEmail(rs.getString("email"));
                guestBook.setMessage(rs.getString("message"));
                guestBook.setUpdatetime(rs.getDate("updatetime"));
                guestBook.setCreatetime(rs.getDate("createtime"));
                // 對應 Category 物件, 要透過 category_id 來查找
                Category category = categoryDao.getById(rs.getInt("category_id"));
                guestBook.setCategory(category);
                // 將 guestBook 加入到 guestBooks 集合中
                guestBooks.add(guestBook);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return guestBooks;
    }
}
