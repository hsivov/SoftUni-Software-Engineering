package ExamPrep.christmasRaces.core;

import ExamPrep.christmasRaces.core.interfaces.Controller;
import ExamPrep.christmasRaces.entities.cars.Car;
import ExamPrep.christmasRaces.entities.drivers.Driver;
import ExamPrep.christmasRaces.entities.races.Race;
import ExamPrep.christmasRaces.repositories.interfaces.Repository;

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
    public String createDriver(String driver) {
        return null;
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        return null;
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        return null;
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        return null;
    }

    @Override
    public String startRace(String raceName) {
        return null;
    }

    @Override
    public String createRace(String name, int laps) {
        return null;
    }
}
