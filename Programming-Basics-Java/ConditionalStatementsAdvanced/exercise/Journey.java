package ConditionalStatementsAdvanced.exercise;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String destination = "";
        String type = "";
        double price = 0;

        if (budget <= 100) {
            destination = "Bulgaria";
            switch (season) {
                case "summer":
                    type = "Camp";
                    price = budget * 0.30;
                    break;
                case "winter":
                    type = "Hotel";
                    price = budget * 0.70;
                    break;
            }
        } else if (budget <= 1000) {
            destination = "Balkans";
            switch (season) {
                case "summer":
                    type = "Camp";
                    price = budget * 0.40;
                    break;
                case "winter":
                    type = "Hotel";
                    price = budget * 0.80;
                    break;
            }
        } else {
            destination = "Europe";
            type = "Hotel";
            price = budget * 0.90;
        }
        System.out.printf("Somewhere in %s%n" +
                "%s - %.2f",destination, type, price);
    }
}

