package MidExams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("End")){
            String command = commandLine.split(" ")[0];
            int index = Integer.parseInt(commandLine.split(" ")[1]);
            int value = Integer.parseInt(commandLine.split(" ")[2]);

            switch (command) {
                case "Shoot":
                    if (isValidIndex(targets, index)){
                        int target = targets.get(index) - value;
                        targets.set(index, target);
                        if (target <= 0){
                            targets.remove(index);
                        }
                    }
                    break;
                case "Add":
                    if (isValidIndex(targets, index)){
                        targets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    boolean isValidStrike = targets.size() - 1 >= index + value && index - value >= 0;

                    if (isValidStrike){
                        int start = index - value;
                        int end = index + value;

                        if (end >= start) {
                            targets.subList(start, end + 1).clear();
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }

            commandLine = scanner.nextLine();
        }
        printTargetList(targets);
    }
    public static boolean isValidIndex (List<Integer> list, int index){
        return index <= list.size() -1 && index >= 0;
    }

    public static void printTargetList (List<Integer> list){
        List<String> stringList = new ArrayList<>();

        for (int target : list){
            stringList.add(String.valueOf(target));
        }

        System.out.println(String.join("|", stringList));
    }
}
