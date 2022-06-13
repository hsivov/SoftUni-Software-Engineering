package Methods.lab;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numA = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int numB = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.0f", calculation(numA, operator, numB));
    }

    private static double calculation(int a, String operator, int b){
        double result = 0.0;

        switch (operator){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "/":
                result = a * 1.00 / b ;
                break;
            case "*":
                result = a * b;
                break;
        }
        return result;
    }
}
