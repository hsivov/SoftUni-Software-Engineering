package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sizes = scanner.nextLine();
        int[][] matrix = matrixReader(sizes);
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int sum = 0;
        for (int[] arrays : matrix) {
            for (int anInt : arrays) {
                sum += anInt;
            }
        }
        System.out.println(sum);
    }

    private static int[][] matrixReader(String sizes) {
        int[] dimensions = Arrays.stream(sizes.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        return new int[rows][cols];
    }
}
