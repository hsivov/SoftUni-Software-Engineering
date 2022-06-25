package MidExams;

import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> chest = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Yohoho!")) {
            String[] commandParts = commandLine.split(" ");
            String command = commandParts[0];

            switch (command) {
                case "Loot":
                    for (int index = 1; index <= commandParts.length - 1; index++) {
                        if (!chest.contains(commandParts[index])) {
                            chest.add(0, commandParts[index]);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(commandParts[1]);
                    if (chest.size() - 1 >= index && index >= 0) {
                        chest.add(chest.get(index));
                        chest.remove(index);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(commandParts[1]);
                    int start = chest.size() - count;
                    List<String> stolenItems = new ArrayList<>();

                    if (start > 0) {
                        for (int i = 0; i < count; i++) {
                            String item = chest.get(start);
                            stolenItems.add(item);
                            chest.remove(start);
                        }
                    } else {
                        stolenItems.addAll(chest);
                        chest.clear();
                    }

                    System.out.println(stolenItems.toString().replaceAll("[\\[\\]]", ""));
                    break;
            }
            commandLine = scanner.nextLine();
        }
        if (!chest.isEmpty()) {
            int countLength = 0;
            for (String item : chest) {
                countLength += item.length();
            }
            double gain = countLength * 1.00 / chest.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", gain);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
