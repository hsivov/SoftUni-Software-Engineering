package ObjectsAndClasses.exercise.VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<VehicleCatalogue> vehicles = new ArrayList<>();
        int countCars = 0;
        int countTrucks = 0;
        int carsHorsePower = 0;
        int truckHorsePower = 0;

        String vehicleData = scanner.nextLine();

        while (!vehicleData.equals("End")){
            String type = vehicleData.split(" ")[0];
            String model = vehicleData.split(" ")[1];
            String color = vehicleData.split(" ")[2];
            int horsePower = Integer.parseInt(vehicleData.split(" ")[3]);

            if (type.equals("car")){
                countCars++;
                carsHorsePower += horsePower;
            } else if (type.equals("truck")){
                countTrucks++;
                truckHorsePower += horsePower;
            }

            VehicleCatalogue vehicle  = new VehicleCatalogue(type, model, color, horsePower);
            vehicles.add(vehicle);

            vehicleData = scanner.nextLine();
        }

        String model = scanner.nextLine();
        while (!model.equals("Close the Catalogue")){
            for (VehicleCatalogue vehicle : vehicles){
                if (vehicle.getModel().equals(model)){
                    System.out.printf("Type: %s%n", vehicle.getType().substring(0,1).toUpperCase() + vehicle.getType().substring(1));
                    System.out.printf("Model: %s%n", vehicle.getModel());
                    System.out.printf("Color: %s%n", vehicle.getColor());
                    System.out.printf("Horsepower: %d%n", vehicle.getHorsePower());
                }
            }
            model = scanner.nextLine();
        }
        if (countCars == 0){
            System.out.println("Cars have average horsepower of: 0.00.");
        } else {
            System.out.printf("Cars have average horsepower of: %.2f.%n", carsHorsePower * 1.00 / countCars);
        }
        if (countTrucks == 0){
            System.out.println("Trucks have average horsepower of: 0.00.");
        } else {
            System.out.printf("Trucks have average horsepower of: %.2f.", truckHorsePower * 1.00 / countTrucks);
        }
    }
}
