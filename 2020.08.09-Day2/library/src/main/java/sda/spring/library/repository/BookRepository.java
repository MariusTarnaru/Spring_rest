package sda.spring.library.repository;

import org.springframework.stereotype.Repository;
import sda.spring.library.model.Author;
import sda.spring.library.model.Book;
import sda.spring.library.model.Genre;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();
        books.add(new Book()
                .setTitle("Harry Potter the boy who lived!")
                .setISNB("81JH2D")
                .setGenre(Genre.HORROR)
                .setAuthor(new Author("Bogdanel")));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void save(Book newBook) {
        books.add(newBook);
    }
}
