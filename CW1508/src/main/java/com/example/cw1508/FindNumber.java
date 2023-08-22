package com.example.cw1508;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.util.*;

@WebServlet("/find-number")
public class FindNumber extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            var out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1> Find Number </h1>");
            out.println("<form action='find-number' method='post'>");
            out.println("<input type='number' name='number' placeholder='Set number'>");
            out.println("<input type='number' name='lastGuess' value = '0' readonly>");
            out.println("<input type='submit' value='Start'>");
            out.println("</form>");
            out.println("</body></html>");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            var random = new Random();
            var out = response.getWriter();
            var num1 = Integer.parseInt(request.getParameter("number"));
            var num2 = Integer.parseInt(request.getParameter("lastGuess"));

            try {
                switch (request.getParameter("action")) {
                    case "higher":
                        num2 = random.nextInt(101) - (num2 + 1);
                        break;
                    case "lower":
                        num2 = random.nextInt(num2);
                        break;
                    case "correct":
                        break;
                    default:
                        num2 = random.nextInt(101);
                        break;
                }
            } catch (Exception e) {
                num2 = random.nextInt(101);
            }
            out.println("<html><body>");
            out.println("<h1> Find Number </h1>");
            out.println("<form action='find-number' method='post'>");
            out.println("<input type='number' name='number' value='" + num1 + "'>");
            out.println("<input type='number' name='lastGuess' value = '" + num2 + "'>");
            out.println("<label><input type='radio' name='action' value = 'higher'>Higher</label>");
            out.println("<label><input type='radio' name='action' value = 'lower'>Lower</label>");
            out.println("<label><input type='radio' name='action' value = 'correct'>Correct</label>");
            out.println("<input type='submit' value='Apply'>");
            out.println("</form>");
            out.println("</body></html>");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
