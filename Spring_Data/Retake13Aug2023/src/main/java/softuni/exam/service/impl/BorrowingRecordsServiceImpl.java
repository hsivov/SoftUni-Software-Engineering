package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BorrowingRecordSeedRootDto;
import softuni.exam.models.entity.Book;
import softuni.exam.models.entity.BorrowingRecord;
import softuni.exam.models.entity.Genre;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.BookRepository;
import softuni.exam.repository.BorrowingRecordRepository;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.BorrowingRecordsService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;

@Service
public class BorrowingRecordsServiceImpl implements BorrowingRecordsService {

    private static final String BORROWING_RECORDS_FILE_PATH = "src/main/resources/files/xml/borrowing-records.xml";
    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookRepository bookRepository;
    private final LibraryMemberRepository libraryMemberRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public BorrowingRecordsServiceImpl(BorrowingRecordRepository borrowingRecordRepository, BookRepository bookRepository, LibraryMemberRepository libraryMemberRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.bookRepository = bookRepository;
        this.libraryMemberRepository = libraryMemberRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return borrowingRecordRepository.count() > 0;
    }

    @Override
    public String readBorrowingRecordsFromFile() throws IOException {
        return Files.readString(Path.of(BORROWING_RECORDS_FILE_PATH));
    }

    @Override
    public String importBorrowingRecords() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(BORROWING_RECORDS_FILE_PATH, BorrowingRecordSeedRootDto.class)
                .getBorrowingRecords()
                .stream()
                .filter(borrowingRecordSeedDto -> {
                    boolean isValid = validationUtil.isValid(borrowingRecordSeedDto);

                    Optional<Book> byTitleName = bookRepository.findFirstByTitle(borrowingRecordSeedDto.getBook().getTitle());
                    Optional<LibraryMember> byMemberId = libraryMemberRepository.findFirstById(borrowingRecordSeedDto.getMember().getId());

                    if (byTitleName.isEmpty() || byMemberId.isEmpty()) {
                        isValid = false;
                    }

                    sb
                            .append(isValid ? String.format("Successfully imported borrowing record %s - %s",
                                    borrowingRecordSeedDto.getBook().getTitle(),
                                    borrowingRecordSeedDto.getBorrowDate())
                                    : "Invalid borrowing record")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(borrowingRecordSeedDto -> {
                    BorrowingRecord borrowingRecord = modelMapper.map(borrowingRecordSeedDto, BorrowingRecord.class);

                    Optional<Book> bookByTitle = bookRepository.findFirstByTitle(borrowingRecordSeedDto.getBook().getTitle());
                    Optional<LibraryMember> memberById = libraryMemberRepository.findFirstById(borrowingRecordSeedDto.getMember().getId());

                    borrowingRecord.setBook(bookByTitle.get());
                    borrowingRecord.setLibraryMember(memberById.get());

                    return borrowingRecord;
                })
                .forEach(borrowingRecordRepository::save);

        return sb.toString();
    }

    @Override
    public String exportBorrowingRecords() {
        StringBuilder sb = new StringBuilder();

        Set<BorrowingRecord> records = borrowingRecordRepository.findAllByBook_GenreOrderByBorrowDateDesc(Genre.SCIENCE_FICTION);

        records.forEach(record -> {
            sb
                    .append(String.format("Book title: %s\n" +
                            "*Book author: %s\n" +
                            "**Date borrowed: %s\n" +
                            "***Borrowed by: %s %s\n",
                            record.getBook().getTitle(),
                            record.getBook().getAuthor(),
                            record.getBorrowDate(),
                            record.getLibraryMember().getFirstName(),
                            record.getLibraryMember().getLastName()));
        });

        return sb.toString();
    }
}
