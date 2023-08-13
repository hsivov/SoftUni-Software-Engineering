package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BookSeedDto;
import softuni.exam.models.entity.Book;
import softuni.exam.repository.BookRepository;
import softuni.exam.service.BookService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private static final String BOOKS_FILE_PATH = "src/main/resources/files/json/books.json";
    private final BookRepository bookRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository,Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return bookRepository.count() > 0;
    }

    @Override
    public String readBooksFromFile() throws IOException {
        return Files.readString(Path.of(BOOKS_FILE_PATH));
    }

    @Override
    public String importBooks() throws IOException {
        StringBuilder sb = new StringBuilder();

        BookSeedDto[] bookSeedDtos = gson.fromJson(readBooksFromFile(), BookSeedDto[].class);

        Arrays.stream(bookSeedDtos)
                .filter(bookSeedDto -> {
                    boolean isValid = validationUtil.isValid(bookSeedDto);

                    Optional<Book> byTitleName = bookRepository.findFirstByTitle(bookSeedDto.getTitle());
                    if (byTitleName.isPresent()) {
                        isValid = false;
                    }

                    sb
                            .append(isValid ? String.format("Successfully imported book %s - %s",
                                    bookSeedDto.getAuthor(),
                                    bookSeedDto.getTitle())
                                    : "Invalid book")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(bookSeedDto -> modelMapper.map(bookSeedDto, Book.class))
                .forEach(bookRepository::save);

        return sb.toString();
    }
}
