package Lists.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> commandLine = Arrays.stream(input.split(" ")).collect(Collectors.toList());

            switch (commandLine.get(0)) {
                case "Contains":
                    if (numbers.contains(Integer.parseInt(commandLine.get(1)))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    switch (commandLine.get(1)) {
                        case "even":
                            for (int number : numbers) {
                                if (number % 2 == 0) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case "odd":
                            for (int number : numbers) {
                                if (number % 2 != 0) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (int number : numbers){
                        sum += number;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String condition = commandLine.get(1);
                    int conditionalNumber = Integer.parseInt(commandLine.get(2));
                    switch (condition){
                        //'<', '>', ">=", "<="
                        case "<":
                            for (int number : numbers){
                                if (number < conditionalNumber){
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">":
                            for (int number : numbers){
                                if (number > conditionalNumber){
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">=":
                            for (int number : numbers){
                                if (number >= conditionalNumber){
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case "<=":
                            for (int number : numbers){
                                if (number <= conditionalNumber){
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
