package Polymorphism.vehiclesExtended;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelConsumption;
    private double fuelQuantity;
    private double tankCapacity;
    private double ac_additional_consumption;

    protected Vehicle(double fuelConsumption, double fuelQuantity, double tankCapacity, double ac_additional_consumption) {
        this.fuelConsumption = fuelConsumption;
        this.fuelQuantity = fuelQuantity;
        this.tankCapacity = tankCapacity;
        this.ac_additional_consumption = ac_additional_consumption;
    }

    public String driveWithAC(double distance) {
        setFuelConsumption(getFuelConsumption() + ac_additional_consumption);
        String result = drive(distance);
        setFuelConsumption(getFuelConsumption() - ac_additional_consumption);
        return result;
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
        if (litters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (getFuelQuantity() + litters > getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
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

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQuantity());
    }
}
