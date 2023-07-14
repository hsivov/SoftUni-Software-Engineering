package softuni.exam.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;


public interface ForecastService {

    boolean areImported();

    String readForecastsFromFile() throws IOException;
	
	String importForecasts() throws IOException, JAXBException;

    String exportForecasts();
}
