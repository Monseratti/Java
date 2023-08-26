package beans;

public class QuoteBean implements java.io.Serializable{
    private int id;
    private String author;
    private String quote;
    private String category;

    public QuoteBean() {
    }

    public QuoteBean(int id, String author, String quote, String category) {
        this.id = id;
        this.author = author;
        this.quote = quote;
        this.category = category;
    }

    public QuoteBean(String author, String quote, String category) {
        this.author = author;
        this.quote = quote;
        this.category = category;
    }

    public int getId() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getQuote() {
        return this.quote;
    }

    public String getCategory() {
        return this.category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
