package ExamPrep.christmasRaces.repositories;

import ExamPrep.christmasRaces.entities.cars.Car;
import ExamPrep.christmasRaces.repositories.interfaces.Repository;

import java.util.*;

public class CarRepository implements Repository<Car> {

    Map<String, Car> cars;

    public CarRepository() {
        this.cars = new LinkedHashMap<>();
    }

    @Override
    public Car getByName(String model) {
        return cars.get(model);
    }

    @Override
    public Collection<Car> getAll() {
        return List.copyOf(cars.values());
    }

    @Override
    public void add(Car car) {
        cars.put(car.getModel(), car);
    }

    @Override
    public boolean remove(Car car) {
        return cars.remove(car.getModel()) != null;
    }

}
