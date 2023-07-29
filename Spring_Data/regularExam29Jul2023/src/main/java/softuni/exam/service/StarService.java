package softuni.exam.service;

import java.io.IOException;


public interface StarService {

    boolean areImported();

    String readStarsFileContent() throws IOException;
	
	String importStars() throws IOException;

    String exportStars();
}
