<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cars Page</title>
    </head>
    <body style="padding: 20px">
        
        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>車號</th><th>目前位置</th><th>AGV訊號狀況</th><th>電池電量</th>
                    <th>運行狀態</th><th>錯誤/功能碼</th>
                </tr>
            </thead>  
            <tbody>
                <c:forEach var="carArray" items="${ carList }">
                    <tr>
                        <c:forEach var="car" items="${ carArray }">
                            <td>${car}</td>
                        </c:forEach>
                    </tr>    
                </c:forEach>
            </tbody>
        </table>
        
    </body>
</html>
