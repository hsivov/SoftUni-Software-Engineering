package Arrays.lab;

import java.util.Scanner;

public class PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numArr = new int[n];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            numArr[i] = number;
        }

        for (int i = numArr.length - 1; i >= 0; i--) {
            System.out.printf("%d ", numArr[i]);
        }
    }
}
