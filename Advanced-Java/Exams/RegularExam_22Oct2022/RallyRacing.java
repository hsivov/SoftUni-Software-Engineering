package Exams.RegularExam_22Oct2022;

import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String racingNumber = scanner.nextLine();

        char[][] matrix = new char[size][size];

        int firstTRow = -1;
        int firstTCol = -1;
        int secondTRow = -1;
        int secondTCol = -1;
        int carRow = 0;
        int carCol = 0;
        int distanceCovered = 0;
        boolean isFinished = false;

        for (int i = 0; i < matrix.length; i++) {
            String row = scanner.nextLine().replaceAll(" ", "");
            matrix[i] = row.toCharArray();
            if (row.contains("T") && firstTRow == -1) {
                firstTRow = i;
                firstTCol = row.indexOf("T");
            } else if (row.contains("T")) {
                secondTRow = i;
                secondTCol = row.indexOf("T");
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {

            if ("up".equals(command)) {
                carRow--;
            } else if ("down".equals(command)) {
                carRow++;
            } else if ("left".equals(command)) {
                carCol--;
            } else if ("right".equals(command)) {
                carCol++;
            }

            if (matrix[carRow][carCol] == 'F') {
                isFinished = true;
                distanceCovered += 10;
                break;
            } else if (matrix[carRow][carCol] == 'T') {
                if (carRow == firstTRow) {
                    matrix[carRow][carCol] = '.';
                    carRow = secondTRow;
                    carCol = secondTCol;
                    matrix[carRow][carCol] = '.';
                    distanceCovered += 30;

                } else if (carRow == secondTRow) {
                    matrix[carRow][carCol] = '.';
                    carRow = firstTRow;
                    carCol = firstTCol;
                    matrix[carRow][carCol] = '.';
                    distanceCovered += 30;
                }
            } else {
                distanceCovered += 10;
            }
            command = scanner.nextLine();
        }

        matrix[carRow][carCol] = 'C';

        String output = isFinished
                ? String.format("Racing car %s finished the stage!", racingNumber)
                : String.format("Racing car %s DNF.", racingNumber);

        System.out.println(output);
        System.out.printf("Distance covered %d km.%n", distanceCovered);

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
