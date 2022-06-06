package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int index = 0; index < array.length; index++) {
            int currentEl = array[index];
            boolean isTop = true;
            for (int i = index + 1; i < array.length; i++) {
                if (currentEl <= array[i]) {
                    isTop = false;
                    break;
                }
            }
            if (isTop) {
                System.out.print(currentEl + " ");
            }
        }
    }
}
