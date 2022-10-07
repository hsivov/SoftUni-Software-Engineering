package DefiningClasses.Exercise.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carMap = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] carData = scanner.nextLine().split(" ");

            String model = carData[0];
            double fuelAmount = Double.parseDouble(carData[1]);
            double fuelCost = Double.parseDouble(carData[2]);

            Car car = new Car(model, fuelAmount, fuelCost);
            carMap.put(model, car);
        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String carModel = input.split(" ")[1];
            int amountOfKm = Integer.parseInt(input.split(" ")[2]);

            Car currentCar = carMap.get(carModel);

            currentCar.driveCar(amountOfKm);

            input = scanner.nextLine();
        }
        carMap.values().forEach(System.out::println);
    }
}
