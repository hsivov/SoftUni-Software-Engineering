package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraysCount = scanner.nextInt();
        int sizeOfArray = scanner.nextInt();

        int[][] firstArr = new int[arraysCount][sizeOfArray];

        for (int r = 0; r < arraysCount; r++) {
            for (int c = 0; c < sizeOfArray; c++) {
                firstArr[r][c] = scanner.nextInt();
            }
        }
        arraysCount = scanner.nextInt();
        sizeOfArray = scanner.nextInt();

        int[][] secondArr = new int[arraysCount][sizeOfArray];

        for (int r = 0; r < arraysCount; r++) {
            for (int c = 0; c < sizeOfArray; c++) {
                secondArr[r][c] = scanner.nextInt();
            }
        }
        boolean areEqual = firstArr.length == secondArr.length && areArraysAreEqual(firstArr, secondArr);

        System.out.println(areEqual ? "equal" : "not equal");
    }
    private static boolean areArraysAreEqual (int[][] firstArray, int[][] secondArray) {

        for (int r = 0; r < firstArray.length; r++) {

            int[] firstArr = firstArray[r];
            int[] secondArr = secondArray[r];

            if (firstArr.length != secondArr.length){
                return false;
            }
            for (int i = 0; i < firstArr.length; i++) {
                int firstNum = firstArr[i];
                int secondNum = secondArr[i];

                if (firstNum != secondNum){
                    return false;
                }
            }
        }
        return true;
    }
}
