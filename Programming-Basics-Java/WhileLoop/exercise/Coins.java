package WhileLoop.exercise;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double coins = Double.parseDouble(scanner.nextLine()) * 100;
        int change = 0;

        while (coins > 0) {
            if (coins >= 200) {
                change++;
                coins -= 200;
            } else if (coins >= 100) {
                change++;
                coins -= 100;
            } else if (coins >= 50) {
                change++;
                coins -= 50;
            } else if (coins >= 20) {
                change++;
                coins -= 20;
            } else if (coins >= 10) {
                change++;
                coins -= 10;
            } else if (coins >= 5) {
                change++;
                coins -= 5;
            } else if (coins >= 2) {
                change++;
                coins -= 2;
            } else if (coins >= 1) {
                change++;
                coins -= 1;
            } else {
                break;
            }
        }
        System.out.println(change);
    }
}
