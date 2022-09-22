package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = readArray(scanner);
        }

        int[][] maxSumMatrix = new int[3][3];
        int maxSum = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = getSubMatrixElementsSum(matrix, row, col);

                if (maxSum < sum) {
                    maxSum = sum;

                    copyElementsToMaxSumMatrix(matrix, row, col, maxSumMatrix);
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int[] sumMatrix : maxSumMatrix) {
            for (int n : sumMatrix) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static void copyElementsToMaxSumMatrix(int[][] matrix, int row, int col, int[][] maxSumMatrix) {
        for (int r = 0; r < maxSumMatrix.length; r++) {
            System.arraycopy(matrix[row + r], col, maxSumMatrix[r], 0, maxSumMatrix.length);
        }
    }

    private static int getSubMatrixElementsSum(int[][] matrix, int row, int col) {
        int sum = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                sum += matrix[row + r][col + c];
            }
        }
        return sum;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
