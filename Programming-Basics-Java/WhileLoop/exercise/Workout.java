package WhileLoop.exercise;

import java.util.Scanner;

public class Workout {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double kilometers = Double.parseDouble(scanner.nextLine());
        double totalKilometers = kilometers;

        for (int i = 1; i <= days; i++) {
            int percent = Integer.parseInt(scanner.nextLine());
            kilometers += kilometers * percent / 100;
            totalKilometers += kilometers;
        }
        if (totalKilometers >= 1000) {
            System.out.printf("You've done a great job running %.0f more kilometers!", Math.ceil(totalKilometers - 1000));
        } else {
            System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers", Math.ceil(1000 - totalKilometers));
        }
    }
}
