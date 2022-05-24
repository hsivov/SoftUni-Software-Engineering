package ConditionalStatementsAdvanced.exercise;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                if (result % 2 == 0) {
                    System.out.printf("%d %s %d = %d - even", num1, operator, num2, result);
                } else {
                    System.out.printf("%d %s %d = %d - odd", num1, operator, num2, result);
                }
                break;
            case "-":
                result = num1 - num2;
                if (result % 2 == 0) {
                    System.out.printf("%d %s %d = %d - even", num1, operator, num2, result);
                } else {
                    System.out.printf("%d %s %d = %d - odd", num1, operator, num2, result);
                }
                break;
            case "*":
                result = num1 * num2;
                if (result % 2 == 0) {
                    System.out.printf("%d %s %d = %d - even", num1, operator, num2, result);
                } else {
                    System.out.printf("%d %s %d = %d - odd", num1, operator, num2, result);
                }
                break;
            case "/":
                if (num2 != 0) {
                    System.out.printf("%d / %d = %.2f", num1, num2, num1 * 1.00 / num2);
                } else {
                    System.out.printf("Cannot divide %d by zero", num1);
                }
                break;
            case "%":
                if (num2 != 0) {
                    System.out.printf("%d %% %d = %d", num1, num2, num1 % num2);
                } else {
                    System.out.printf("Cannot divide %d by zero", num1);
                }
                break;
        }
    }
}
