<%--
  Created by IntelliJ IDEA.
  User: MyTest
  Date: 20.08.2023
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Multiply table</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">Home</a>
<% int num = Integer.parseInt(request.getParameter("number")); %>
    <h1>Table of <%=num%></h1>
    <table>
        <%for(int i =1; i<10; i++)
        {%>
        <tr>
            <td><%=num%></td>
            <td>*</td>
            <td><%=i%></td>
            <td>=</td>
            <td><%=num*i%></td>
        </tr>
        <%}%>
    </table>
</body>
</html>
