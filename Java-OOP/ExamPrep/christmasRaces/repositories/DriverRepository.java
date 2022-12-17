package ExamPrep.christmasRaces.repositories;

import ExamPrep.christmasRaces.entities.drivers.Driver;
import ExamPrep.christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;

public class DriverRepository implements Repository<Driver> {
    @Override
    public Driver getByName(String name) {
        return null;
    }

    @Override
    public Collection<Driver> getAll() {
        return null;
    }

    @Override
    public void add(Driver model) {

    }

    @Override
    public boolean remove(Driver model) {
        return false;
    }
}
