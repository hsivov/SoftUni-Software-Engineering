package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CarsServiceImpl implements CarsService {
    private static final String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";
    private final CarsRepository carsRepository;

    public CarsServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public boolean areImported() {
        return carsRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {
        return null;
    }
}
