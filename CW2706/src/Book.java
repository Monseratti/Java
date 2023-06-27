import java.util.Date;

public class Book {
    String title;
    String authorName;
    String authorSurname;
    Date published;
    String publisherName;
    String genre;
    int pages;

    public Book(String title, String authorName, String authorSurname, Date published,
                String publisherName, String genre, int pages) {
        this.title = title;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.published = published;
        this.publisherName = publisherName;
        this.genre = genre;
        this.pages = pages;
    }
    @Override
    public String toString() {
        return "Book title is '" + title + '\'' +
                ", author '" + authorName + " " + authorSurname + '\'' +
                ", published at " + published +
                ", publisherName is '" + publisherName + '\'' +
                ", genre is '" + genre + '\'' +
                ", " + pages +" pages";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
