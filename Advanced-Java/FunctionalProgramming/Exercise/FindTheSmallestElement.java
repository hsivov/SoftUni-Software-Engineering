package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> minIndex = integers -> {
            int minElement = integers.stream().mapToInt(Integer::intValue).min().orElseThrow();
            return integers.lastIndexOf(minElement);
        };
        System.out.println(minIndex.apply(integerList));
    }
}
