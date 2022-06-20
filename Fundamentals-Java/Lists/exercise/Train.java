package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfWagons = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int capacity = Integer.parseInt(scanner.nextLine());

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("end")){
            String command = commandLine.split(" ")[0];

            if (command.equals("Add")){
                listOfWagons.add(Integer.parseInt(commandLine.split(" ")[1]));
            } else {
                for (int i = 0; i < listOfWagons.size(); i++) {
                    if (Integer.parseInt(command) <= (capacity - listOfWagons.get(i))) {
                        listOfWagons.set(i, Integer.parseInt(command) + listOfWagons.get(i));
                        break;
                    }
                }
            }
            commandLine = scanner.nextLine();
        }
        for (int wagon : listOfWagons){
            System.out.print(wagon + " ");
        }
    }
}
