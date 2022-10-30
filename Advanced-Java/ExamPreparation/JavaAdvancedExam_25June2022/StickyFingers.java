package ExamPreparation.JavaAdvancedExam_25June2022;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[size][size];

        int dillingerRow = -1;
        int dillingerCol = -1;
        int pocket = 0;
        boolean hasCaught = false;

        for (int r = 0; r < matrix.length; r++) {
            String row = scanner.nextLine().replaceAll(" ", "");
            matrix[r] = row.toCharArray();

            if (row.contains("D")) {
                dillingerRow = r;
                dillingerCol = row.indexOf("D");
            }
        }

        for (String command : commands) {

            matrix[dillingerRow][dillingerCol] = '+';
            if ("up".equals(command) && dillingerRow - 1 >= 0) {
                dillingerRow--;
            } else if ("down".equals(command) && dillingerRow + 1 < matrix.length) {
                dillingerRow++;
            } else if ("left".equals(command) && dillingerCol - 1 >= 0) {
                dillingerCol--;
            } else if ("right".equals(command) && dillingerCol + 1 < matrix[dillingerRow].length) {
                dillingerCol++;
            } else {
                System.out.println("You cannot leave the town, there is police outside!");
            }

            if (matrix[dillingerRow][dillingerCol] == '$') {
                int stolenMoney = dillingerRow * dillingerCol;
                pocket += stolenMoney;
                System.out.printf("You successfully stole %d$.%n", stolenMoney);
            } else if (matrix[dillingerRow][dillingerCol] == 'P') {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", pocket);
                matrix[dillingerRow][dillingerCol] = '#';
                hasCaught = true;
                break;
            }
            matrix[dillingerRow][dillingerCol] = 'D';
        }

        if (!hasCaught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", pocket);
        }

        for (char[] row : matrix) {
            for (char aChar : row) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}
