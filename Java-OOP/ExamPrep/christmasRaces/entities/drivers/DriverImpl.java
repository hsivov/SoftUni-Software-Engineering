package ExamPrep.christmasRaces.entities.drivers;

import ExamPrep.christmasRaces.entities.cars.Car;

import static ExamPrep.christmasRaces.common.ExceptionMessages.CAR_INVALID;
import static ExamPrep.christmasRaces.common.ExceptionMessages.INVALID_NAME;

public class DriverImpl implements Driver{

    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate = false;

    public DriverImpl(String name) {
        setName(name);
    }

    private void setName(String name) {
        int minSymbols = 5;
        if (name == null || name.trim().isEmpty() || name.length() < minSymbols) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, minSymbols));
        }

        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException(CAR_INVALID);
        }
        setCar(car);
        setCanParticipate();
    }

    private void setCanParticipate() {
        this.canParticipate = true;
    }

    private void setCar(Car car) {
        this.car = car;
    }

    @Override
    public void winRace() {
        numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return canParticipate;
    }
}
