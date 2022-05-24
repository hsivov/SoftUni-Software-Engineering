package ForLoop.more;

import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int lastSum = 0;
        int diff = 0;
        int maxDiff = 0;
        boolean isEqual = true;

        for (int i = 0; i < n; i++) {

            int num1 = Integer.parseInt(scanner.nextLine());
            int num2 = Integer.parseInt(scanner.nextLine());

            int currentSum = num1 + num2;

            if (i > 0) {
                if (currentSum != lastSum) {
                    diff = Math.abs(lastSum - currentSum);

                    isEqual = false;
                }
            }

            if (maxDiff < diff) {
                maxDiff = diff;
            }
            lastSum = currentSum;
        }

        if (isEqual) {
            System.out.printf("Yes, value=%d", lastSum);
        } else {
            System.out.printf("No, maxdiff=%d", maxDiff);
        }
    }
}
