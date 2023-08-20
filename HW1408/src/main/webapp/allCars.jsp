<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: MyTest
  Date: 20.08.2023
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>All car</title>
</head>
<body>
<%--use attribute "cars" as list of string, show all elements as UL--%>
<ul>
    <% for (String car : (List<String>) request.getAttribute("cars")) { %>
    <li><%= car %></li>
    <% } %>
</body>
</html>
