package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountrySeedDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private static final String COUNTRIES_FILE_PATH = "src/main/resources/files/json/countries.json";

    private final Gson gson;
    private final CountryRepository countryRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CountryServiceImpl(Gson gson, CountryRepository countryRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.gson = gson;
        this.countryRepository = countryRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRIES_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder sb = new StringBuilder();

        CountrySeedDto[] countrySeedDtos = gson.fromJson(readCountriesFromFile(), CountrySeedDto[].class);

        Arrays.stream(countrySeedDtos)
                .filter(countrySeedDto -> {
                    boolean isValid = validationUtil.isValid(countrySeedDto);

                    Optional<Country> byCountryName = countryRepository.findByCountryName(countrySeedDto.getCountryName());
                    if (byCountryName.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported country %s - %s",
                            countrySeedDto.getCountryName(),
                            countrySeedDto.getCurrency())
                            : "Invalid country");
                    sb.append(System.lineSeparator());

                    return isValid;
                })
                .map(countrySeedDto -> modelMapper.map(countrySeedDto, Country.class))
                .forEach(countryRepository::save);

        return sb.toString();
    }

    @Override
    public Optional<Country> getCountryById(Long countryId) {
        return countryRepository.findCountryById(countryId);
    }
}
