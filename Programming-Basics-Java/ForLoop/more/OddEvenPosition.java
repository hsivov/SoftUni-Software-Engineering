package ForLoop.more;

import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double initialMaxValue = 1000000000.0;
        double initialMinValue = -1000000000.0;
        double oddSum = 0;
        double oddMax = initialMinValue;
        double oddMin = initialMaxValue;
        double evenSum = 0;
        double evenMax = initialMinValue;
        double evenMin = initialMaxValue;

        for (int i = 1; i <= n; i++) {
            double number = Double.parseDouble(scanner.nextLine());

            if (i % 2 != 0) {
                oddSum += number;
                if (oddMax < number) {
                    oddMax = number;
                }
                if (oddMin > number) {
                    oddMin = number;
                }
            } else {
                evenSum += number;
                if (evenMax < number) {
                    evenMax = number;
                }
                if (evenMin > number) {
                    evenMin = number;
                }
            }
        }
        System.out.printf("OddSum=%.2f,%n", oddSum);
        if (oddMin == initialMaxValue) {
            System.out.printf("OddMin=No,%n");
        } else {
            System.out.printf("OddMin=%.2f,%n", oddMin);
        }
        if (oddMax == initialMinValue) {
            System.out.printf("OddMax=No,%n");
        } else {
            System.out.printf("OddMax=%.2f,%n", oddMax);
        }
        System.out.printf("EvenSum=%.2f,%n", evenSum);
        if (evenMin == initialMaxValue) {
            System.out.printf("EvenMin=No,%n");
        } else {
            System.out.printf("EvenMin=%.2f,%n", evenMin);
        }
        if (evenMax == initialMinValue) {
            System.out.printf("EvenMax=No%n");
        } else {
            System.out.printf("EvenMax=%.2f", evenMax);
        }
    }
}
