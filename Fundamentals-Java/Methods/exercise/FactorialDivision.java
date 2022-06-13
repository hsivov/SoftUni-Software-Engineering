package Methods.exercise;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        double result = findFactorial(number1) / findFactorial(number2);
        System.out.printf("%.2f", result);
    }

    private static double findFactorial(int number) {
        double result = 1;
        for (int i = 0; i < number; i++) {
            result = result * (number - i);
        }
        return result;
    }

}
