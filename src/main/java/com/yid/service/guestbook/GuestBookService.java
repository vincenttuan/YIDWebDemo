package com.yid.service.guestbook;

import com.yid.repository.guestbook.dao.CategoryDao;
import com.yid.repository.guestbook.dao.GuestBookDao;
import com.yid.repository.guestbook.entity.Category;
import com.yid.repository.guestbook.entity.GuestBook;
import java.util.List;

public class GuestBookService {
    
    private final GuestBookDao guestBookDao = new GuestBookDao();
    private final CategoryDao categoryDao = new CategoryDao();
    
    // 新增 GuestBook
    public boolean addGuestBook(GuestBook guestBook) {
        // 檢查動作...
        // 略... 
        return guestBookDao.add(guestBook) == 1;
    }
    
    // 修改 GuestBook
    public boolean updateGuestBook(GuestBook guestBook) {
        return guestBookDao.update(guestBook) == 1;
    }
    
    // 刪除 GuestBook
    public boolean deleteGuestBook(Integer id) {
        return guestBookDao.deleteById(id) == 1;
    }
    
    // 查詢 GuestBook
    public GuestBook getGuestBookById(Integer id) {
        return guestBookDao.getById(id);
    }
    
    public List<GuestBook> queryGuestBooks() {
        return guestBookDao.queryAll();
    }
    
    // 查詢 Category
    public Category getCategoryById(Integer id) {
        return categoryDao.getById(id);
    }
    
    public List<Category> queryCategories() {
        return categoryDao.queryAll();
    }
    
}
