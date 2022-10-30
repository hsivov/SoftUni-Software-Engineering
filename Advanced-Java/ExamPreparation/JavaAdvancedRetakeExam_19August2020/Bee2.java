package ExamPreparation.JavaAdvancedRetakeExam_19August2020;

import java.util.Scanner;

public class Bee2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int beeRow = -1;
        int beeCol = -1;
        int pollinatedFlowers = 0;

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

            matrix[beeRow][beeCol] = '.';
            if ("up".equals(command)) {
                beeRow = beeRow - 1 < 0 ? matrix.length - 1 : beeRow - 1;
            } else if ("down".equals(command)) {
                beeRow = beeRow + 1 == matrix.length ? 0 : beeRow + 1;
            } else if ("left".equals(command)) {
                beeCol = beeCol - 1 < 0 ? matrix[beeRow].length - 1 : beeCol - 1;
            } else if ("right".equals(command)) {
                beeCol = beeCol + 1 == matrix[beeRow].length ? 0 : beeCol + 1;
            }
//                System.out.println("The bee got lost!");
//                break;

            if (matrix[beeRow][beeCol] == 'f') {
                pollinatedFlowers++;
            } else if (matrix[beeRow][beeCol] == 'O') {
                continue;
            }
            matrix[beeRow][beeCol] = 'B';
            command = scanner.nextLine();
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
}
