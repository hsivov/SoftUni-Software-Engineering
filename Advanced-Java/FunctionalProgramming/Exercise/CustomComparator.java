package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> comparator = (first, second) -> {

            if (first % 2 == 0 && second % 2 != 0) {
                //първото е четно
                //второто е нечетно
                return -1;
            } else if (first % 2 != 0 && second % 2 == 0) {
                //първото е нечетно
                //второто е четно
                return 1;
            }
            //и двете са четни
            //и двете са нечетни
            return first.compareTo(second);
        };
        Arrays.sort(numbers, comparator);

        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}
