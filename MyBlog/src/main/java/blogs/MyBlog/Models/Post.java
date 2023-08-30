package blogs.MyBlog.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDate;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;


    private String title;
    private String shortDescription;
    private String content;
    private LocalDate date = LocalDate.now();
    private int commentAmount = 0;
    public Post() {
    }
    public Post(String title, String shortDescription, String content) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.content = content;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public int getCommentAmount() {
        return commentAmount;
    }
    public void setCommentAmount(int commentAmount) {
        this.commentAmount = commentAmount;
    }
}
