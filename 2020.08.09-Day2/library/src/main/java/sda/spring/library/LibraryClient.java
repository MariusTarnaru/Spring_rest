package sda.spring.library;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sda.spring.library.config.LibraryConfig;
import sda.spring.library.model.Author;
import sda.spring.library.model.Book;
import sda.spring.library.model.Genre;

import java.util.List;

public class LibraryClient {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(LibraryConfig.class);

        LibraryApplication libraryApplication =
                context.getBean(LibraryApplication.class);

        List<Book> books = libraryApplication.getAllBooks();

        for (Book book : books) {
            System.out.println(book.toString());
        }
        System.out.println("-".repeat(100));
        // "-".repeat(100) returns a String of `-` repeated 100 times. So it's a long line

        Book newBook = new Book("13RAF3234", new Author("Titu Maiorescu"),
                Genre.HORROR, "Hunger Games");
        libraryApplication.save(newBook);
        books = libraryApplication.getAllBooks(); // should include the new book
        for (Book book : books) {
            System.out.println(book.toString());
        }
        //testing getBookByISBN method
        System.out.println("\n" + libraryApplication.getBookByISBN("13RAF3234").toString());
    }

}
