package DataTypesAndVariables.lab;

import java.util.Scanner;

public class ConvertMetersToKilometer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int meters = Integer.parseInt(scanner.nextLine());
        double kilometers = meters / 1000.0;

        System.out.printf("%.2f", kilometers);
    }
}
