package classes;

import java.util.Calendar;

public class Order {
    //generate attributes, constructor, getters and setters
    private int id;
    private  int idSeller;
    private int idBuyer;
    private int idProduct;
    private int quantity;
    private Calendar orderDate;

    public Order(int id, int idSeller, int idBuyer, int idProduct, int quantity){
        this(id, idSeller, idBuyer, idProduct, quantity, Calendar.getInstance());
    }
    public Order(int id, int idSeller, int idBuyer, int idProduct, int quantity, Calendar orderDate){
        this.id = id;
        this.idSeller = idSeller;
        this.idBuyer = idBuyer;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
    }

    public int getIdBuyer() {
        return idBuyer;
    }

    public void setIdBuyer(int idBuyer) {
        this.idBuyer = idBuyer;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Calendar getOrderDate() { return orderDate;   }

    public void setOrderDate(Calendar orderDate) {  this.orderDate = orderDate;   }
}
