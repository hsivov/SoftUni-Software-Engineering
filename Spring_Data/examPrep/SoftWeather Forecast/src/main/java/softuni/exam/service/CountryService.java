package softuni.exam.service;


import softuni.exam.models.entity.Country;

import java.io.IOException;
import java.util.Optional;

public interface CountryService {

    boolean areImported();

    String readCountriesFromFile() throws IOException;
	
	String importCountries() throws IOException;

    Optional<Country> getCountryById(Long countryId);
}
