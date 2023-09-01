<%@ page import="java.util.ArrayList" %>
<%@ page import="Classes.Category" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page quiz</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div>
    <a href="/category?action=add" class="btn btn-success">Add new category</a>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Category</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
            <% for (Category category : (ArrayList<Category>) request.getAttribute("categories")) { %>
            <tr>
                <td><%= category.getId() %></td>
                <td><%= category.getTitle() %></td>
                <td>
                    <a href="/category?action=edit&id=<%= category.getId() %>" class="btn btn-warning">Edit</a>
                    <a href="/category?action=delete&id=<%= category.getId() %>" class="btn btn-danger">Delete</a>
                </td>
            </tr>
            <%}%>
        </tbody>
    </table>
</div>

<div>
    <a href="/quiz?action=add" class="btn btn-success">Add new quiz</a>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Question</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
</body>
</html>
