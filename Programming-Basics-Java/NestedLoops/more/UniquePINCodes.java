package NestedLoops.more;

import java.util.Scanner;

public class UniquePINCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int limitFirst = Integer.parseInt(scanner.nextLine());
        int limitSecond = Integer.parseInt(scanner.nextLine());
        int limitThird = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= limitFirst; i++) {
            for (int j = 2; j <= limitSecond; j++) {
                boolean isPrime = true;
                for (int l = 2; l < j; l++) {
                    if (j % l == 0) {
                        isPrime = false;
                        break;
                    }
                }
                for (int k = 1; k <= limitThird; k++) {
                    if (i % 2 == 0 && isPrime && k % 2 == 0) {
                        System.out.printf("%d %d %d%n", i, j, k);
                    }
                }
            }
        }
    }
}
