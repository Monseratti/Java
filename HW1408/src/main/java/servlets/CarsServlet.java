package servlets;

// use Jakarta EE API to work with servlets

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

//create servlet class CarsServlet use static class servlets.ConnectDB to connect to database
//use switch in doGet method to choose what to do
//use try-catch to catch exceptions

@WebServlet("/cars")
public class CarsServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            Connection connection = ConnectDB.Connected();
            if (connection != null) {
                out.println("<h1>Connected to database</h1>");

                switch (parseInt(req.getParameter("action"))) {
                    case 1:
                        getAllCars(req, res, connection);
                        break;
                    case 2:
                        getAllManufacturers(req, res, connection);
                        break;
                    case 3:
                        getCountCar(req, res, connection);
                        break;
                    default:
                        out.println("<h1>Wrong action</h1>");
                        break;
                }
            } else {
                out.println("<h1>Not connected to database</h1>");
            }
        } catch (Exception e) {
            out.println(e.getMessage());
            e.printStackTrace(out);
        }
    }

    //get all cars from database
    private void getAllCars(HttpServletRequest req, HttpServletResponse res, Connection connection) throws IOException {
        PrintWriter out = res.getWriter();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cars");
            List<String> cars = new ArrayList<>();
            while (rs.next()) {
                cars.add("ID: " + rs.getString(1) + "; manuf:  " + rs.getString(2) +
                        "; car:  " + rs.getString(3) + "; volume: " + rs.getInt(4));
            }
            req.setAttribute("cars", cars);
            RequestDispatcher rd = req.getRequestDispatcher("allCars.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            out.println("<h1>1 - Exception</h1>");
            out.println(e.getMessage());
        }
    }

    //show all manufacturers from database
    private void getAllManufacturers(HttpServletRequest req, HttpServletResponse res, Connection connection)
            throws IOException {
        PrintWriter out = res.getWriter();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT manufacturer_name FROM Cars");
            List<String> manufacturers = new ArrayList<>();
            while (rs.next()) {
                manufacturers.add(rs.getString(1));
            }
            req.setAttribute("manufacturers", manufacturers);
            RequestDispatcher rd = req.getRequestDispatcher("allManufacturers.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            out.println("<h1>2 - Exception</h1>");
        }
    }

    //show count of cars by all manufacturers
    private void getCountCar(HttpServletRequest req, HttpServletResponse res, Connection connection)
            throws IOException {
        PrintWriter out = res.getWriter();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT manufacturer_name, COUNT(*) FROM Cars " +
                    "GROUP BY manufacturer_name");
            List<String> cars = new ArrayList<>();
            while (rs.next()) {
                cars.add(rs.getString(1) + ", cars: " + rs.getInt(2));
            }
            req.setAttribute("cars", cars);
            RequestDispatcher rd = req.getRequestDispatcher("countCar.jsp");
            rd.forward(req, res);
        } catch (Exception e) {
            out.println("<h1>3 - Exception</h1>");
        }
    }

}