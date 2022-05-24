package ConditionalStatements.exercise;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double price = Double.parseDouble(scanner.nextLine());

        int puzzle = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int bears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        int count = puzzle+dolls+bears+minions+trucks;
        double total = puzzle*2.60 + dolls*3 +bears*4.1+minions*8.2 + trucks*2;

        if (count >= 50){
            total = total*0.75;
        }
        total = total*0.9;

        if (total - price >= 0){
            System.out.printf("Yes! %.2f lv left.",total - price);
        }else {
            System.out.printf("Not enough money! %.2f lv needed.",Math.abs(total - price));
        }
    }
}
