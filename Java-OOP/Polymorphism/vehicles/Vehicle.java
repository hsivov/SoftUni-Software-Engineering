package Polymorphism.vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelConsumption;
    private double fuelQuantity;

    public Vehicle(double fuelConsumption, double fuelQuantity) {
        this.fuelConsumption = fuelConsumption;
        this.fuelQuantity = fuelQuantity;
    }

    public String drive(double distance) {
        double fuelNeeded = getFuelConsumption() * distance;

        if (fuelNeeded > getFuelQuantity()) {
            return getClass().getSimpleName() + " needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - fuelNeeded);

        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", getClass().getSimpleName(), df.format(distance));
    }

    public void refuel(double litters) {
        setFuelQuantity(getFuelQuantity() + litters);
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQuantity());
    }
}
