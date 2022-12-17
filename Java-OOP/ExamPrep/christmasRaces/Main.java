package ExamPrep.christmasRaces;

import ExamPrep.christmasRaces.core.ControllerImpl;
import ExamPrep.christmasRaces.core.EngineImpl;
import ExamPrep.christmasRaces.core.interfaces.Controller;
import ExamPrep.christmasRaces.entities.cars.Car;
import ExamPrep.christmasRaces.entities.drivers.Driver;
import ExamPrep.christmasRaces.entities.races.Race;
import ExamPrep.christmasRaces.io.ConsoleReader;
import ExamPrep.christmasRaces.io.ConsoleWriter;
import ExamPrep.christmasRaces.repositories.CarRepository;
import ExamPrep.christmasRaces.repositories.DriverRepository;
import ExamPrep.christmasRaces.repositories.RaceRepository;
import ExamPrep.christmasRaces.repositories.interfaces.Repository;

public class Main {
    public static void main(String[] args) {
        Repository<Car> carRepository = new CarRepository();
        Repository<Race> raceRepository = new RaceRepository();
        Repository<Driver> driverRepository = new DriverRepository();

        Controller controller = new ControllerImpl(driverRepository, carRepository, raceRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
