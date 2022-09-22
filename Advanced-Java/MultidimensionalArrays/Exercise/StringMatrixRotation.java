package MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> wordList = new ArrayList<>();

        String rotation = scanner.nextLine();
        int rotationNumber = Integer.parseInt(rotation.split("[()]")[1]);
        int angle = rotationNumber % 360;
        String input = scanner.nextLine();
        int maxLength = 0;

        while (!input.equals("END")) {

            if (input.length() > maxLength){
                maxLength = input.length();
            }
            wordList.add(input);
            input = scanner.nextLine();
        }

        int rows = wordList.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String currentWord = wordList.get(row);
            for (int col = 0; col < matrix[row].length; col++) {

                if (col < currentWord.length()) {
                    char currentSymbol = currentWord.charAt(col);
                    matrix[row][col] = currentSymbol;
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        switch (angle) {
            case 0:
                for (char[] chars : matrix) {
                    for (char aChar : chars) {
                        System.out.print(aChar);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}
