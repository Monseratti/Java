<%@ page import="servlets.Sells" %>
<%@ page import="classes.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: MyTest
  Date: 20.08.2023
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Products</title>
<%--connect bootstrap from cdn--%>
<%--  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"--%>
<%--          integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>--%>
<%--  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"--%>
<%--          integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>--%>
</head>
<body>
<a href="${pageContext.request.contextPath}/">Home</a>
<%--generate bootstrap table of products--%>
    <div class="container">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
            <% for (Product product : (List<Product>) request.getAttribute("products")) { %>
            <tr>
                <td><%= product.getId() %></td>
                <td><%= product.getName() %></td>
                <td><%= product.getPrice() %></td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
