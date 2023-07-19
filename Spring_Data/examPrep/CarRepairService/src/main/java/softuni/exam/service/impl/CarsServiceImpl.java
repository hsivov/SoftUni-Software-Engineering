package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarSeedRootDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class CarsServiceImpl implements CarsService {
    private static String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";
    private final CarsRepository carsRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CarsServiceImpl(CarsRepository carsRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.carsRepository = carsRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
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
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(CARS_FILE_PATH, CarSeedRootDto.class)
                .getCars()
                .stream()
                .filter(carSeedDto -> {
                    boolean isValid = validationUtil.isValid(carSeedDto);

                    Optional<Car> carByPlateNumber = carsRepository.findFirstByPlateNumber(carSeedDto.getPlateNumber());
                    if (carByPlateNumber.isPresent()) {
                        isValid = false;
                    }

                    sb
                            .append(isValid ? String.format("Successfully imported car %s - %s",
                                    carSeedDto.getCarMake(),
                                    carSeedDto.getCarModel())
                                    : "Invalid car")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(carSeedDto -> modelMapper.map(carSeedDto, Car.class))
                .forEach(carsRepository::save);

        return sb.toString();
    }
    @Override
    public Car getCarById(Long carId) {
        return carsRepository.findById(carId).orElse(null);
    }
}
