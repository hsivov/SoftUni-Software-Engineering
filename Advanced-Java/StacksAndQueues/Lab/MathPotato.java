package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        int count = 0;

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child : children) {
            queue.offer(child);
        }

        while (queue.size() > 1) {
            boolean isPrime = true;
            count++;

            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (count == 1) {
                isPrime = false;
            }
            for (int j = 2; j <= count / 2; j++) {
                if (count % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
        }
        System.out.println("Last is " + queue.poll());
    }
}
