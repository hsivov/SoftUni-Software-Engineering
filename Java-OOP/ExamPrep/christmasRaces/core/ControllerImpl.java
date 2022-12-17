package ExamPrep.christmasRaces.core;

import ExamPrep.christmasRaces.common.ExceptionMessages;
import ExamPrep.christmasRaces.common.OutputMessages;
import ExamPrep.christmasRaces.core.interfaces.Controller;
import ExamPrep.christmasRaces.entities.cars.Car;
import ExamPrep.christmasRaces.entities.cars.MuscleCar;
import ExamPrep.christmasRaces.entities.cars.SportsCar;
import ExamPrep.christmasRaces.entities.drivers.Driver;
import ExamPrep.christmasRaces.entities.drivers.DriverImpl;
import ExamPrep.christmasRaces.entities.races.Race;
import ExamPrep.christmasRaces.entities.races.RaceImpl;
import ExamPrep.christmasRaces.repositories.interfaces.Repository;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driverName) {
        Driver driver = new DriverImpl(driverName);

        if (driverRepository.getByName(driverName) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_EXISTS, driverName));
        }
        driverRepository.add(driver);
        return String.format(OutputMessages.DRIVER_CREATED, driverName);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {

        Car car = null;
        if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);
        } else if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
        }

        if (carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_EXISTS, model));
        }
        carRepository.add(car);

        return String.format(OutputMessages.CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {

        Car car = carRepository.getByName(carModel);
        Driver driver = driverRepository.getByName(driverName);

        if (car == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_NOT_FOUND, carModel));
        }
        if (driver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }

        driver.addCar(car);

        return String.format(OutputMessages.CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {

        Driver driver = driverRepository.getByName(driverName);
        Race race = raceRepository.getByName(raceName);

        if (race == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        if (driver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
        race.addDriver(driver);

        return String.format(OutputMessages.DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);

        if (race == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        if (race.getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID, raceName, 3));
        }

        Map<Double, Driver> results = new TreeMap<>(Collections.reverseOrder());
        for (Driver driver : race.getDrivers()) {
            double result = driver.getCar().calculateRacePoints(race.getLaps());
            results.put(result, driver);
        }

        StringBuilder result = new StringBuilder();
        int position = 1;
        for (Map.Entry<Double, Driver> entry : results.entrySet()) {
            switch (position) {
                case 1:
                    result.append(String.format(OutputMessages.DRIVER_FIRST_POSITION, entry.getValue().getName(), race.getName()));
                    result.append(System.lineSeparator());
                    break;
                case 2:
                    result.append(String.format(OutputMessages.DRIVER_SECOND_POSITION, entry.getValue().getName(), race.getName()));
                    result.append(System.lineSeparator());
                    break;
                case 3:
                    result.append(String.format(OutputMessages.DRIVER_THIRD_POSITION, entry.getValue().getName(), race.getName()));
                    break;
            }
            position++;
        }


        return result.toString();
    }

    @Override
    public String createRace(String name, int laps) {

        Race race = new RaceImpl(name, laps);
        if (raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS, name));
        }
        raceRepository.add(race);

        return String.format(OutputMessages.RACE_CREATED, name);
    }

}
