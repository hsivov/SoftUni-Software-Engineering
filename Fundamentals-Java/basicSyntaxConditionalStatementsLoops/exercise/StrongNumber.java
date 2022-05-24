package basicSyntaxConditionalStatementsLoops.exercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int initialNumber = number;

        int sum = 0;

        while (number > 0){
            int fact = 1;
            int lastDigit = number % 10;
            for (int i = 1; i <= lastDigit; i++) {
                fact = fact * i;
            }
            sum += fact;
            number = number / 10;
        }
        if (sum == initialNumber){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
