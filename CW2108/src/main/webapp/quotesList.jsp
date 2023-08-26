<%@ page import="beans.QuoteBean" %>
<%@ page import="beans.CategoryBean" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: MyTest
  Date: 26.08.2023
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of quotes</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          crossorigin="anonymous">
<%--    import jquery--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/quote-servlet" method="post">
    @csrf
    <label> Categories:
        <input type="hidden" name="action" value="INSERT"/>
        <select class="form-input" name="category">
            <% for (CategoryBean item : (List<CategoryBean>) request.getAttribute("categories")) { %>
            <option value="<%=item.getId()%>"><%=item.getCategory()%></option>
            <%}%>
        </select>
    </label>
    <label> Author:
        <input class="form-input" name="author" placeholder="Author"/>
    </label>
    <label> Quote:
        <input class="form-input" name="quote" placeholder="Quote"/>
    </label>
    <button type="submit" class="btn btn-success">Add</button>
</form>
<%--generate table of quotes from model--%>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Quote</th>
        <th scope="col">Author</th>
        <th scope="col">Category</th>
        <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <% for (QuoteBean quote : (List<QuoteBean>) request.getAttribute("quotes")) { %>
    <tr>
        <td><%=quote.getQuote()%></td>
        <td><%=quote.getAuthor()%></td>
        <td><%=quote.getCategory()%></td>
        <td>
            <form action="${pageContext.request.contextPath}/quote-servlet" method="post">
                <input type="hidden" name="action" value="EDIT"/>
                <input type="hidden" name="id" value="<%=quote.getId()%>"/>
                <button type="submit" class="btn btn-primary">Edit</button>
            </form>
            <form action="${pageContext.request.contextPath}/quote-servlet" method="post">
                <input type="hidden" name="action" value="DELETE"/>
                <input type="hidden" name="id" value="<%=quote.getId()%>"/>
                <button type="submit" class="btn btn-danger">Delete</button>
            </form>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>