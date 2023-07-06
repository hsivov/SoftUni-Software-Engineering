package com.softuni.springdataintro.service.impl;

import com.softuni.springdataintro.entity.Author;
import com.softuni.springdataintro.entity.Book;
import com.softuni.springdataintro.repository.AuthorRepository;
import com.softuni.springdataintro.service.AuthorService;
import com.softuni.springdataintro.utils.FileUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.softuni.springdataintro.constant.GlobalConstants.AUTHOR_FILE_PATH;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorRepository.count() != 0) {
            return;
        }

        String[] fileContent = this.fileUtil.readFileContent(AUTHOR_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(r -> {
                    Author author = new Author(r.split("\\s+")[0], r.split("\\s+")[1]);

                    this.authorRepository.saveAndFlush(author);
                });
    }

    @Override
    public int getAllAuthorsCount() {
        return (int) authorRepository.count();
    }

    @Override
    public Author findAuthorById(Long id) {
        return this.authorRepository.getReferenceById(id);
    }

    @Override
    public List<String> getAllAuthorsByTheirBooksCount() {
        return authorRepository
                .findAllByBooksSizeDESC()
                .stream()
                .map(author -> String.format("%s %s %d",
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBooks().size()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAuthorsWithFirstNameEnding(String term) {
        return authorRepository
                .findAuthorsByFirstNameEndingWith(term)
                .stream()
                .map(author ->  String.format("%s %s", author.getFirstName(), author.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllAuthorsAndTheirCopies() {
        return authorRepository.findAll()
                .stream()
                .map(author -> String.format("%s %s - %d",
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBooks()
                                .stream()
                                .map(Book::getCopies)
                                .reduce(Integer::sum)
                                .orElse(0)))
                .collect(Collectors.toList());
    }
}
