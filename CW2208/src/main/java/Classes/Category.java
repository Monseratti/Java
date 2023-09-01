package Classes;

public class Category {
    private int id;
    private String title;
    public Category() {
        this.id = 0;
        this.title = "";
    }
    public Category(int id, String name, String description) {
        this.id = id;
        this.title = name;
    }
    public int getId() {
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String name) {
        this.title = name;
    }
}
