package Arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = 0;

        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i] % 2 == 0){
                sum += numArr[i];
            }
        }
        System.out.println(sum);
    }
}
