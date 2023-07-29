package softuni.exam.service;

import java.io.IOException;


public interface ConstellationService {

    boolean areImported();

    String readConstellationsFromFile() throws IOException;

	String importConstellations() throws IOException;
}
