package quiz.cw2208;

import Classes.ConnectDB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.sql.Connection;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
    //generate doGet method
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try (Connection conn = ConnectDB.Connected()) {
            if (conn != null) {
                String action = "";
                try {
                    action = request.getParameter("action");
                    switch (action) {
                        case "add":
                            addCategory(request, response, conn);
                            break;
                        case "edit":
                            editCategory(request, response, conn);
                            break;
                        case "delete":
                            deleteCategory(request, response, conn);
                            break;
                        default:
                            getCategory(request, response, conn);
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getCategory(HttpServletRequest request, HttpServletResponse response, Connection conn) {
        //generate postgresSQL query to get all categories from DB table "categories"
        String query = "SELECT * FROM category;";
        try {
            //execute query
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(query);
            //send the query result to the jsp page
            request.setAttribute("categories", rs);
            request.getRequestDispatcher("quizAdminPage.jsp").forward(request, response);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response, Connection conn) {
        //generate postgresSQL query to delete a category from DB table "categories"
        String query = "DELETE FROM category WHERE id = " + request.getParameter("id") + ";";
        try {
            //execute query
            var stmt = conn.createStatement();
            stmt.executeUpdate(query);
            //send the query result to the jsp page
            response.sendRedirect("quizAdminPage.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void editCategory(HttpServletRequest request, HttpServletResponse response, Connection conn) {
        //generate postgresSQL query to edit a category in DB table "categories"
        String query = "UPDATE category SET title = '" + request.getParameter("category") + "' WHERE id = "
                + request.getParameter("id") + ";";
        try {
            //execute query
            var stmt = conn.createStatement();
            stmt.executeUpdate(query);
            //send the query result to the jsp page
            response.sendRedirect("quizAdminPage.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void addCategory(HttpServletRequest request, HttpServletResponse response, Connection conn) {
        //generate postgresSQL query to add a new category to DB table "categories"
        String query = "INSERT INTO category (title) VALUES ('" + request.getParameter("category") + "');";
        try {
            //execute query
            var stmt = conn.createStatement();
            stmt.executeUpdate(query);
            //send the query result to the jsp page
            response.sendRedirect("quizAdminPage.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //generate doPost method
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }

}
