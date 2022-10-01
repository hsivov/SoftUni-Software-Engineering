package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int range = Integer.parseInt(scanner.nextLine());
        List<Integer> numbersToDivideTo = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> isDivisible = number -> {
            for (Integer numberToDivide : numbersToDivideTo) {
                if (number % numberToDivide != 0) {
                    return false;
                }
            }
            return true;
        };
        IntStream.rangeClosed(1, range)
                .boxed()
                .filter(isDivisible)
                .forEach(e -> System.out.print(e + " "));
    }
}
