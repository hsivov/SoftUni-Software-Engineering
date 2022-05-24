package NestedLoops.exercise;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        boolean isMagic = true;

        for (int i = 1111; i < 10000; i++) {
            String currentNum = "" + i;
            for (int j = 0; j < currentNum.length(); j++) {
                int digit = Integer.parseInt("" + currentNum.charAt(j));
                if (digit == 0) {
                    isMagic = false;
                    continue;
                }
                if (n % digit != 0) {
                    isMagic = false;
                }
            }
            if (isMagic) {
                System.out.printf("%d ", i);
            } else {
                isMagic = true;
            }
        }
    }
}
