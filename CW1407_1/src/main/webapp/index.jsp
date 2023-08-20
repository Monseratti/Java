<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <%--connect bootstrap from cdn--%>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
          integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
          integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
          crossorigin="anonymous"></script>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<h1>Menu</h1>
<ul>
  <li>
    <a class="btn btn-outline-primary"
         href="${pageContext.request.contextPath}/sells?action=showAllBuyers">Show all buyers</a>
  </li>
  <li>
    <a class="btn btn-outline-primary"
       href="${pageContext.request.contextPath}/sells?action=showAllSellers">Show all sellers</a>
  </li>
  <li>
    <a class="btn btn-outline-primary"
       href="${pageContext.request.contextPath}/sells?action=showAllProducts">Show all products</a>
  </li>
</ul>
</body>
</html>