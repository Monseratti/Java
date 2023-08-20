package classes;

public class Seller {
    // Attributes of the class as connection to the database
    private int id;
    private String name;
    private String email;
    private String phone;

    // Constructor
    public Seller(){
        this(0, "", "", ""  );
    }
    public Seller(int id, String name, String email, String phone){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
