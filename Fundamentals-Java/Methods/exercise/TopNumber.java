package Methods.exercise;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            boolean isTopNumber = isSumDivisibleBy8(i) && isHoldingOneOddDigit(i);
            if (isTopNumber) {
                System.out.println(i);
            }
        }
    }

    private static boolean isSumDivisibleBy8(int number) {
        int sum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            sum += lastDigit;

            number /= 10;
        }
        return sum % 8 == 0;
    }

    private static boolean isHoldingOneOddDigit(int number) {
        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 != 0) {
                return true;
            }
            number /= 10;
        }
        return false;
    }
}
