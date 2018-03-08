<%--
  Created by IntelliJ IDEA.
  User: ikook
  Date: 2018/3/8
  Time: 下午11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>首页</title>
</head>
<body>

静态属性值为：
<s:property value="@com.ikook.ognl.TestOgnl02@staticValue"/>
</br> 调用静态方法结果请查看控制台
<s:property value="@com.ikook.ognl.TestOgnl02@testMethod()"/>

</body>
</body>
</html>
