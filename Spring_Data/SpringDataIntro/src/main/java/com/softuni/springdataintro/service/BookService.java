package com.softuni.springdataintro.service;

import com.softuni.springdataintro.entity.AgeRestriction;
import com.softuni.springdataintro.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> getAllBooksAfterYear(int year);

    List<String> getAllAuthorsWithBookReleasedBeforeYear(int year);

    List<String> getAllBooksByAuthorFirstAndLastNameOrderedByReleaseDateDESCThenByTitle(String firstName, String lastName);


    List<Book> getBookTitlesByAgeRestriction(AgeRestriction ageRestriction);

    List<String> getGoldenBooksTitlesWithCopiesLessThan5000();

    List<String> getBooksByPriceLowerThan5AndHigherThan40();

    List<Book> getBooksReleasedNotInYear(int year);

    List<Book> getAllBooksReleasedBeforeDate(String date);

    List<String> getBookTitlesContainingGivenString(String term);

    List<String> getAllBookTitlesByAuthorLastNameStartsWith(String startStr);

    int findCountOfBooksWithTitleLongerThan(int titleLength);

    Book getBookByTitle(String title);
}
