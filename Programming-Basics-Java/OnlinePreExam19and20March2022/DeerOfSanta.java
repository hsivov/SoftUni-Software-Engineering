package OnlinePreExam19and20March2022;

import java.util.Scanner;

public class DeerOfSanta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int foodLeft = Integer.parseInt(scanner.nextLine());
        double dayFoodDeer1 = Double.parseDouble(scanner.nextLine());
        double dayFoodDeer2 = Double.parseDouble(scanner.nextLine());
        double dayFoodDeer3 = Double.parseDouble(scanner.nextLine());

        double neededFood = dayFoodDeer1 * days + dayFoodDeer2 * days + dayFoodDeer3 * days;

        if (neededFood <= foodLeft){
            System.out.printf("%.0f kilos of food left.", Math.floor(foodLeft - neededFood));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(neededFood - foodLeft));
        }
    }
}
