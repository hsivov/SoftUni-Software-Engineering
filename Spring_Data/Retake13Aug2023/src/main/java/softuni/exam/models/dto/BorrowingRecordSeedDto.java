package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordSeedDto {

    @XmlElement(name = "borrow_date")
    private String borrowDate;
    @XmlElement(name = "return_date")
    private String returnDate;

    @XmlElement
    private BookTitleDto book;

    @XmlElement
    private MemberIdDto member;
    @XmlElement
    private String remarks;

    @NotNull
    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    @NotNull
    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @NotNull
    public BookTitleDto getBook() {
        return book;
    }

    public void setBook(BookTitleDto book) {
        this.book = book;
    }

    @NotNull
    public MemberIdDto getMember() {
        return member;
    }

    public void setMember(MemberIdDto member) {
        this.member = member;
    }

    @Size(min = 3, max = 100)
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
