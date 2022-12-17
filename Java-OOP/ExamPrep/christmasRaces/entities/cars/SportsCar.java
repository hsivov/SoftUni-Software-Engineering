package ExamPrep.christmasRaces.entities.cars;

import static ExamPrep.christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar{

    private static final double CUBIC_CENTIMETERS = 3000;
    private static final int MIN_HORSEPOWER = 250;
    private static final int MAX_HORSEPOWER = 450;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
        super.setHorsePower(validHorsePower(horsePower));
    }

    private int validHorsePower(int horsePower) {
        if (horsePower < MIN_HORSEPOWER || horsePower > MAX_HORSEPOWER) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }

        return horsePower;
    }
}
