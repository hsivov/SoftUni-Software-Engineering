package Exams.JavaAdvancedExam_22Feb2020;

import java.util.Scanner;

public class ReVolt {

    private static boolean hasWon = false;
    private static int playerRow;
    private static int playerCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[dimension][dimension];

        for (int r = 0; r < matrix.length; r++) {
            String row = scanner.nextLine();
            matrix[r] = row.toCharArray();

            if (row.contains("f")) {
                playerRow = r;
                playerCol = row.indexOf("f");
            }
        }

        for (int i = 0; i < numberOfCommands; i++) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    movePlayer(matrix, -1, 0);
                    break;

                case "down":
                    movePlayer(matrix, 1, 0);
                    break;

                case "left":
                    movePlayer(matrix, 0, -1);
                    break;

                case "right":
                    movePlayer(matrix, 0, 1);
                    break;
            }
            if (hasWon) {
                break;
            }
        }
        System.out.println(hasWon ? "Player won!" : "Player lost!");

        for (char[] row : matrix) {
            for (char aChar : row) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static void movePlayer(char[][] matrix, int rowMutator, int colMutator) {

        int nextRow = playerRow + rowMutator;
        int nextCol = playerCol + colMutator;

        if (isOutOfBounds(matrix, nextRow, nextCol)) {
            if (nextRow < 0 || nextRow >= matrix.length) {
                nextRow = nextRow < 0 ? matrix.length - 1 : 0;
            } else if (nextCol < 0 || nextCol >= matrix[nextRow].length) {
                nextCol = nextCol < 0 ? matrix[nextRow].length - 1 : 0;
            }
        }

        char specialSymbol = matrix[nextRow][nextCol];

        switch (specialSymbol) {
            case 'T':
                return;
            case 'B':
                matrix[playerRow][playerCol] = '-';
                playerRow = nextRow;
                playerCol = nextCol;
                movePlayer(matrix, rowMutator, colMutator);
                return;
            case 'F':
                hasWon = true;
                break;
        }

        if (matrix[playerRow][playerCol] != 'B') {
            matrix[playerRow][playerCol] = '-';
        }
        matrix[nextRow][nextCol] = 'f';
        playerRow = nextRow;
        playerCol = nextCol;
    }

    private static boolean isOutOfBounds(char[][] matrix, int nextRow, int nextCol) {
        return (nextRow < 0 || nextRow >= matrix.length) || (nextCol < 0 || nextCol >= matrix[nextRow].length);
    }
}

