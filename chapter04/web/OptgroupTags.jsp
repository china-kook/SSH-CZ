<%--
  Created by IntelliJ IDEA.
  User: ikook
  Date: 2018/3/8
  Time: 下午11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>optgroup</title>
</head>
<body>

<s:form action="">
    <s:select label="选择所学内容" name="course"
              list="#{'java web':'java web','数据库':'数据库'}"
              listKey="value" listValue="key">
        <s:optgroup label="Java web"
                    list="#{'jsp':'jsp','servlet':'servlet','javaBean':'javaBean'}"
                    listKey="value" listValue="key"/>
        <s:optgroup label="数据库"
                    list="#{'mysql':'mysql','Oracle':'Oracle','DB2':'DB2'}"
                    listKey="value" listValue="key"/>
    </s:select>
</s:form>

</body>
</html>
