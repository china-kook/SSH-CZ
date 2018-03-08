<%--
  Created by IntelliJ IDEA.
  User: ikook
  Date: 2018/3/8
  Time: 下午11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>errorTags</title>
</head>
<body>

<s:actionerror/>
<s:actionmessage/>
<s:fielderror value="msg"/><!--有无value效果一样 -->

</body>
</html>
