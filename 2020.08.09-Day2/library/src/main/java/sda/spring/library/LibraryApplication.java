package sda.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sda.spring.library.model.Book;
import sda.spring.library.service.BookService;

import java.util.List;

@Component
public class LibraryApplication {

    private BookService bookService;

    @Autowired
    public LibraryApplication(BookService bookService) {
        this.bookService = bookService;
    }

    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    public void save(Book newBook) {
        bookService.save(newBook);
    }
}
