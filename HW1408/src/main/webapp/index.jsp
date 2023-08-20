<%--
  Created by IntelliJ IDEA.
  User: MyTest
  Date: 20.08.2023
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--create menu using servlet CarsServlet and form actions--%>
<h1>Menu</h1>
<ul>
    <li><a href="${pageContext.request.contextPath}/cars?action=1">Show all cars</a></li>
    <li><a href="${pageContext.request.contextPath}/cars?action=2">Show all manufacturers</a></li>
</ul>
</body>
</html>
