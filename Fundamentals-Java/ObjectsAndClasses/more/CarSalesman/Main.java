package ObjectsAndClasses.more.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car.Engine> engineList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int line = 1; line <= n; line++) {
            String[] input = scanner.nextLine().split(" ");
            String engineModel = input[0];
            String enginePower = input[1];
            String engineDisplacement = "n/a";
            String engineEfficiency = "n/a";

            if (input.length == 3){
                if (Character.isDigit(input[2].charAt(0))) {
                    engineDisplacement = input[2];
                } else {
                    engineEfficiency = input[2];
                }
            }
            if (input.length == 4){
                engineDisplacement = input[2];
                engineEfficiency = input[3];
            }
            Car.Engine engine = new Car.Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            engineList.add(engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int line = 1; line <= m; line++) {
            String[] input = scanner.nextLine().split(" ");

        }
    }
}
