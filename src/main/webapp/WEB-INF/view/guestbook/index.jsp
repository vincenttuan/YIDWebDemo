<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GuestBook Index page</title>
    </head>
    <body style="padding: 20px">
        <h1>GuestBook Index page</h1>
        
        <form class="pure-form" method="post" action="/YIDWebDemo/guestbook">
            <fieldset>
                <legend>GuestBook 表單</legend>
                    <!------------------------------------------------------------------------->  
                    Id(Hidden)：<input type="text" name="id" value="${ guestBook.id }" readonly /><p>
                    Mode(Hidden)：<input type="text" name="mode" value="${ mode }" readonly /><p>  
                    <!------------------------------------------------------------------------->    
                    Category：
                    <select id="categoryId" name="categoryId">
                        <c:forEach var="category" items="${ categories }">
                            <option value="${ category.id }"  
                                ${ (guestBook.category.id eq category.id)?"selected":"" } >
                                ${ category.name }
                            </option>
                        </c:forEach>
                    </select>
                    <p>
                    Username：<input type="text" id="username" name="username" value="${ guestBook.username }" /><p>
                    Email：<input type="text" id="email" name="email" value="${ guestBook.email }" /><p>
                    Message：<input type="text" id="message" name="message" value="${ guestBook.message }" /><p>
                    <!------------------------------------------------------------------------->      
                    <button type="button" 
                            onclick="window.location.href='/YIDWebDemo/guestbook';"
                            class="pure-button pure-button-primary">reset</button>
                    <button type="submit" class="pure-button pure-button-primary">${ mode }</button>
            </fieldset>
        </form>
        
        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>id</th><th>category</th><th>username</th><th>email</th>
                    <th>message</th><th>update time</th><th>create time</th>
                    <th>update</th><th>delete</th>
                </tr>
            </thead>  
            <tbody>
                <c:forEach var="guestbook" items="${ guestbooks }">
                    <tr>
                        <td>${ guestbook.id }</td>
                        <td>${ guestbook.category.name }</td>
                        <td>${ guestbook.username }</td>
                        <td>${ guestbook.email }</td>
                        <td>${ guestbook.message }</td>
                        <td>${ guestbook.updatetime }</td>
                        <td>${ guestbook.createtime }</td>
                        <td>
                            <a href="/YIDWebDemo/guestbook?mode=update&id=${ guestbook.id }">update</a>
                        </td>
                        <td>
                            <a href="/YIDWebDemo/guestbook?mode=delete&id=${ guestbook.id }">delete</a>
                        </td>
                    </tr>    
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
