package BasicSyntaxConditionalStatementsLoops.exercise;

import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= row; column++) {
                System.out.printf("%d ", row);
            }
            System.out.println();
        }
    }
}
