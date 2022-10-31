package Exams.JavaAdvancedRetakeExam_19August2020;

import java.util.Scanner;

public class Bee {
    private static int beeRow;
    private static int beeCol;

    private static int pollinatedFlowers = 0;

    private static boolean isLost = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int r = 0; r < matrix.length; r++) {
            String row = scanner.nextLine();
            matrix[r] = row.toCharArray();

            if (row.contains("B")) {
                beeRow = r;
                beeCol = row.indexOf("B");
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {

            switch (command) {
                case "up":
                    moveBee(matrix, -1, 0);
                    break;

                case "down":
                    moveBee(matrix, 1, 0);
                    break;

                case "left":
                    moveBee(matrix, 0, -1);
                    break;

                case "right":
                    moveBee(matrix, 0, 1);
                    break;
            }
            if (isLost) {
                System.out.println("The bee got lost!");
                break;
            } else {
                command = scanner.nextLine();
            }
        }
        String output = pollinatedFlowers < 5
                ? String.format("The bee couldn't pollinate the flowers, she needed %d flowers more", 5 - pollinatedFlowers)
                : String.format("Great job, the bee manage to pollinate %d flowers!", pollinatedFlowers);

        System.out.println(output);

        for (char[] row : matrix) {
            for (char aChar : row) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static void moveBee(char[][] matrix, int rowMutator, int colMutator) {

        int nextRow = beeRow + rowMutator;
        int nextCol = beeCol + colMutator;

        if (!isOutOfBounds(matrix, nextRow, nextCol)) {

            char specialSymbol = matrix[nextRow][nextCol];

            switch (specialSymbol) {

                case 'O':
                    matrix[beeRow][beeCol] = '.';
                    beeRow = nextRow;
                    beeCol = nextCol;
                    moveBee(matrix, rowMutator, colMutator);
                    return;
                case 'f':
                    pollinatedFlowers++;
                    break;
            }
            matrix[beeRow][beeCol] = '.';
            matrix[nextRow][nextCol] = 'B';
            beeRow = nextRow;
            beeCol = nextCol;
        } else {
            matrix[beeRow][beeCol] = '.';
            isLost = true;
        }
    }

    private static boolean isOutOfBounds(char[][] matrix, int nextRow, int nextCol) {
        return (nextRow < 0 || nextRow >= matrix.length) || (nextCol < 0 || nextCol >= matrix[nextRow].length);
    }
}
