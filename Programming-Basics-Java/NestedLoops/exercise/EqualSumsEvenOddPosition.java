package NestedLoops.exercise;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        for (int i = firstNum; i <= secondNum; i++) {
            String currentNum ="" + i;
            int oddSum = 0;
            int evenSum = 0;

            for (int j = 0; j < currentNum.length(); j++) {
                int digit = Integer.parseInt("" + currentNum.charAt(j));
                if (j % 2 != 0) {
                    oddSum += digit;
                } else {
                    evenSum += digit;
                }
            }
            if (oddSum == evenSum) {
                System.out.print(i + " ");
            }
        }
    }
}
