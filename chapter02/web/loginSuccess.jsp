<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>用户登录成功页面</title>
</head>
<body>
<p align="center">
    登录成功！
    您的用户名是<%=request.getAttribute("user.username")%>
</p>
</body>
</html>

