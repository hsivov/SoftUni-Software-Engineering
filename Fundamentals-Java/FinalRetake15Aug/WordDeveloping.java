package FinalRetake15Aug;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordDeveloping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringToModify = "";
        List<Integer> occurrences = new ArrayList<>();

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("End")) {
            String command = commandLine.split(" ")[0];

            switch (command) {
                case "Add":
                    String substringToAdd = commandLine.split(" ")[1];
                    stringToModify = stringToModify + substringToAdd;
                    break;
                case "Upgrade":
                    char symbol = commandLine.split(" ")[1].charAt(0);
                    stringToModify = stringToModify.replace(symbol, (char) (symbol + 1));
                    break;
                case "Print":
                    System.out.println(stringToModify);
                    break;
                case "Index":
                    char charToFind = commandLine.split(" ")[1].charAt(0);

                    for (int i = 0; i < stringToModify.length(); i++) {
                        if (stringToModify.charAt(i) == charToFind) {
                            occurrences.add(i);
                        }
                    }

                    if (occurrences.isEmpty()) {
                        System.out.println("None");
                    } else {
                        occurrences.forEach(e -> System.out.printf("%d ", e));
                        System.out.println();
                    }
                    break;
                case "Remove":
                    String substringToRemove = commandLine.split(" ")[1];
                    stringToModify = stringToModify.replace(substringToRemove, "");
                    break;
            }
            commandLine = scanner.nextLine();
        }
    }
}
