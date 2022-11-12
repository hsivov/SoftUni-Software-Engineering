package Polymorphism.vehiclesExtended;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();

        vehicleMap.put("Car", getVehicle(scanner));
        vehicleMap.put("Truck", getVehicle(scanner));
        vehicleMap.put("Bus", getVehicle(scanner));

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] commandLine = scanner.nextLine().split("\\s+");
            String command = commandLine[0];
            String vehicleType = commandLine[1];
            double argument = Double.parseDouble(commandLine[2]);

            switch (command) {
                case "Drive":
                    System.out.println(vehicleMap.get(vehicleType).driveWithAC(argument));
                    break;
                case "DriveEmpty":
                    System.out.println(vehicleMap.get(vehicleType).drive(argument));
                    break;
                case "Refuel":
                    try {
                        vehicleMap.get(vehicleType).refuel(argument);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }
        vehicleMap.values().forEach(System.out::println);
    }

    private static Vehicle getVehicle(Scanner scanner) {
        String[] vehicleData = scanner.nextLine().split("\\s+");
        String vehicleType = vehicleData[0];
        double fuelQuantity = Double.parseDouble(vehicleData[1]);
        double fuelConsumption = Double.parseDouble(vehicleData[2]);
        double tankCapacity = Double.parseDouble(vehicleData[3]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelConsumption, fuelQuantity, tankCapacity);
            case "Truck":
                return new Truck(fuelConsumption, fuelQuantity, tankCapacity);
            case "Bus":
                return new Bus(fuelConsumption, fuelQuantity, tankCapacity);
            default:
                throw new IllegalArgumentException("Unknown vehicle");
        }
    }
}
