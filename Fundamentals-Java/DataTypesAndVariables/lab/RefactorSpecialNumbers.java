package DataTypesAndVariables.lab;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int number = 1; number <= n; number++) {
            int current = number;
            int sum = 0;
            while (current > 0) {
                sum += current % 10;
                current = current / 10;
            }
            boolean isMagic = (sum == 5) || (sum == 7) || (sum == 11);
            if (isMagic) {
                System.out.printf("%d -> True%n", number);
            } else {
                System.out.printf("%d -> False%n", number);
            }
        }
    }
}
