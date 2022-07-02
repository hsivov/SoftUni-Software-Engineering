package ObjectsAndClasses.exercise.Article2;

public class Article2 {
    private String title;
    private String content;
    private String author;

    Article2(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        //"{title} - {content}:{author}"
        return title + " - " + content + ": " + author;
    }
}

