<%--
  Created by IntelliJ IDEA.
  User: 13692
  Date: 2021/10/7
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/anno/testRequestParam?name=username">RequestParam</a><br/>
<a href="/anno/testPathVariable/1">PathVariable</a><br/>
<form action="/anno/testRequestBody" method="post">
    姓名：<input type="text" name="username"/><br/>
    生日：<input type="text" name="birth"/><br/>
    <input type="submit" value="提交"/>
</form>
<a href="/anno/testSessionAttributes">putSessionAttributes</a><br/>
<a href="/anno/getSessionAttributes">getSessionAttributes</a><br/>
<a href="/anno/delSessionAttributes">delSessionAttributes</a><br/>
</body>
</html>
