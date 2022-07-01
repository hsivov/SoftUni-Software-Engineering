package MidExam26June;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Finish")){
            String command = commandLine.split(" ")[0];
            int value = Integer.parseInt(commandLine.split(" ")[1]);

            switch (command){
                case "Add":
                    numbers.add(value);
                    break;
                case "Remove":
                    for (int index = 0; index < numbers.size(); index++) {
                        if (numbers.get(index) == value){
                            numbers.remove(index);
                            break;
                        }
                    }
                    break;
                case "Replace":
                    int replacement = Integer.parseInt(commandLine.split(" ")[2]);

                    if (numbers.contains(value)){
                        numbers.set(numbers.indexOf(value), replacement);
                    }
                    break;
                case "Collapse":
                    numbers.removeIf(integer -> integer < value);

                    break;
            }

            commandLine = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
