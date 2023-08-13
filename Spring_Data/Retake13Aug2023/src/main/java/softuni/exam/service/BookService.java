package softuni.exam.service;


import java.io.IOException;

public interface BookService {

    boolean areImported() throws IOException;

    String readBooksFromFile() throws IOException;

	String importBooks() throws IOException;

}
