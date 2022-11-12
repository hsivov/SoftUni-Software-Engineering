package Polymorphism.vehicles;

public class Truck extends Vehicle {

    private static final double AC_ADDITIONAL_FUEL_CONSUMPTION = 1.6;

    public Truck(double fuelConsumption, double fuelQuantity) {
        super(fuelConsumption + AC_ADDITIONAL_FUEL_CONSUMPTION, fuelQuantity);
    }

    @Override
    public String drive(double distance) {
        return super.drive(distance);
    }

    @Override
    public void refuel(double litters) {
        super.refuel(litters * 0.95);
    }
}
