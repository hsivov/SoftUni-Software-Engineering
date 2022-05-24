package ConditionalStatementsAdvanced.lab;

import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double amount = Double.parseDouble(scanner.nextLine());

        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                switch (fruit) {
                    case "banana":
                        System.out.printf("%.2f",amount * 2.50);
                        break;
                    case "apple":
                        System.out.printf("%.2f",amount * 1.20);
                        break;
                    case "orange":
                        System.out.printf("%.2f",amount * 0.85);
                        break;
                    case "grapefruit":
                        System.out.printf("%.2f",amount * 1.45);
                        break;
                    case "kiwi":
                        System.out.printf("%.2f",amount * 2.70);
                        break;
                    case "pineapple":
                        System.out.printf("%.2f",amount * 5.50);
                        break;
                    case "grapes":
                        System.out.printf("%.2f",amount * 3.85);
                        break;
                    default:
                        System.out.println("error");
                        break;
                }
                break;
            case "Saturday":
            case "Sunday":
                switch (fruit) {
                    case "banana":
                        System.out.printf("%.2f",amount * 2.70);
                        break;
                    case "apple":
                        System.out.printf("%.2f",amount * 1.25);
                        break;
                    case "orange":
                        System.out.printf("%.2f",amount * 0.90);
                        break;
                    case "grapefruit":
                        System.out.printf("%.2f",amount * 1.60);
                        break;
                    case "kiwi":
                        System.out.printf("%.2f",amount * 3.00);
                        break;
                    case "pineapple":
                        System.out.printf("%.2f",amount * 5.60);
                        break;
                    case "grapes":
                        System.out.printf("%.2f",amount * 4.20);
                        break;
                    default:
                        System.out.println("error");
                        break;
                }
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}
