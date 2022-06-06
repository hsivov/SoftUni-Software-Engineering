package Arrays.exercise;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        for (int row = 1; row <= n; row++) {
            String numbers = scanner.nextLine();
            int first = Integer.parseInt(numbers.split(" ")[0]);
            int second = Integer.parseInt(numbers.split(" ")[1]);

            if (row % 2 == 0){
                secondArray[row - 1] = first;
                firstArray[row - 1] = second;
            } else {
                firstArray[row - 1] = first;
                secondArray[row - 1] = second;
            }
        }
        for (int number:firstArray
             ) {
            System.out.print(number + " ");
        }
        System.out.println();

        for (int number:secondArray
             ) {
            System.out.print(number + " ");
        }
    }
}
