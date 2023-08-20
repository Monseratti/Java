<%@ page import="classes.Buyer" %>
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
    <title>Buyers</title>
    <%--connect bootstrap from cdn--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"--%>
<%--            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"--%>
<%--            integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>--%>
</head>
<body>
<%--generate bootstrap table of buyers--%>
<a href="${pageContext.request.contextPath}/">Home</a>
    <div class="container">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
            </tr>
            </thead>
            <tbody>
            <% for (Buyer buyer : (List<Buyer>) request.getAttribute("buyers")) { %>
                <tr>
                    <td><%= buyer.getId() %></td>
                    <td><%= buyer.getName() %></td>
                    <td><%= buyer.getPhone() %></td>
                    <td><%= buyer.getEmail() %></td>
                </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
