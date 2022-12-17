package ExamPrep.christmasRaces.entities.races;

import ExamPrep.christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

import static ExamPrep.christmasRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race{

    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        this.name = name;
        this.laps = laps;
        this.drivers = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver == null) {
            throw new IllegalArgumentException(DRIVER_INVALID);
        }
        if (!driver.getCanParticipate()) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_PARTICIPATE, driver.getName()));
        }
        if (drivers.contains(driver)) {
            throw new IllegalArgumentException(String.format(DRIVER_ALREADY_ADDED, driver.getName(), this.name));
        }

        drivers.add(driver);
    }
}
