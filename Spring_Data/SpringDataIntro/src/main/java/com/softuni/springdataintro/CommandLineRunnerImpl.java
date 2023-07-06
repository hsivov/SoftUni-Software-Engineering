package com.softuni.springdataintro;

import com.softuni.springdataintro.entity.AgeRestriction;
import com.softuni.springdataintro.entity.Author;
import com.softuni.springdataintro.entity.Book;
import com.softuni.springdataintro.service.AuthorService;
import com.softuni.springdataintro.service.BookService;
import com.softuni.springdataintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws IOException {
        // seed data
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();

//        System.out.println("Enter exercise number (1-4): ");
//        int exNum = Integer.parseInt(bufferedReader.readLine());
//
//        switch (exNum) {
//            case 1 -> printAllBooksAfterYear();
//            case 2 -> printAllAuthorsWithBookReleasedBeforeYear();
//            case 3 -> printAllAuthorsOrderedByBooksCount();
//            case 4 -> printAllBooksByNameOrderedByReleaseDateDESCThenByTitle();
//        }
/**
 *      Spring data advanced querying
 */
        System.out.println("Enter exercise number: ");
        int exNum = Integer.parseInt(bufferedReader.readLine());

        switch (exNum) {
            case 1 -> bookTitlesByAgeRestriction();
            case 2 -> goldenBooks();
            case 3 -> booksByPrice();
            case 4 -> booksReleasedNotInGivenYear();
            case 5 -> booksReleasedBeforeDate();
            case 6 -> authorsSearch();
            case 7 -> booksSearch();
            case 8 -> bookTitlesSearch();
            case 9 -> countBooks();
            case 10 -> totalBookCopies();
            case 11 -> reducedBook();
        }

    }

    private void reducedBook() throws IOException {
        System.out.println("Enter book title: ");
        String title = bufferedReader.readLine();
        Book book = bookService.getBookByTitle(title);

        System.out.printf("%s %s %s %.2f%n", book.getTitle(),
                book.getEditionType(), book.getAgeRestriction(), book.getPrice());
    }

    private void totalBookCopies() {
        authorService.getAllAuthorsAndTheirCopies()
                .forEach(System.out::println);
    }

    private void countBooks() throws IOException {
        System.out.println("Enter title length: ");
        int titleLength = Integer.parseInt(bufferedReader.readLine());

        System.out.println(bookService
                .findCountOfBooksWithTitleLongerThan(titleLength));
    }

    private void bookTitlesSearch() throws IOException {
        System.out.println("Enter author last name starting string: ");
        String startStr = bufferedReader.readLine();

        bookService.getAllBookTitlesByAuthorLastNameStartsWith(startStr)
                .forEach(System.out::println);
    }

    private void booksSearch() throws IOException {
        System.out.print("Enter search term: ");
        String term = bufferedReader.readLine();

        List<String> bookTitles = bookService.getBookTitlesContainingGivenString(term);
        bookTitles.forEach(System.out::println);
    }

    private void authorsSearch() throws IOException {
        System.out.print("Enter search term: ");
        String term = bufferedReader.readLine();

        List<String> authorFullNames = authorService.getAuthorsWithFirstNameEnding(term);
        authorFullNames.forEach(System.out::println);
    }

    private void booksReleasedBeforeDate() throws IOException {
        System.out.println("Enter date in format dd-MM-yyyy: ");
        String date = bufferedReader.readLine();

        List<Book> books = bookService.getAllBooksReleasedBeforeDate(date);

        books.forEach(book -> System.out.printf("%s %s %.2f%n",
                book.getTitle(),
                book.getEditionType(),
                book.getPrice()));
    }

    private void booksReleasedNotInGivenYear() throws IOException {
        System.out.println("Enter year: ");
        int year = Integer.parseInt(bufferedReader.readLine());

        List<Book> books = bookService.getBooksReleasedNotInYear(year);
        books.forEach(book -> System.out.println(book.getTitle()));
    }

    private void booksByPrice() {
        bookService.getBooksByPriceLowerThan5AndHigherThan40()
                .forEach(System.out::println);
    }

    private void goldenBooks() {
        bookService.getGoldenBooksTitlesWithCopiesLessThan5000()
                .forEach(System.out::println);
    }

    private void bookTitlesByAgeRestriction() throws IOException {
        System.out.println("Enter age restriction: ");
        AgeRestriction ageRestriction = AgeRestriction.valueOf(bufferedReader.readLine().toUpperCase());

        List<Book> books = bookService.getBookTitlesByAgeRestriction(ageRestriction);
        books.forEach(book -> System.out.println(book.getTitle()));
    }
//
//    private void printAllBooksAfterYear() {
//        List<Book> books = this.bookService.getAllBooksAfterYear(2000);
//
//        books.stream()
//                .map(Book::getTitle)
//                .forEach(System.out::println);
//    }
//
//    private void printAllAuthorsWithBookReleasedBeforeYear() {
//        bookService
//                .getAllAuthorsWithBookReleasedBeforeYear(1990)
//                .forEach(System.out::println);
//    }
//
//    private void printAllAuthorsOrderedByBooksCount() {
//        authorService
//                .getAllAuthorsByTheirBooksCount()
//                .forEach(System.out::println);
//    }
//
//    private void printAllBooksByNameOrderedByReleaseDateDESCThenByTitle() {
//        bookService
//                .getAllBooksByAuthorFirstAndLastNameOrderedByReleaseDateDESCThenByTitle("George", "Powell")
//                .forEach(System.out::println);

}
