<%--
  Created by IntelliJ IDEA.
  User: ikook
  Date: 2018/3/8
  Time: 下午11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>复选框组</title>
</head>
<body>

<s:form>

    <s:checkboxlist list="{'足球','篮球','编程'}" labelposition="left" label="爱好" name="interesters"/>

    <s:checkboxlist list="#{'a':'Java','b':'Swift','c':'C#'}" labelposition="left" label="编程语言" name="education"
                    listKey="key" listValue="value"/>

</s:form>

</body>
</html>
