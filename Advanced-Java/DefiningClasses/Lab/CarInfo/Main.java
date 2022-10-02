package DefiningClasses.Lab.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String brand = input[0];
            Car car;
            if (input.length == 1) {
                car = new Car(brand);
            } else {
                String model = input[1];
                int horsePower = Integer.parseInt(input[2]);

                car = new Car(brand, model, horsePower);
            }
            cars.add(car);
        }
        cars.forEach(car -> System.out.println(car.carInfo()));
    }
}
