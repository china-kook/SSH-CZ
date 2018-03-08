<%--
  Created by IntelliJ IDEA.
  User: ikook
  Date: 2018/3/8
  Time: 下午10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>property 标签</title>
</head>
<body>

输出字符串：
<s:property value="'www.itcast.cn'"/><br>

忽略 HTML 代码：
<s:property value="'<h3>www.itcast.cn</h3>'" escape="true"/><br>

不忽略 HTML 代码：
<s:property value="'<h3>www.itcast.cn</h3>'" escape="false"/><br>

默认忽略 HTML 代码：
<s:property value="'<h3>www.itcast.cn</h3>'" /><br>

输出默认值：
<s:property value="" default="true"/><br>
</body>
</html>
