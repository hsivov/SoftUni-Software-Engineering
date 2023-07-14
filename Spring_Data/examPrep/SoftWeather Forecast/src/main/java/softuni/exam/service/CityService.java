package softuni.exam.service;

import softuni.exam.models.entity.City;

import java.io.IOException;

public interface CityService {

    boolean areImported();

    String readCitiesFileContent() throws IOException;
	
	String importCities() throws IOException;

    City findCityById(Long cityId);
}
