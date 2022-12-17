package ExamPrep.christmasRaces.repositories;

import ExamPrep.christmasRaces.entities.drivers.Driver;
import ExamPrep.christmasRaces.repositories.interfaces.Repository;

import java.util.*;

public class DriverRepository implements Repository<Driver> {

    Map<String, Driver> drivers;

    public DriverRepository() {
        this.drivers = new LinkedHashMap<>();
    }

    @Override
    public Driver getByName(String name) {
        return drivers.get(name);
    }

    @Override
    public Collection<Driver> getAll() {
        return List.copyOf(new ArrayList<>(drivers.values()));
    }

    @Override
    public void add(Driver driver) {
        drivers.put(driver.getName(), driver);
    }

    @Override
    public boolean remove(Driver driver) {
        return drivers.remove(driver.getName()) != null;
    }
}
