package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.BorrowingRecordsService;
import softuni.exam.service.BookService;
import softuni.exam.service.LibraryMemberService;

import java.io.IOException;

@Controller
public class HomeController extends BaseController {

    private final LibraryMemberService libraryMemberService;
    private final BorrowingRecordsService borrowingRecordsService;
    private final BookService bookService;

    @Autowired
    public HomeController(LibraryMemberService libraryMemberService, BookService bookService, BorrowingRecordsService borrowingRecordsService) {
        this.libraryMemberService = libraryMemberService;
        this.borrowingRecordsService = borrowingRecordsService;
        this.bookService = bookService;
    }


    @GetMapping("/")
    public ModelAndView index() throws IOException {
        boolean areImported = this.libraryMemberService.areImported() &&
                this.bookService.areImported() &&
                this.libraryMemberService.areImported()  &&
                this.borrowingRecordsService.areImported();

        return super.view("index", "areImported", areImported);
    }
}
