package DefiningClasses.Exercise.SpeedRacing;

public class Car {
    private final String model;
    private double fuelAmount;
    private final double fuelCost;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCost){
        this.model = model;
        this.fuelAmount =fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTraveled = 0;
    }

    public double calculateRequiredFuel(int distance){
        return fuelCost * distance;
    }

    public boolean hasEnoughFuel(int distance){
        return fuelAmount >= calculateRequiredFuel(distance);
    }

    public void driveCar(int distance) {

        if (hasEnoughFuel(distance)){
            this.distanceTraveled += distance;
            this.fuelAmount -= calculateRequiredFuel(distance);
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }
    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, distanceTraveled);
    }
}
