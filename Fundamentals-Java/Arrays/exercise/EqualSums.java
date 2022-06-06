package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean isFound = false;

        for (int index = 0; index < array.length; index++) {
            int rightSum = 0;
            int leftSum = 0;

            for (int i = 0; i < index; i++) {
                rightSum += array[i];
            }
            for (int i = index + 1; i <= array.length - 1; i++) {
                leftSum += array[i];
            }
            if (rightSum == leftSum){
                System.out.println(index);
                isFound = true;
                break;
            }
        }
        if (!isFound){
            System.out.println("no");
        }
    }
}
