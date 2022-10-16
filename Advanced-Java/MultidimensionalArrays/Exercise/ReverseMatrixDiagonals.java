package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = cols - 1; i >= 0; i--) {
            int row = rows - 1;
            int col = i;
            while (row >= 0 && col < cols) {
                System.out.print(matrix[row][col] + " ");
                row--;
                col++;
            }
            System.out.println();
        }
        for (int i = rows - 2; i >= 0; i--) {
            int row = i;
            int col = 0;
            while (row >= 0 && col < cols) {
                System.out.print(matrix[row][col] + " ");
                row--;
                col++;
            }
            System.out.println();
        }
    }
}
