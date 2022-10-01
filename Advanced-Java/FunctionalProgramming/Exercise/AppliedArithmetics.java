package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Consumer<List<Integer>> add = integers -> integers.replaceAll(integer -> integer + 1);
        Consumer<List<Integer>> multiply = integers -> integers.replaceAll(integer -> integer * 2);
        Consumer<List<Integer>> subtract = integers -> integers.replaceAll(integer -> integer - 1);
        Consumer<List<Integer>> print = integers -> integers.forEach(integer -> System.out.print(integer + " "));

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            switch (input) {
                case "add":
                    add.accept(integerList);
                    break;
                case "multiply":
                    multiply.accept(integerList);
                    break;
                case "subtract":
                    subtract.accept(integerList);
                    break;
                case "print":
                    print.accept(integerList);
                    System.out.println();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            input = scanner.nextLine();
        }
    }
}
