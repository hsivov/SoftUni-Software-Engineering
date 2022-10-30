package ExamPreparation.JavaAdvancedRetakeExam_18August2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class TreasureHunt {

    private static int playerRow;
    private static int playerCol;
    private static String command;
    private static final ArrayDeque<String> steps = new ArrayDeque<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        char[][] matrix = new char[size[0]][size[1]];

        for (int r = 0; r < matrix.length; r++) {
            String row = scanner.nextLine().replaceAll(" ", "");
            matrix[r] = row.toCharArray();

            if (row.contains("Y")) {
                playerRow = r;
                playerCol = row.indexOf("Y");
            }
        }

        command = scanner.nextLine();
        while (!command.equals("Finish")) {

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
            command = scanner.nextLine();
        }
        if (matrix[playerRow][playerCol] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + String.join(", ", steps));
        } else {
            System.out.println("The map is fake!");
        }
    }

    private static void movePlayer(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = playerRow + rowMutator;
        int nextCol = playerCol + colMutator;

        if (!isOutOfBounds(matrix, nextRow, nextCol)) {

            if (matrix[nextRow][nextCol] == 'T') {
                return;
            } else if (matrix[nextRow][nextCol] == 'X') {
                matrix[playerRow][playerCol] = '-';
                playerRow = nextRow;
                playerCol = nextCol;
                steps.offer(command);
                return;
            }

            if (matrix[nextRow][nextCol] != 'X') {
                matrix[nextRow][nextCol] = 'Y';
            }
            if (matrix[playerRow][playerCol] != 'X') {
                matrix[playerRow][playerCol] = '-';
            }
            steps.offer(command);
            playerRow = nextRow;
            playerCol = nextCol;
        }
    }

    private static boolean isOutOfBounds(char[][] matrix, int nextRow, int nextCol) {
        return (nextRow < 0 || nextRow >= matrix.length) || (nextCol < 0 || nextCol >= matrix[nextRow].length);
    }
}
