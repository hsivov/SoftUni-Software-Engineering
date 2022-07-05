package ObjectsAndClasses.more.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();
        List<Tire> tires;

        for (int line = 1; line <= n; line++) {
            String[] input = scanner.nextLine().split(" ");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);

            tires = List.of(tire1, tire2, tire3, tire4);

            Car car = new Car(model, engine, cargo, tires);
            carList.add(car);
        }
        String command = scanner.nextLine();

        switch (command) {
            case "fragile":
            for (Car car : carList) {
                if (car.getCargo().getCargoType().equals(command)) {
                    for (int tire = 0; tire < 4; tire++) {
                        if (car.getTires().get(tire).tirePressure < 1) {
                            System.out.println(car.getModel());
                            break;
                        }
                    }
                }
            }
            break;
            case "flamable":
                for (Car car : carList) {
                    if (car.getCargo().getCargoType().equals(command) && car.getEngine().getEnginePower() > 250) {
                        System.out.println(car.getModel());
                    }
                }
            break;
        }
    }
}
