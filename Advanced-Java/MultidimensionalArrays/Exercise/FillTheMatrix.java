package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        char pattern = input[1].charAt(0);

        int[][] matrix = new int[size][size];
        int element = 1;

        switch (pattern) {
            case 'A':
                patternA(matrix, element);
                break;
            case 'B':
                patternB(matrix, element);
                break;
        }
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void patternB(int[][] matrix, int element) {
        for (int col = 0; col < matrix.length; col++) {

            if (col % 2 == 0){
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = element;
                    element++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = element;
                    element++;
                }
            }
        }
    }

    private static void patternA(int[][] matrix, int element) {
        for (int c = 0; c < matrix.length; c++) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][c] = element;
                element++;
            }
        }
    }
}
