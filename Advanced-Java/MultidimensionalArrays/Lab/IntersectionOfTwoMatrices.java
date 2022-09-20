package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] arrayA = new char[rows][cols];
        char[][] arrayB = new char[rows][cols];
        char[][] arrayC = new char[rows][cols];

        readArray(scanner, arrayA);
        readArray(scanner, arrayB);

        for (int r = 0; r < arrayA.length; r++) {
            for (int c = 0; c < arrayA[r].length; c++) {
                if (arrayA[r][c] == arrayB[r][c]) {
                    arrayC[r][c] = arrayA[r][c];
                } else {
                    arrayC[r][c] = '*';
                }
            }
        }

        for (char[] chars : arrayC) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    private static void readArray(Scanner scanner, char[][] arrayA) {
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
    }
}
