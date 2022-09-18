package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = tokens[0];
        int s = tokens[1];
        int x = tokens[2];

        int minElement = Integer.MAX_VALUE;

        int[] input = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stack.push(input[i]);
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (stack.isEmpty()){
            System.out.println("0");
        } else if (stack.contains(x)) {
            System.out.println("true");
        } else {
            for (Integer integer : stack) {
                if (integer < minElement) {
                    minElement = integer;
                }
            }
            System.out.println(minElement);
        }
    }
}
