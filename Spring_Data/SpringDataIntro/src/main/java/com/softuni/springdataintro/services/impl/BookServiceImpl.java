package com.softuni.springdataintro.services.impl;

import com.softuni.springdataintro.entities.*;
import com.softuni.springdataintro.repositories.BookRepository;
import com.softuni.springdataintro.services.AuthorService;
import com.softuni.springdataintro.services.BookService;
import com.softuni.springdataintro.services.CategoryService;
import com.softuni.springdataintro.utils.FileUtil;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static com.softuni.springdataintro.constants.GlobalConstants.BOOKS_FILE_PATH;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final FileUtil fileUtil;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count() != 0) {
            return;
        }

        String[] fileContent = this.fileUtil.readFileContent(BOOKS_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(r -> {
                    String[] params = r.split("\\s+");

                    Author author = this.getRandomAuthor();

                    EditionType editionType = EditionType.values()[Integer.parseInt(params[0])];

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                    LocalDate releaseDate = LocalDate.parse(params[1], formatter);

                    int copies = Integer.parseInt(params[2]);

                    BigDecimal price = new BigDecimal(params[3]);

                    AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(params[4])];

                    String title = getTitle(params);

                    Set<Category> categories = this.getRandomCategories();

                    Book book = new Book(author, editionType,releaseDate, copies, price, ageRestriction, title, categories);

                    this.bookRepository.saveAndFlush(book);
                });
    }

    @Override
    public List<Book> getAllBooksAfterYear(int year) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate releaseDate = LocalDate.parse("31/12/2000", formatter);

        return this.bookRepository.findAllByReleaseDateAfter(releaseDate);
    }

    @Override
    public List<String> getAllAuthorsWithBookReleasedBeforeYear(int year) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate releaseDate = LocalDate.parse("01/01/1990", formatter);

        return bookRepository.findAllByReleaseDateBefore(releaseDate)
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBooksByAuthorFirstAndLastNameOrderedByReleaseDateDESCThenByTitle(String firstName, String lastName) {
        return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    private Set<Category> getRandomCategories() {
        Set<Category> result = new HashSet<>();
        Random random = new Random();
        int bound = random.nextInt(3) + 1;


        for (int i = 1; i <= bound; i++) {
            int categoryId = random.nextInt(8) + 1;
            result.add(this.categoryService.getCategoryById((long) categoryId));
        }

        return result;
    }

    private String getTitle(String[] params) {
        StringBuilder sb = new StringBuilder();

        for (int i = 5; i < params.length; i++) {
            sb.append(params[i]).append(" ");
        }

        return sb.toString().trim();
    }

    private Author getRandomAuthor() {
        Random random = new Random();

        int randomId = random.nextInt(authorService.getAllAuthorsCount()) + 1;

        return authorService.findAuthorById((long) randomId);
    }
}
