package NestedLoops.lab;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();


        while (!destination.equals("End")) {
            double budget = Double.parseDouble(scanner.nextLine());
            double deposit = 0;

            while (deposit < budget) {
                double amount = Double.parseDouble(scanner.nextLine());
                deposit += amount;
            }
            System.out.printf("Going to %s!%n", destination);
            destination = scanner.nextLine();
        }
    }
}
