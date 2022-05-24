package OnlineExam28And29March2020;

import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double totalFood = Double.parseDouble(scanner.nextLine());
        double totalDogFood = 0;
        double totalCatFood = 0;
        double biscuits = 0;

        for (int i = 1; i <= days; i++) {
            int dogFood = Integer.parseInt(scanner.nextLine());
            int catFood = Integer.parseInt(scanner.nextLine());

            totalDogFood += dogFood;
            totalCatFood += catFood;

            if (i % 3 == 0) {
                double currentBiscuits = (dogFood + catFood) * 0.1;
                biscuits += currentBiscuits;
            }
        }
        System.out.printf("Total eaten biscuits: %dgr.%n", Math.round(biscuits));
        System.out.printf("%.2f%% of the food has been eaten.%n", (totalDogFood + totalCatFood) / totalFood * 100);
        System.out.printf("%.2f%% eaten from the dog.%n", totalDogFood / (totalDogFood + totalCatFood) * 100);
        System.out.printf("%.2f%% eaten from the cat.", totalCatFood / (totalDogFood + totalCatFood) * 100);
    }
}
