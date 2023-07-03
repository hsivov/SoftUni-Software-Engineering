package com.softuni.springdataintro.services;

import com.softuni.springdataintro.entities.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> getAllBooksAfterYear(int year);

    List<String> getAllAuthorsWithBookReleasedBeforeYear(int year);

    List<String> getAllBooksByAuthorFirstAndLastNameOrderedByReleaseDateDESCThenByTitle(String firstName, String lastName);
}
