package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays
                .stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int maxLength = 1;
        int sequenceStartIndex = 0;
        int length = 1;

        for (int i = 1; i <= array.length - 1; i++) {
            if (array[i] == array[i - 1]) {
                length++;
            } else {
                length = 1;
            }
            if (length > maxLength) {
                maxLength = length;
                sequenceStartIndex = i - length + 1;
            }
        }
        for (int i = 0; i < maxLength; i++) {
            System.out.print(array[i + sequenceStartIndex] + " ");
        }
    }
}
