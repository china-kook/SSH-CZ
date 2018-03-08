<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>查看valueStack信息</title>
</head>
<body>

<s:debug/>
商品名称：
<s:property value="model.name"/>
</br> 商品价格：
<s:property value="model.price"/>
</br>

以下是使用EL表达式访问值栈中的数据：</br>
商品名称：${model.name}
</br>
商品价格：${model.price}

</body>
</html>