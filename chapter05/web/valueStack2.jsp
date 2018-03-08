<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>查看valueStack信息</title>
</head>
<body>
<s:debug/>
商品名称：
<s:property value="product.name"/>
</br> 商品价格：
<s:property value="product.price"/>
</body>
</html>