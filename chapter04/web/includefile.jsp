<%--
  Created by IntelliJ IDEA.
  User: ikook
  Date: 2018/3/8
  Time: 下午10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>include</title>
</head>
<body>

<h4>这是被包含页面 includefile.jsp </h4><br>
传递的用户为：<% out.print(request.getParameter("user"));%>

</body>
</html>
