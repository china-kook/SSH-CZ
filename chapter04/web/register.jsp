<%--
  Created by IntelliJ IDEA.
  User: ikook
  Date: 2018/3/8
  Time: 下午10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>注册</title>
</head>
<body>

<s:form action="login">

    <s:textfield label="用户名" name="username"/>

    <s:password label="密  码" name="password1"/>
    <s:password label="确认密码" name="password2"/>

    <s:radio label="性别" list="#{'0':'男','1':'女'}"  name="sex" value="1"/>

    <s:textarea label="个性签名" name="description" rows="5" cols="15"/>

    <s:submit value="提交"/>

</s:form>


</body>
</html>
