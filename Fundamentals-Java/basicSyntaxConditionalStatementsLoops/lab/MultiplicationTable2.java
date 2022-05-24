package basicSyntaxConditionalStatementsLoops.lab;

import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int theInteger = Integer.parseInt(scanner.nextLine());
        int times = Integer.parseInt(scanner.nextLine());

        if (times <= 10) {
            for (int i = times; i <= 10; i++) {
                int product = i * theInteger;
                System.out.printf("%d X %d = %d%n", theInteger, i, product);
            }
        } else {
            int product = times * theInteger;
            System.out.printf("%d X %d = %d%n", theInteger, times, product);
        }
    }
}
