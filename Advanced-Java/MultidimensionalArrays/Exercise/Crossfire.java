package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        int number = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = String.valueOf(number);
                number++;
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int[] coordinates = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

            markCells(matrix, coordinates);

            for (int i = 0; i < matrix.length; i++) {
                String[] newRow = removeMarkedCells(matrix[i]);
                matrix[i] = newRow;
            }

            matrix = removeEmptyRows(matrix);

            input = scanner.nextLine();
        }

        for (String[] strings : matrix) {
            for (String element : strings) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void markCells(String[][] matrix, int[] coordinates) {
        int r = coordinates[0];
        int c = coordinates[1];
        int radius = coordinates[2];

        int startIndex = r - radius;
        int endIndex = r + radius;

        if (startIndex < 0) {
            startIndex = 0;
        }

        for (int index = startIndex; index <= endIndex; index++) {

            if (c < 0 || index >= matrix.length) {
                break;
            }

            if (c >= matrix[index].length) {
                continue;
            }

            matrix[index][c] = "0";
        }

        startIndex = c - radius;
        endIndex = c + radius;

        if (startIndex < 0) {
            startIndex = 0;
        }


        for (int index = startIndex; index <= endIndex; index++) {

            if (r < 0 || r >= matrix.length) {
                break;
            }

            if (index >= matrix[r].length) {
                break;
            }

            matrix[r][index] = "0";
        }
    }

    private static String[] removeMarkedCells(String[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i].equals("0")) {
                String[] newRow = new String[row.length - 1];
                for (int j = 0; j < newRow.length; j++) {
                    if (j < i) {
                        newRow[j] = row[j];
                    } else {
                        newRow[j] = row[j + 1];
                    }
                }
                row = newRow;
                i--;
            }
        }
        return row;
    }

    private static String[][] removeEmptyRows(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length == 0) {
                String[][] newMatrix = new String[matrix.length - 1][];
                for (int j = 0; j < newMatrix.length; j++) {
                    if (j < i) {
                        newMatrix[j] = matrix[j];
                    } else {
                        newMatrix[j] = matrix[j + 1];
                    }
                }
                matrix = newMatrix;
            }
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
