<%--
  Created by IntelliJ IDEA.
  User: ikook
  Date: 2018/3/8
  Time: 下午9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>控制标签的使用</title>
</head>
<body>

    <center>

        <table border="10px" cellpadding="10" cellspacing="10">
            <s:iterator var="name" value="{'Java','Java Web', 'Oracle', 'Mysql'}" status="st">

                <s:if test="#st.odd">
                    <tr style="background-color: white;">
                        <td><s:property value="name"/> </td>
                    </tr>
                </s:if>
                <s:else>
                    <tr style="background-color: gray;">
                        <td><s:property value="name"/> </td>
                    </tr>
                </s:else>

                <%--<s:if test="#st.even">--%>
                    <%--<tr style="background-color: gray;">--%>
                        <%--<td><s:property value="name"/> </td>--%>
                    <%--</tr>--%>
                <%--</s:if>--%>

            </s:iterator>


        </table>

    </center>

</body>
</html>
