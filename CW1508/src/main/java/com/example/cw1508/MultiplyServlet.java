package com.example.cw1508;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/multiply-servlet")
public class MultiplyServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            var out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1> Multiply Servlet </h1>");
            out.println("<form action='multiply-servlet' method='post'>");
            out.println("<input type='number' name='number' placeholder='Enter number'>");
            out.println("<input type='submit' value='Show multiply table'>");
            out.println("</form>");
            out.println("</body></html>");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            var num1 = Integer.parseInt(request.getParameter("number"));
            request.setAttribute("number", num1);
            request.getRequestDispatcher("multiplytable.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
