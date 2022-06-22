package MidExams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> array = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("end")){
            String command = commandLine.split(" ")[0];

            switch (command) {
                case "swap":
                    int index1 = Integer.parseInt(commandLine.split(" ")[1]);
                    int index2 = Integer.parseInt(commandLine.split(" ")[2]);

                    Collections.swap(array, index1, index2);
                    break;
                case "multiply":
                    int multiplyIndex1 = Integer.parseInt(commandLine.split(" ")[1]);
                    int multiplyIndex2 = Integer.parseInt(commandLine.split(" ")[2]);

                    int product = array.get(multiplyIndex1) * array.get(multiplyIndex2);
                    array.set(multiplyIndex1, product);
                    break;
                case "decrease":
                    array.replaceAll(integer -> integer - 1);
                    break;
            }

            commandLine = scanner.nextLine();
        }
        System.out.println(array.toString().replaceAll("[\\[\\]]", ""));
    }
}
