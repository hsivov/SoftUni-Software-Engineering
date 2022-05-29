package DataTypesAndVariables.exercise;

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < n; i++) {
            char letter = scanner.nextLine().charAt(0);
            sum += letter;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
