package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[][] matrix = new String[dimensions[0]][dimensions[1]];


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int offset = 97;
                char firstAndLastLetters = (char) (row + offset);
                char middleLetter = (char) (row + col + offset);

                String element = "" + firstAndLastLetters + middleLetter + firstAndLastLetters;

                matrix[row][col] = element;
            }
        }
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}
