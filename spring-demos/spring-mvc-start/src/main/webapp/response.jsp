<%--
  Created by IntelliJ IDEA.
  User: 13692
  Date: 2021/10/10
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript"src="http://code.jquery.com/jquery-1.4.1.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                // alert("hello btn");
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"uname":"hehe","age":"30"}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        alert(data);
                        alert(data.uname);
                        
                    }
                })
            })
        })
    </script>

</head>
<body>
<a href="/user/testString">testString</a><br/>
<a href="/user/testVoid">testVoid</a><br/>
<a href="/user/testForwardAndRedirect">testForwardAndRedirect</a><br/>
<button id="btn">发送ajax请求</button><br/>
<a href="/user/testModelAndView">testModelAndView</a><br/>
</body>
</html>
