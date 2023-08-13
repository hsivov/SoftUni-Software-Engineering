package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.BorrowingRecordsService;
import softuni.exam.service.BookService;
import softuni.exam.service.LibraryMemberService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
@RequestMapping("/import")
public class ImportController extends BaseController {

    private final LibraryMemberService libraryMemberService;
    private final BorrowingRecordsService borrowingRecordsService;
    private final BookService bookService;

    @Autowired
    public ImportController(LibraryMemberService libraryMemberService, BookService bookService, BorrowingRecordsService borrowingRecordsService) {
        this.libraryMemberService = libraryMemberService;
        this.borrowingRecordsService = borrowingRecordsService;
        this.bookService = bookService;
    }


    @GetMapping("/json")
    public ModelAndView importJson() throws IOException {

        boolean[] areImported = new boolean[]{
                this.bookService.areImported(),
                this.libraryMemberService.areImported()
        };

        return super.view("json/import-json", "areImported", areImported);
    }


    @GetMapping("/xml")
    public ModelAndView importXml() {
        boolean[] areImported = new boolean[]{
                this.borrowingRecordsService.areImported()
        };

        return super.view("xml/import-xml", "areImported", areImported);
    }


    @GetMapping("/borrowing-records")
    public ModelAndView importBorrowingRecords() throws IOException {
        String fileContent = this.borrowingRecordsService.readBorrowingRecordsFromFile();

        return super.view("xml/import-borrowing-records", "borrowingRecords", fileContent);
    }

    @PostMapping("/borrowing-records")
    public ModelAndView importBorrowingRecordsConfirm() throws JAXBException, IOException {
        System.out.println(this.borrowingRecordsService.importBorrowingRecords());

        return super.redirect("/import/xml");
    }


    @GetMapping("/books")
    public ModelAndView importBooks() throws IOException {
        String fileContent = this.bookService.readBooksFromFile();

        return super.view("json/import-books", "books", fileContent);
    }

    @PostMapping("/books")
    public ModelAndView importBooksConfirm() throws IOException {
        System.out.println(this.bookService.importBooks());
        return super.redirect("/import/json");
    }

    @GetMapping("/library-members")
    public ModelAndView importLibraryMembers() throws IOException {
        String fileContent = this.libraryMemberService.readLibraryMembersFileContent();

        return super.view("json/import-library-members", "libraryMembers", fileContent);
    }

    @PostMapping("/library-members")
    public ModelAndView importLibraryMembersConfirm() throws IOException {
        System.out.println(this.libraryMemberService.importLibraryMembers());
        return super.redirect("/import/json");
    }
}
