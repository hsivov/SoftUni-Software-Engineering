package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")){
            int commandNumber = Integer.parseInt(command.split(" ")[1]);
            if (command.contains("Delete")){
                integerList.removeIf(e -> e == commandNumber);
            } else if (command.contains("Insert")) {
                int index = Integer.parseInt(command.split(" ")[2]);
                integerList.add(index, commandNumber);
            }
            command = scanner.nextLine();
        }
        for (int number : integerList){
            System.out.print(number + " ");
        }
    }
}
