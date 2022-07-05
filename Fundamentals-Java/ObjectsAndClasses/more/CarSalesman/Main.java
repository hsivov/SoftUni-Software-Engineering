package ObjectsAndClasses.more.CarSalesman;

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
            String[] inputEngine = scanner.nextLine().split(" ");
            String engineModel = inputEngine[0];
            String enginePower = inputEngine[1];
            String engineDisplacement = "n/a";
            String engineEfficiency = "n/a";

            if (inputEngine.length == 3){
                if (Character.isDigit(inputEngine[2].charAt(0))) {
                    engineDisplacement = inputEngine[2];
                } else {
                    engineEfficiency = inputEngine[2];
                }
            }
            if (inputEngine.length == 4){
                engineDisplacement = inputEngine[2];
                engineEfficiency = inputEngine[3];
            }
            Car.Engine engine = new Car.Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            engineList.add(engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int line = 1; line <= m; line++) {
            String[] inputCar = scanner.nextLine().split(" ");
            String model = inputCar[0];
            String engine = inputCar[1];
            String weight = "n/a";
            String color = "n/a";
            Car.Engine currentEngine = null;

            if (inputCar.length == 3){
                if (Character.isDigit(inputCar[2].charAt(0))) {
                    weight = inputCar[2];
                } else {
                    color = inputCar[2];
                }
            }
            if (inputCar.length == 4){
                weight = inputCar[2];
                color = inputCar[3];
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
