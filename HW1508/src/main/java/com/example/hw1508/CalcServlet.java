package com.example.hw1508;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calcServlet", value = "/calc")
public class CalcServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //get the three numbers from the request and the operation from the request and calculate the result

        String operation = request.getParameter("operation");
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int num3 = Integer.parseInt(request.getParameter("num3"));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Num1: "+ num1 +"</h2>");
        out.println("<h2>Num2: "+ num2 +"</h2>");
        out.println("<h2>Num3: "+ num3 +"</h2>");


        switch (operation) {
            case "max":
                out.println("<h1>Max: " + Math.max(Math.max(num1, num2), num3) + "</h1>");
                break;
            case "min":
                out.println("<h1>Min: " + Math.min(Math.min(num1, num2), num3) + "</h1>");
                break;
            case "average":
                out.println("<h1>Average: " + (num1 + num2 + num3) / 3 + "</h1>");
                break;
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }

}
