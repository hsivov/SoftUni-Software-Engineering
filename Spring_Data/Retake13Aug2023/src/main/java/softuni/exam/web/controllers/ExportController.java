package softuni.exam.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.exam.service.BorrowingRecordsService;
import softuni.exam.service.LibraryMemberService;

@Controller
@RequestMapping("/export")
public class ExportController extends BaseController {

    private final LibraryMemberService libraryMemberService;
    private final BorrowingRecordsService borrowingRecordsService;


    @Autowired
    public ExportController(LibraryMemberService libraryMemberService,
                            BorrowingRecordsService borrowingRecordsService) {
        this.libraryMemberService = libraryMemberService;
        this.borrowingRecordsService = borrowingRecordsService;
    }


    @GetMapping("/borrowing-records")
    public ModelAndView exportNonObservedStarsByDistanceAsc() {
        String exportedBorrowingRecords = borrowingRecordsService.exportBorrowingRecords();

        return super.view("export/export-borrowing-records.html", "exportedBorrowingRecords", exportedBorrowingRecords);
    }
}
