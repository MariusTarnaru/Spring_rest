package sda.spring.library.model;

public class Book {
    private String ISNB;
    private Author author;
    private Genre genre;
    private String title;

    public Book() {
    }

    public Book(String ISNB, Author author, Genre genre, String title) {
        this.ISNB = ISNB;
        this.author = author;
        this.genre = genre;
        this.title = title;
    }

    public String getISNB() {
        return ISNB;
    }

    public Book setISNB(String ISNB) {
        this.ISNB = ISNB;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public Book setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISNB='" + ISNB + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                ", title='" + title + '\'' +
                '}';
    }
}
