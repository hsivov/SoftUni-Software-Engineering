package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> journal = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Craft!")){
            String command = commandLine.split(" - ")[0];
            String item = commandLine.split(" - ")[1];

            switch (command) {
                case "Collect":
                if (!journal.contains(item)) {
                    journal.add(item);
                }
                break;
                case "Drop":
                    journal.remove(item);
                    break;
                case "Combine Items":
                    String oldItem = item.split(":")[0];
                    String newItem = item.split(":")[1];

                    if (journal.contains(oldItem)){
                        int index = journal.indexOf(oldItem);
                        journal.add(index + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (journal.contains(item)) {
                        int indexToRemove = journal.indexOf(item);
                        journal.add(item);
                        journal.remove(indexToRemove);
                    }
                    break;
            }
            commandLine = scanner.nextLine();
        }

        System.out.println(journal.toString().replaceAll("[\\[\\]]", ""));
    }
}
