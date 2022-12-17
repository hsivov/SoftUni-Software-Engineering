package Exams.Retake_14Dec2022;

import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int subRow = -1;
        int subCol = -1;

        int destroyedBattlecruisers = 0;
        int hits = 0;
        boolean isFailed = false;


        for (int r = 0; r < matrix.length; r++) {
            String row = scanner.nextLine();
            matrix[r] = row.toCharArray();

            if (row.contains("S")) {
                subRow = r;
                subCol = row.indexOf("S");
            }
        }

        while (destroyedBattlecruisers < 3) {
            String command = scanner.nextLine();
            matrix[subRow][subCol] = '-';

            if (command.equals("up")) {
                subRow--;
            } else if (command.equals("down")) {
                subRow++;
            } else if (command.equals("left")) {
                subCol--;
            } else if (command.equals("right")) {
                subCol++;
            }

            if (matrix[subRow][subCol] == '*') {
                hits++;
                if (hits > 2) {
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", subRow, subCol);
                    matrix[subRow][subCol] = 'S';
                    isFailed = true;
                    break;
                }
            }

            if (matrix[subRow][subCol] == 'C') {
                destroyedBattlecruisers++;
            }

            matrix[subRow][subCol] = 'S';
        }

        if (!isFailed) {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        }

        getPrintMatrix(matrix);
    }

    private static void getPrintMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
