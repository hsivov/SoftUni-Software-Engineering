package FunctionalProgramming.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Predicate<String> isStartingWithUppercase = w -> Character.isUpperCase(w.charAt(0));

        ArrayDeque<String> queue = new ArrayDeque<>();

        Arrays.stream(words)
                .filter(isStartingWithUppercase)
                .forEach(queue::offer);

        System.out.println(queue.size());

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
