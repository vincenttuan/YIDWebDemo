package com.yid.controller.guestbook;

import com.yid.repository.guestbook.entity.Category;
import com.yid.repository.guestbook.entity.GuestBook;
import com.yid.service.guestbook.GuestBookService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// mode: add(新增模式)
// mode: update(修改模式)
// mode: delete(刪除模式)
@WebServlet("/guestbook")
public class GuestBookController extends HttpServlet {
    
    private final GuestBookService service = new GuestBookService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        
        // 建立 GuestBook 物件
        GuestBook guestBook = new GuestBook();
        // 要接收是否有 mode ?
        String mode  = "add";
        if(req.getParameter("mode") != null) { // 給 update, delete 按下超連結時
            mode = req.getParameter("mode");
            Integer id = Integer.valueOf(req.getParameter("id"));
            guestBook = service.getGuestBookById(id);
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/guestbook/index.jsp");
        req.setAttribute("guestbooks", service.queryGuestBooks());
        req.setAttribute("categories", service.queryCategories());
        req.setAttribute("mode", mode);
        req.setAttribute("guestBook", guestBook);
        rd.forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        
        String id = req.getParameter("id");
        String mode = req.getParameter("mode");
        Integer categoryId = Integer.valueOf(req.getParameter("categoryId"));
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String message  = req.getParameter("message");
        Category category = service.getCategoryById(categoryId);
        
        // 組裝 GuestBook 物件
        GuestBook guestBook = new GuestBook();
        guestBook.setCategory(category);
        guestBook.setEmail(email);
        guestBook.setMessage(message);
        guestBook.setUsername(username);
        if(id != null && id.trim().length() > 0) {
            guestBook.setId(Integer.valueOf(id));
        }
        
        // 分析 mode
        boolean result = false;
        
        switch (mode) {
            case "add":
                result = service.addGuestBook(guestBook);
                break;
            case "update":
                result = service.updateGuestBook(guestBook);
                break;
            case "delete":
                result = service.deleteGuestBook(guestBook.getId());
                break;    
        }
        
        System.out.println(guestBook);
        
        // 重導網頁(一律會使用 HTTP Get 方法)
        resp.sendRedirect("/YIDWebDemo/guestbook");
    }
    
    
    
}
