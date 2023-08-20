package servlets;

import java.io.*;
import java.sql.Connection;
import java.util.*;

import classes.Buyer;
import classes.Product;
import classes.Seller;
import connectors.ConnectDB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/sells")
public class Sells extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        try (Connection con = ConnectDB.Connected()){
            if(con != null){
                out.println("Connected");
                switch (request.getParameter("action")) {
                    case "showAllBuyers":
                        showAllBuyers(request, response,con);
                        break;
                    case "showAllSellers":
                        showAllSellers(request, response,con);
                        break;
                    case "showAllProducts":
                        showAllProducts(request, response,con);
                        break;
                    default:
                        out.println("Invalid Action");
                        break;
                }
            }
            else{
                out.println("Not Connected");
            }
        }
        catch(Exception e){
            out.println(e);
        }
    }

    //generate method to show all buyers from the database, using a query, return a list of buyers
    private void showAllBuyers( HttpServletRequest request, HttpServletResponse response, Connection con)
            throws IOException{
        PrintWriter out = response.getWriter();
        try(Connection conn = con){
            var st = con.createStatement();
            var res =  st.executeQuery("SELECT * FROM buyers");
            //result => to list of buyers and send to the jsp
            List<Buyer> buyerList = new ArrayList<>();
            while (res.next()) {
                var buyer = new Buyer( res.getInt("id"), res.getString("name"),
                        res.getString("email"), res.getString("phone"));
                buyerList.add(buyer);
            }
            request.setAttribute("buyers", buyerList);
            request.getRequestDispatcher("buyers.jsp").forward(request, response);
        }
        catch(Exception e){
            out.println(e);
        }
    }

    //generate method to show all sellers from the database, using a query, return a list of sellers
    private void showAllSellers( HttpServletRequest request, HttpServletResponse response, Connection con)
            throws IOException{
        PrintWriter out = response.getWriter();
        try(Connection conn = con){
            var st = con.createStatement();
            var res =  st.executeQuery("SELECT * FROM sellers");
            //result => to list of sellers and send to the jsp
            List<Seller> sellerList = new ArrayList<>();
            while (res.next()) {
                var seller = new Seller( res.getInt("id"), res.getString("name"),
                        res.getString("email"), res.getString("phone"));
                sellerList.add(seller);
            }
            request.setAttribute("sellers", sellerList);
            request.getRequestDispatcher("sellers.jsp").forward(request, response);
        }
        catch(Exception e){
            out.println(e);
        }
    }

    //generate method to show all products from the database, using a query, return a list of products
    private void showAllProducts( HttpServletRequest request, HttpServletResponse response, Connection con)
            throws IOException{
        PrintWriter out = response.getWriter();
        try(Connection conn = con){
            var st = con.createStatement();
            var res =  st.executeQuery("SELECT * FROM products");
            //result => to list of products and send to the jsp
            List<Product> productList = new ArrayList<>();
            while (res.next()) {
                var product = new Product( res.getInt("id"), res.getString("name"),
                        res.getInt("price"));
                productList.add(product);
            }
            request.setAttribute("products", productList);
            request.getRequestDispatcher("products.jsp").forward(request, response);
        }
        catch(Exception e){
            out.println(e);
        }
    }

    public void destroy() {
    }
}