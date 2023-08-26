<%--
  Created by IntelliJ IDEA.
  User: MyTest
  Date: 26.08.2023
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Random quote</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          crossorigin="anonymous">
</head>
<body>
<% //get quote from the model
    String quote = (String) request.getAttribute("quote");
    //get author from the model
    String author = (String) request.getAttribute("author");
%>
<a class="btn btn-outline-secondary" href="${pageContext.request.contextPath}/">Back</a>
<h1>Random Quote</h1>
<blockquote>
    <q><i><%=quote%></i>></q>
    <p><%=author%></p>
</blockquote>
</body>
</html>
