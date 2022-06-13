package Methods.lab;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(getMultiplyOfEvensAndOdds(n));
    }

    private static int getMultiplyOfEvensAndOdds(int n){
        int evenSum = getSumOfEvenDigits(n);
        int oddSum = getSumOfOddDigits(n);

        return evenSum * oddSum;
    }

    private static int getSumOfEvenDigits(int n){
        int sum = 0;
        while (Math.abs(n) > 0){
            int digit = n % 10;
            if (digit % 2 == 0){
                sum += digit;
            }
            n /= 10;
        }
        return sum;
    }

    private static int getSumOfOddDigits(int n){
        int sum = 0;
        while (Math.abs(n) > 0){
            int digit = n % 10;
            if (digit % 2 != 0){
                sum += digit;
            }
            n /= 10;
        }
        return sum;
    }
}
