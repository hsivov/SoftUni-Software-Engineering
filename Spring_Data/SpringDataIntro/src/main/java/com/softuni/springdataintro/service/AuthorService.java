package com.softuni.springdataintro.service;

import com.softuni.springdataintro.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    int getAllAuthorsCount();

    Author findAuthorById(Long id);

    List<String> getAllAuthorsByTheirBooksCount();

    List<String> getAuthorsWithFirstNameEnding(String term);

    List<String> getAllAuthorsAndTheirCopies();
}
