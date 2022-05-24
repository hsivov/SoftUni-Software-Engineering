package ConditionalStatements.exercise;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int statist = Integer.parseInt(scanner.nextLine());
        double clothPrice = Double.parseDouble(scanner.nextLine());

        double decor = budget * 0.1;

        if (statist > 150) {
            clothPrice = clothPrice * 0.9;
        }
        double total = statist * clothPrice + decor;

        if (budget - total < 0) {
            System.out.printf("Not enough money!%n" +
                    "Wingard needs %.2f leva more.", total - budget);
        } else {
            System.out.printf("Action!%n" +
                    "Wingard starts filming with %.2f leva left.", budget - total);
        }
    }
}
