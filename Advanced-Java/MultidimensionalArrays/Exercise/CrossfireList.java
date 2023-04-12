package MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrossfireList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        List<List<Integer>> matrixList = new ArrayList<>();

        fillMatrix(matrixList, rows, cols);

        String command = scanner.nextLine();

        while (!command.equals("Nuke it from orbit")) {

            int row = Integer.parseInt(command.split("\\s+")[0]);
            int col = Integer.parseInt(command.split("\\s+")[1]);
            int radius = Integer.parseInt(command.split("\\s+")[2]);


            for (int currentRow = row - radius; currentRow <= row + radius; currentRow++) {
                if (isInMatrix(currentRow, col, matrixList)&&currentRow!=rows) {
                    matrixList.get(currentRow).remove(col);
                }
            }


            for (int currentColumn = col + radius; currentColumn >= col - radius; currentColumn--) {
                if (isInMatrix(row, currentColumn, matrixList)) {
                    matrixList.get(row).remove(currentColumn);
                }
            }


            matrixList.removeIf(List::isEmpty);


            command = scanner.nextLine();
        }
        printMatrix(matrixList);


    }


    public static void fillMatrix(List<List<Integer>> matrixList, int rows, int cols) {
        int number = 1;

        for (int row = 0; row < rows; row++) {
            matrixList.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrixList.get(row).add(number++);

            }

        }

    }

    public static void printMatrix(List<List<Integer>> matrixList) {
        for (List<Integer> row : matrixList) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();


        }

    }

    private static boolean isInMatrix(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }
}
