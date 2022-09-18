package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
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

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.offer(input[i]);
        }

        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        if (queue.isEmpty()){
            System.out.println("0");
        } else if (queue.contains(x)) {
            System.out.println("true");
        } else {
            for (Integer integer : queue) {
                if (integer < minElement) {
                    minElement = integer;
                }
            }
            System.out.println(minElement);
        }
    }
}
