package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String size = scanner.nextLine();
        int rows = Integer.parseInt(size.split(" ")[0]);
        int cols = Integer.parseInt(size.split(" ")[1]);

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            if (isValidCommand(input) && areCoordinatesValid(input, rows, cols)) {
                int row1 = Integer.parseInt(input.split(" ")[1]);
                int col1 = Integer.parseInt(input.split(" ")[2]);
                int row2 = Integer.parseInt(input.split(" ")[3]);
                int col2 = Integer.parseInt(input.split(" ")[4]);

                String temp = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = temp;

                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidCommand(String input) {
        String[] command = input.split(" ");

        return command[0].equals("swap") && command.length == 5;
    }

    private static boolean areCoordinatesValid(String input, int rows, int cols) {
        int row1 = Integer.parseInt(input.split(" ")[1]);
        int col1 = Integer.parseInt(input.split(" ")[2]);
        int row2 = Integer.parseInt(input.split(" ")[3]);
        int col2 = Integer.parseInt(input.split(" ")[4]);

        return row1 >= 0 && row1 < rows && col1 >= 0 && col1 < cols && row2 >= 0 && row2 < rows && col2 >= 0 && col2 < cols;
    }
}
