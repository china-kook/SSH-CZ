<%--
  Created by IntelliJ IDEA.
  User: ikook
  Date: 2018/3/8
  Time: 下午10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>debug 标签</title>
</head>
<body>
<h3>这是包含页面include.jsp</h3><br>
<s:include value="includefile.jsp">
    <%--<s:param name="user" value="'itcast'"/>--%>
    <%--或者--%>
    <s:param name="user">ikook</s:param>
</s:include>
</body>
</html>
