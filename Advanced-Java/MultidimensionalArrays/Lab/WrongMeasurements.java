package MultidimensionalArrays.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];
        List<int[]> correctValues = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = readArray(scanner);
        }
        int[] indexes = readArray(scanner);

        int valueToReplace = matrix[indexes[0]][indexes[1]];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == valueToReplace) {
                    int correctValue = getNearbySum(matrix, c, r, valueToReplace);
                    correctValues.add(new int[]{r, c, correctValue});
                }
            }
        }
        for (int[] correctValue : correctValues) {
            matrix[correctValue[0]][correctValue[1]] = correctValue[2];
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int getNearbySum(int[][] matrix, int c, int r, int valueToReplace) {
        int sum = 0;

        if (isInBounds(matrix, r + 1, c) && matrix[r + 1][c] != valueToReplace) {
            sum += matrix[r + 1][c];
        }
        if (isInBounds(matrix, r, c + 1) && matrix[r][c + 1] != valueToReplace) {
            sum += matrix[r][c + 1];
        }
        if (isInBounds(matrix, r - 1, c) && matrix[r - 1][c] != valueToReplace) {
            sum += matrix[r - 1][c];
        }
        if (isInBounds(matrix, r, c - 1) && matrix[r][c - 1] != valueToReplace) {
            sum += matrix[r][c - 1];
        }
        return sum;
    }

    private static boolean isInBounds(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
