package beans;

public class CategoryBean implements java.io.Serializable {
    private int id;
    private String category;

    public CategoryBean() {
    }

    public CategoryBean(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public CategoryBean(String category) {
        this.category = category;
    }

    public int getId() {
        return this.id;
    }

    public String getCategory() {
        return this.category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
