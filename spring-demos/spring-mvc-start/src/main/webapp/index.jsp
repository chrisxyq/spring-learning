<%--
  Created by IntelliJ IDEA.
  User: 13692
  Date: 2021/10/7
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>入门程序</h3>
    <a href="/hello">入门程序</a>
    <a href="param/testServlet">Servlet原生的api</a>
    <form action="/user/fileupload1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br/>
        <input type="submit" value="上传">
    </form>
</body>
</html>
