package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String commandLine = scanner.nextLine();
        int moves = 0;

        while (!commandLine.equals("end")) {
            moves++;
            int number1 = Integer.parseInt(commandLine.split(" ")[0]);
            int number2 = Integer.parseInt(commandLine.split(" ")[1]);

            boolean isLegalMove = elements.size() > number1 && elements.size() > number2 && number1 != number2 && number1 >= 0 && number2 >= 0;

            if (isLegalMove) {

                if (match(elements, number1, number2)) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", elements.get(number1));

                    if (number1 < number2) {
                        elements.remove(number2);
                        elements.remove(number1);
                    } else {
                        elements.remove(number1);
                        elements.remove(number2);
                    }
                    if (elements.isEmpty()) {
                        System.out.printf("You have won in %d turns!", moves);
                        return;
                    }
                } else {
                    System.out.println("Try again!");
                }
            } else {
                elements.add(elements.size() / 2, "-" + moves + "a");
                elements.add((elements.size() / 2) + 1, "-" + moves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            }

            commandLine = scanner.nextLine();
        }

        System.out.println("Sorry you lose :(");
        System.out.println(String.join(" ", elements));
    }

    public static boolean match(List<String> list, int index1, int index2) {
        return (list.get(index1).equals(list.get(index2)));
    }
}
