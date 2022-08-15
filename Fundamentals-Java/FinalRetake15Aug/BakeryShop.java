package FinalRetake15Aug;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BakeryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> foodMap = new LinkedHashMap<>();
        int totalSold = 0;

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Complete")) {
            String command = commandLine.split(" ")[0];
            int quantity = Integer.parseInt(commandLine.split(" ")[1]);
            String food = commandLine.split(" ")[2];

            switch (command) {
                case "Receive":
                    if (quantity > 0) {
                        if (foodMap.containsKey(food)) {
                            int currentQuantity = foodMap.get(food);
                            foodMap.put(food, currentQuantity + quantity);
                        } else {
                            foodMap.put(food, quantity);
                        }
                    }
                    break;
                case "Sell":
                    if (foodMap.containsKey(food)) {
                        int foodLeft = foodMap.get(food);

                        if (foodLeft < quantity) {
                            System.out.printf("There aren't enough %s. You sold the last %d of them.%n", food, foodLeft);
                            foodMap.remove(food);
                            totalSold += foodLeft;
                        } else {
                            foodMap.put(food, foodLeft - quantity);
                            System.out.printf("You sold %d %s.%n", quantity, food);
                            if (foodMap.get(food) == 0) {
                                foodMap.remove(food);
                            }
                            totalSold += quantity;
                        }
                    } else {
                        System.out.printf("You do not have any %s.%n", food);
                    }
                    break;
            }
            commandLine = scanner.nextLine();
        }
        foodMap.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
        System.out.printf("All sold: %d goods", totalSold);

    }
}
