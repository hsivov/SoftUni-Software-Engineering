package MidExams;

import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double foodQuantity = Double.parseDouble(scanner.nextLine()) * 1000;
        double heyQuantity = Double.parseDouble(scanner.nextLine()) * 1000;
        double coverQuantity = Double.parseDouble(scanner.nextLine()) *1000;
        double weight = Double.parseDouble(scanner.nextLine()) * 1000;

        for (int day = 1; day <= 30; day++) {
            foodQuantity -= 300;

            if (day % 2 == 0) {
                heyQuantity -= foodQuantity * 0.05;
            }
            if (day % 3 == 0) {
                coverQuantity -= weight / 3;
            }
        }
        if (foodQuantity > 0 && heyQuantity > 0 && coverQuantity > 0) {
            System.out.printf("Everything is fine! Puppy is happy! " +
                    "Food: %.2f, Hay: %.2f, Cover: %.2f.", foodQuantity / 1000, heyQuantity / 1000, coverQuantity / 1000);
        } else {
            System.out.println("Merry must go to the pet store!");
        }
    }
}
