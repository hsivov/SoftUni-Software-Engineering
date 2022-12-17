package ExamPrep.christmasRaces.repositories;

import ExamPrep.christmasRaces.entities.cars.Car;
import ExamPrep.christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;

public class CarRepository implements Repository<Car> {

    @Override
    public Car getByName(String name) {
        return null;
    }

    @Override
    public Collection getAll() {
        return null;
    }

    @Override
    public void add(Car model) {

    }

    @Override
    public boolean remove(Car model) {
        return false;
    }

}
