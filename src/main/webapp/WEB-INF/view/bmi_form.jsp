<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>BMI Form</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="/YIDWebDemo/css/pure-min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style="padding: 20px">
        
        <form class="pure-form" method="post" action="/YIDWebDemo/servlet/bmi">
            <fieldset>
                <legend>計算 BMI</legend>
                    姓名：<input type="text" id="myname" name="myname" value="${ myname }" /><p>
                    身高：<input type="number" id="myheight" name="myheight" value="${ myheight }" /><p>
                    體重：<input type="number" id="myweight" name="myweight" value="${ myweight }" /><p>
                <button type="reset" class="pure-button pure-button-primary">清除</button>
                <button type="submit" class="pure-button pure-button-primary">傳送</button>
            </fieldset>
        </form>
        BMI：${ bmi }
    </body>
</html>
