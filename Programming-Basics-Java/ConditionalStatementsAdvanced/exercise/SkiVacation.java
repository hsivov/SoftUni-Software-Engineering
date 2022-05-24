package ConditionalStatementsAdvanced.exercise;

import java.util.Scanner;

public class SkiVacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String feedback = scanner.nextLine();

        double price = 0;

        switch (type) {
            case "room for one person":
                price = (days - 1) * 18.00;
                break;
            case "apartment":
                if (days < 10) {
                    price = (days - 1) * 25.00;
                    price = price - price * 0.30;
                } else if (days > 15) {
                    price = (days - 1) * 25.00;
                    price = price - price * 0.50;
                } else {
                    price = (days - 1) * 25.00;
                    price = price - price * 0.35;
                }
                break;
            case "president apartment":
                if (days < 10) {
                    price = (days - 1) * 35.00;
                    price = price - price * 0.10;
                } else if (days > 15) {
                    price = (days - 1) * 35.00;
                    price = price - price * 0.20;
                } else {
                    price = (days - 1) * 35.00;
                    price = price - price * 0.15;
                }
                break;
        }

        switch (feedback) {
            case "positive":
                price = price + price * 0.25;
                System.out.printf("%.2f",price);
                break;
            case "negative":
                price = price - price * 0.1;
                System.out.printf("%.2f",price);
                break;
        }
    }
}
