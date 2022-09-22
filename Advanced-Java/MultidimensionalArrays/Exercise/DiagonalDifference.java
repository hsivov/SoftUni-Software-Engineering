package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int sumFirstDiagonal = 0;
        int sumSecondDiagonal = 0;

        for (int i = 0; i < matrix.length; i++) {
            sumFirstDiagonal += matrix[i][i];
            sumSecondDiagonal += matrix[i][matrix.length - 1 - i];
        }
        int difference = Math.abs(sumFirstDiagonal - sumSecondDiagonal);
        System.out.println(difference);
    }
}
