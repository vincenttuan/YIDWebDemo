package test;

import com.yid.repository.guestbook.entity.Category;
import com.yid.repository.guestbook.entity.GuestBook;
import com.yid.service.guestbook.GuestBookService;
import java.util.List;

public class GuestBookTest2 {
    
    public static void main(String[] args) {
        
        // 測試 GuestBookService
        GuestBookService service = new GuestBookService();
        
        // 測試修改 GuestBook
        GuestBook guestBook = service.getGuestBookById(6);
        System.out.println(guestBook);
        
        guestBook.setUsername("Michael");
        service.updateGuestBook(guestBook);
        
        guestBook = service.getGuestBookById(6);
        System.out.println(guestBook);
        
    }
    
    
    
}
