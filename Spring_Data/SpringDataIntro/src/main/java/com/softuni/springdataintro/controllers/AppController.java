package com.softuni.springdataintro.controllers;

import com.softuni.springdataintro.entities.Book;
import com.softuni.springdataintro.services.AuthorService;
import com.softuni.springdataintro.services.BookService;
import com.softuni.springdataintro.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Controller
public class AppController implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    @Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws IOException {
        // seed data
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();

        System.out.println("Enter exercise number (1-4): ");
        int exNum = Integer.parseInt(bufferedReader.readLine());

        switch (exNum) {
            case 1 -> printAllBooksAfterYear();
            case 2 -> printAllAuthorsWithBookReleasedBeforeYear();
            case 3 -> printAllAuthorsOrderedByBooksCount();
            case 4 -> printAllBooksByNameOrderedByReleaseDateDESCThenByTitle("George", "Powell");
        }
    }

    private void printAllBooksAfterYear() {
        List<Book> books = this.bookService.getAllBooksAfterYear(2000);

        books.stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void printAllAuthorsWithBookReleasedBeforeYear() {
        bookService
                .getAllAuthorsWithBookReleasedBeforeYear(1990)
                .forEach(System.out::println);
    }

    private void printAllAuthorsOrderedByBooksCount() {
        authorService
                .getAllAuthorsByTheirBooksCount()
                .forEach(System.out::println);
    }

    private void printAllBooksByNameOrderedByReleaseDateDESCThenByTitle(String firstName, String lastName) {
        bookService
                .getAllBooksByAuthorFirstAndLastNameOrderedByReleaseDateDESCThenByTitle(firstName, lastName)
                .forEach(System.out::println);
    }
}
