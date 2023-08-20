package com.example.cw2707;

import java.io.*;
import java.sql.*;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/notebooks")
public class NotebooksQueries extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Connection connection = (Connection) request.getAttribute("dbConnection");

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Notebooks");

//            -- CREATE TABLE Notebooks (
//                    --                                     id SERIAL PRIMARY KEY,
//                    --                                     manufacturer_name VARCHAR(255) NOT NULL,
//            --                                     notebook_name VARCHAR(255) NOT NULL,
//            --                                     number_of_pages INT NOT NULL,
//                    --                                     cover_type VARCHAR(20) NOT NULL,
//            --                                     manufacturing_country VARCHAR(255) NOT NULL,
//            --                                     page_appearance VARCHAR(20) NOT NULL
//            -- );
//            -- Відображення всього вмісту таблиці з блокнотами
//            SELECT * FROM Notebooks;
//
//            -- Показати всі країни виробники
//            SELECT DISTINCT manufacturing_country FROM Notebooks;
//
//            -- Показати назви країн і кількість блокнотів із кожної країни
//            SELECT manufacturing_country, COUNT(*) AS notebook_count
//            FROM Notebooks
//            GROUP BY manufacturing_country;
//
//            -- Показати назву виробника і кількість блокнотів кожного виробника
//            SELECT manufacturer_name, COUNT(*) AS notebook_count
//            FROM Notebooks
//            GROUP BY manufacturer_name;
//
//            -- Показати країну з найбільшою кількістю блокнотів
//            SELECT manufacturing_country, COUNT(*) AS notebook_count
//            FROM Notebooks
//            GROUP BY manufacturing_country
//            ORDER BY notebook_count DESC
//            LIMIT 1;
//
//            -- Показати країну з найменшою кількістю блокнотів
//            SELECT manufacturing_country, COUNT(*) AS notebook_count
//            FROM Notebooks
//            GROUP BY manufacturing_country
//            ORDER BY notebook_count ASC
//            LIMIT 1;
//
//            -- Показати виробника з найбільшою кількістю блокнотів
//            SELECT manufacturer_name, COUNT(*) AS notebook_count
//            FROM Notebooks
//            GROUP BY manufacturer_name
//            ORDER BY notebook_count DESC
//            LIMIT 1;
//
//            -- Показати виробника з найменшою кількістю блокнотів
//            SELECT manufacturer_name, COUNT(*) AS notebook_count
//            FROM Notebooks
//            GROUP BY manufacturer_name
//            ORDER BY notebook_count ASC
//            LIMIT 1;
//
//            -- Показати всі блокноти з твердою обкладинкою
//            SELECT * FROM Notebooks
//            WHERE cover_type = 'тверда';
//
//            -- Показати всі блокноти з м’якою обкладинкою
//            SELECT * FROM Notebooks
//            WHERE cover_type = 'м’яка';
//
//            -- Показати всі блокноти конкретної країни (замініть 'Країна' на конкретну країну)
//            SELECT * FROM Notebooks
//            WHERE manufacturing_country = 'Країна';
//
//            -- Створити фільтр для відображення блокнотів по зовнішньому вигляді сторінки (замініть 'Зовнішній вигляд' на конкретний вигляд)
//            SELECT * FROM Notebooks
//            WHERE page_appearance = 'Зовнішній вигляд';
//
//            -- Створити фільтр по кількості сторінок (замініть 50 та 100 на діапазон кількості сторінок)
//            SELECT * FROM Notebooks
//            WHERE number_of_pages BETWEEN 50 AND 100;

            // Process and display the result
            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt("id");
                String manufacturer = resultSet.getString("manufacturer_name");
                String notebookName = resultSet.getString("notebook_name");
                // ... Other fields

                // Display the data
                out.println("ID: " + id + "<br>");
                out.println("Manufacturer: " + manufacturer + "<br>");
                out.println("Notebook Name: " + notebookName + "<br>");
                // ... Display other fields
                out.println("<br>");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        doGet(request, response);
    }
}
