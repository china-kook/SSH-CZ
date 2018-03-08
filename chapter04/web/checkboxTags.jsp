<%--
  Created by IntelliJ IDEA.
  User: ikook
  Date: 2018/3/8
  Time: 下午10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>checkboxTags</title>
</head>
<body>

<s:form action="">
    <s:checkbox label="普通用户" name="role_user" value="true" fieldValue="role_user"/>
    <s:checkbox label="管理员" name="role_admin" fieldValue="role_admin"/>
</s:form>

</body>
</html>
