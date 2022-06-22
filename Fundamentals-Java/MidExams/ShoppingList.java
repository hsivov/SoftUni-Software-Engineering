package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> groceries = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Go Shopping!")){
            String command = commandLine.split(" ")[0];
            String item = commandLine.split(" ")[1];

            switch (command){
                case "Urgent":
                    if (!groceries.contains(item)){
                        groceries.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    groceries.remove(item);
                    break;
                case "Correct":
                    String oldItem = commandLine.split(" ")[1];
                    String newItem = commandLine.split(" ")[2];

                    if (groceries.contains(oldItem)){
                        int indexOfOldItem = groceries.indexOf(oldItem);
                        groceries.set(indexOfOldItem, newItem);
                    }
                    break;
                case "Rearrange":
                    if (groceries.contains(item)) {
                        int indexToRemove = groceries.indexOf(item);
                        groceries.add(item);
                        groceries.remove(indexToRemove);
                    }
                    break;
            }
            commandLine = scanner.nextLine();
        }
        System.out.println(groceries.toString().replaceAll("[\\[\\]]", ""));
    }
}
