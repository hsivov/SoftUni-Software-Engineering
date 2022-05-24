package ConditionalStatementsAdvanced.exercise;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        int amount = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double price = 0;

        switch (type) {
            case "Roses":
                price = amount * 5;
                if (amount > 80) {
                    price = price - price * 0.1;
                }
                break;
            case "Dahlias":
                price = amount * 3.80;
                if (amount > 90) {
                    price = price - price * 0.15;
                }
                break;
            case "Tulips":
                price = amount * 2.80;
                if (amount > 80) {
                    price = price - price * 0.15;
                }
                break;
            case "Narcissus":
                price = amount * 3;
                if (amount < 120) {
                    price = price + price * 0.15;
                }
                break;
            case "Gladiolus":
                price = amount * 2.50;
                if (amount < 80) {
                    price = price + price * 0.20;
                }
                break;
        }
        if (budget >= price){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", amount, type, budget - price);
        }else{
            System.out.printf("Not enough money, you need %.2f leva more.", price - budget);
        }
    }
}
