package com.example.hw1508;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "textStaticticServlet", value = "/textStatictic")
public class TextStaticticServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //get the text from the request and calculate the number of vowel letters, consonant letters and other symbols
        //show the result and lists of each type of letters and symbols in the browser
        String text = request.getParameter("text");
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Text: " + text + "</h2>");
        response.getWriter().println("<h2>Vowel letters: " + countVowelLetters(text) + "</h2>");
        //list of vowel letters
        response.getWriter().println("<h2>Vowel letters: ");
        for (int i = 0; i < text.length(); i++) {
            if (isVowelLetter(text.charAt(i))) {
                response.getWriter().println(text.charAt(i) + " ");
            }
        }
        response.getWriter().println("</h2>");
        response.getWriter().println("<h2>Consonant letters: " + countConsonantLetters(text) + "</h2>");
        //list of consonant letters
        response.getWriter().println("<h2>Consonant letters: ");
        for (int i = 0; i < text.length(); i++) {
            if (isConsonantLetter(text.charAt(i))) {
                response.getWriter().println(text.charAt(i) + " ");
            }
        }
        response.getWriter().println("</h2>");
        response.getWriter().println("<h2>Other symbols: " + countOtherSymbols(text) + "</h2>");
        //list of other symbols
        response.getWriter().println("<h2>Other symbols: ");
        for (int i = 0; i < text.length(); i++) {
            if (!isVowelLetter(text.charAt(i)) && !isConsonantLetter(text.charAt(i))) {
                response.getWriter().println(text.charAt(i) + " ");
            }
        }
        response.getWriter().println("</h2>");
        response.getWriter().println("</body></html>");
    }

    public int countVowelLetters(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (isVowelLetter(text.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public int countConsonantLetters(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (isConsonantLetter(text.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public int countOtherSymbols(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (!isVowelLetter(text.charAt(i)) && !isConsonantLetter(text.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean isVowelLetter(char letter) {
        return "aeiouAEIOU".indexOf(letter) != -1;
    }

    public boolean isConsonantLetter(char letter) {
        return "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(letter) != -1;
    }

    public void destroy() {
    }

}
