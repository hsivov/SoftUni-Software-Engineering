package Exams.JavaAdvancedRetakeExam_17Dec2019;

import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int presentsCount = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int santaRow = -1;
        int santaCol = -1;
        int countNiceKids = 0;
        int presentsDelivered = 0;

        for (int i = 0; i < matrix.length; i++) {
            String row = scanner.nextLine().replaceAll(" ", "");
            matrix[i] = row.toCharArray();

            if (row.contains("S")) {
                santaRow = i;
                santaCol = row.indexOf("S");
            }

            for (int c = 0; c < matrix[i].length; c++) {
                if (matrix[i][c] == 'V') {
                    countNiceKids++;
                }
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("Christmas morning")) {

            matrix[santaRow][santaCol] = '-';

            if (command.equals("up") && santaRow - 1 >= 0) {
                santaRow--;
            } else if (command.equals("down") && santaRow + 1 < matrix.length) {
                santaRow++;
            } else if (command.equals("left") && santaCol - 1 >= 0) {
                santaCol--;
            } else if (command.equals("right") && santaCol + 1 < matrix[santaRow].length) {
                santaCol++;
            } else {
                System.out.println("Santa ran out of presents.");
                break;
            }

            if (matrix[santaRow][santaCol] == 'V') {
                presentsDelivered++;
                countNiceKids--;
                presentsCount--;
            }

//            if (matrix[santaRow][santaCol] == 'C') {
//
//            }

            if (presentsCount == 0) {
                System.out.println("Santa ran out of presents.");
                matrix[santaRow][santaCol] = 'S';
                break;
            }

            matrix[santaRow][santaCol] = 'S';
            command = scanner.nextLine();
        }
        printMatrix(matrix);
        String output = countNiceKids == 0 ?
                String.format("Good job, Santa! %d happy nice kid/s.", presentsDelivered)
                : String.format("No presents for %d nice kid/s.", countNiceKids);

        System.out.println(output);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}
