package com.softuni.springdataintro.service.impl;

import com.softuni.springdataintro.entity.*;
import com.softuni.springdataintro.repository.BookRepository;
import com.softuni.springdataintro.service.AuthorService;
import com.softuni.springdataintro.service.BookService;
import com.softuni.springdataintro.service.CategoryService;
import com.softuni.springdataintro.utils.FileUtil;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static com.softuni.springdataintro.constant.GlobalConstants.BOOKS_FILE_PATH;

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

    @Override
    public List<Book> getBookTitlesByAgeRestriction(AgeRestriction ageRestriction) {
        return bookRepository.findBookByAgeRestriction(ageRestriction);
    }

    @Override
    public List<String> getGoldenBooksTitlesWithCopiesLessThan5000() {
        return bookRepository
                .findBooksByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getBooksByPriceLowerThan5AndHigherThan40() {
        return bookRepository.findBooksByPriceLessThanOrPriceGreaterThan(
                BigDecimal.valueOf(5),
                BigDecimal.valueOf(40)
        )
                .stream()
                .map(book -> String.format("%s - $%.2f", book.getTitle(), book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksReleasedNotInYear(int year) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate startDate = LocalDate.parse("01/01/" + year, formatter);
        LocalDate endDate = LocalDate.parse("31/12/" + year, formatter);

        return bookRepository.findBooksByReleaseDateBeforeOrReleaseDateAfter(startDate, endDate);
    }

    @Override
    public List<Book> getAllBooksReleasedBeforeDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate releaseDate = LocalDate.parse(date, formatter);

        return bookRepository.findAllByReleaseDateBefore(releaseDate);
    }

    @Override
    public List<String> getBookTitlesContainingGivenString(String term) {
        return bookRepository
                .findBooksByTitleContainingIgnoreCase(term)
                .stream()
                .map(book -> String.format("%s", book.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBookTitlesByAuthorLastNameStartsWith(String startStr) {
        return bookRepository
                .findAllByAuthor_LastNameStartsWith(startStr)
                .stream()
                .map(book -> String.format("%s (%s %s)",
                        book.getTitle(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public int findCountOfBooksWithTitleLongerThan(int titleLength) {
        return bookRepository.countOfBooksWithTitleLengthLongerThan(titleLength);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.findBookByTitle(title);
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
