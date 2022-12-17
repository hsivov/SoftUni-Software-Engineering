package Exams.JavaAdvancedRetakeExam_16December2020;

import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        int sellerRow = 0;
        int sellerCol = 0;
        int firstPillarRow = -1;
        int firstPillarCol = -1;
        int secondPillarRow = -1;
        int secondPillarCol = -1;
        int earnedMoney = 0;
        boolean isOutOfBakery = false;

        for (int r = 0; r < matrix.length; r++) {
            String row = scanner.nextLine();
            matrix[r] = row.toCharArray();
            if (row.contains("S")) {
                sellerRow = r;
                sellerCol = row.indexOf("S");
            }
            if (row.contains("O") && firstPillarRow == -1 && firstPillarCol == -1) {
                firstPillarRow = r;
                firstPillarCol = row.indexOf("O");
            } else if (row.contains("O")){
                secondPillarRow = r;
                secondPillarCol = row.indexOf("O");
            }
        }

        while (earnedMoney < 50) {

            String command = scanner.nextLine();

            matrix[sellerRow][sellerCol] = '-';

            if (command.equals("up") && sellerRow - 1 >= 0){
                sellerRow--;
            } else if (command.equals("down") && sellerRow + 1 < matrix.length) {
                sellerRow++;
            } else if (command.equals("left") && sellerCol - 1 >= 0) {
                sellerCol--;
            } else if (command.equals("right") && sellerCol + 1 < matrix[sellerRow].length) {
                sellerCol++;
            } else {
                isOutOfBakery = true;
                break;
            }

            char position = matrix[sellerRow][sellerCol];
            if (Character.isDigit(position)) {
                int price = Integer.parseInt(Character.toString(position));
                earnedMoney += price;
            } else if (position == 'O') {
                matrix[sellerRow][sellerCol] = '-';
                sellerRow = secondPillarRow;
                sellerCol = secondPillarCol;
            }
            matrix[sellerRow][sellerCol] = 'S';
        }
        String out = isOutOfBakery ? "Bad news, you are out of the bakery."
                : "Good news! You succeeded in collecting enough money!";

        System.out.println(out);
        System.out.printf("Money: %d%n", earnedMoney);

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
