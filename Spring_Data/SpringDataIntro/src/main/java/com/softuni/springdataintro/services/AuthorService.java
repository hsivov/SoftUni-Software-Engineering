package com.softuni.springdataintro.services;

import com.softuni.springdataintro.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    int getAllAuthorsCount();

    Author findAuthorById(Long id);

    List<String> getAllAuthorsByTheirBooksCount();
}
