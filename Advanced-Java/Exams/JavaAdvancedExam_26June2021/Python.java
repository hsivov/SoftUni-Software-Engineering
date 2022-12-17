package Exams.JavaAdvancedExam_26June2021;

import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        int pythonRow = 0;
        int pythonCol = 0;
        int pythonLength = 1;
        int countFood = 0;
        boolean isWin = false;

        String[] commands = scanner.nextLine().split(", ");

        for (int r = 0; r < matrix.length; r++) {
            String row = scanner.nextLine().replaceAll("\\s+", "");
            matrix[r] = row.toCharArray();
            if (row.contains("s")) {
                pythonRow = r;
                pythonCol = row.indexOf('s');
            }

            for (char c : row.toCharArray()) {
                if (c == 'f') {
                    countFood++;
                }
            }
        }

        for (String command : commands) {

            matrix[pythonRow][pythonCol] = '*';

            if (command.equals("up") && pythonRow - 1 >= 0) {
                pythonRow--;
            } else if (command.equals("down") && pythonRow + 1 < matrix.length) {
                pythonRow++;
            } else if (command.equals("right") && pythonCol + 1 < matrix[pythonRow].length) {
                pythonCol++;
            } else if (command.equals("left") && pythonCol - 1 >= 0) {
                pythonCol--;
            } else {
                if ((command.equals("up") || command.equals("down")) && (pythonRow - 1 < 0 || pythonRow + 1 == matrix.length)) {
                    pythonRow = pythonRow - 1 < 0
                            ? matrix.length - 1
                            : 0;
                } else if ((command.equals("left") || command.equals("right")) && (pythonCol - 1 < 0 || pythonCol + 1 == matrix[pythonRow].length)) {
                    pythonCol = pythonCol - 1 < 0
                            ? matrix[pythonRow].length - 1
                            : 0;
                }
            }

            if (matrix[pythonRow][pythonCol] == 'f') {
                pythonLength++;
                countFood--;
                if (countFood == 0) {
                    isWin = true;
                    break;
                }
            }
            if (matrix[pythonRow][pythonCol] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
            matrix[pythonRow][pythonCol] = 's';
        }
        String output = isWin ? String.format("You win! Final python length is %d", pythonLength)
                : String.format("You lose! There is still %d food to be eaten.", countFood);

        System.out.println(output);
    }
}
