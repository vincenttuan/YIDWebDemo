package test;

import com.yid.repository.guestbook.entity.Category;
import com.yid.repository.guestbook.entity.GuestBook;
import com.yid.service.guestbook.GuestBookService;
import java.util.List;

public class GuestBookTest {
    
    public static void main(String[] args) {
        
        // 測試 GuestBookService
        
        GuestBookService service = new GuestBookService();
        
        // 1. 查詢所有 guestBooks
        System.out.println(service.queryGuestBooks());
        
        // 2. 查詢單筆 guestBook
        System.out.println(service.getGuestBookById(1));
        
        // 3. 查詢所有 categories
        System.out.println(service.queryCategories());
        
        // 4. 查詢單筆 category
        System.out.println(service.getCategoryById(1));
        
        // 5. 新增 guestBook
        Category category = service.getCategoryById(4);
        GuestBook guestBook = new GuestBook();
        guestBook.setUsername("Michael");
        guestBook.setEmail("Michael@gmail.com");
        guestBook.setMessage("Hello");
        guestBook.setCategory(category);
        System.out.println(service.addGuestBook(guestBook));
    }
    
    
    
}
