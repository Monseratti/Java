package Classes;

public class Question {
    private int id;
    private String title;
    private String content;
    private int category_id;
    public Question() {
        this.id = 0;
        this.title = "";
        this.content = "";
        this.category_id = 0;
    }
    public Question(int id, String title, String content, int category_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category_id = category_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getCategory_id() {
        return category_id;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
