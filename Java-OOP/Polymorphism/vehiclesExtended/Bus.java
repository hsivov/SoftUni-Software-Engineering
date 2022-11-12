package Polymorphism.vehiclesExtended;

public class Bus extends Vehicle{

    private static final double AC_ADDITIONAL_FUEL_CONSUMPTION = 1.4;
    public Bus(double fuelConsumption, double fuelQuantity, double tankCapacity) {
        super(fuelConsumption, fuelQuantity, tankCapacity, AC_ADDITIONAL_FUEL_CONSUMPTION);
    }

    @Override
    public String drive(double distance) {
        return super.drive(distance);
    }

    @Override
    public void refuel(double litters) {
        super.refuel(litters);
    }
}
