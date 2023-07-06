package com.softuni.springdataintro.repository;

import com.softuni.springdataintro.entity.AgeRestriction;
import com.softuni.springdataintro.entity.Book;
import com.softuni.springdataintro.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDate);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDate);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findBookByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findBooksByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findBooksByPriceLessThanOrPriceGreaterThan(BigDecimal lowLimit, BigDecimal highLimit);

    List<Book> findBooksByReleaseDateBeforeOrReleaseDateAfter(LocalDate startDate, LocalDate endDate);

    List<Book> findBooksByTitleContainingIgnoreCase(String term);
    List<Book> findAllByAuthor_LastNameStartsWith(String author_lastName);

    @Query("SELECT count(b) FROM Book b WHERE length(b.title) > :param ")
    int countOfBooksWithTitleLengthLongerThan(@Param(value = "param") int titleLength);

    Book findBookByTitle(String title);
}
