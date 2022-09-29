package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> isEven = n -> n % 2 == 0;

        String even = numbers.stream()
                .filter(isEven)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(even);

        String evenSorted = numbers.stream()
                .filter(isEven)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(evenSorted);
    }
}
