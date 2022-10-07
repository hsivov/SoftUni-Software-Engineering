package DefiningClasses.Exercise.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car.Engine> engineList = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int line = 1; line <= n; line++) {
            String[] engineData = scanner.nextLine().split(" ");
            String engineModel = engineData[0];
            String enginePower = engineData[1];
            String engineDisplacement = "n/a";
            String engineEfficiency = "n/a";

            if (engineData.length == 3){
                if (Character.isDigit(engineData[2].charAt(0))) {
                    engineDisplacement = engineData[2];
                } else {
                    engineEfficiency = engineData[2];
                }
            }
            if (engineData.length == 4){
                engineDisplacement = engineData[2];
                engineEfficiency = engineData[3];
            }
            Car.Engine engine = new Car.Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            engineList.add(engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int line = 1; line <= m; line++) {
            String[] carData = scanner.nextLine().split(" ");
            String model = carData[0];
            String engine = carData[1];
            String weight = "n/a";
            String color = "n/a";
            Car.Engine currentEngine = null;

            if (carData.length == 3){
                if (Character.isDigit(carData[2].charAt(0))) {
                    weight = carData[2];
                } else {
                    color = carData[2];
                }
            }
            if (carData.length == 4){
                weight = carData[2];
                color = carData[3];
            }
            for (Car.Engine engineModel : engineList){
                if (engineModel.getModel().equals(engine)){
                    currentEngine = engineModel;
                }
            }
            Car car = new Car(model, currentEngine, weight, color);
            cars.add(car);
        }
        for (Car car : cars){
            System.out.println(car);
        }
    }
}
