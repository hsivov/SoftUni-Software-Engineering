package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> stringList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("3:1")) {
            String command = commandLine.split(" ")[0];

            switch (command) {
                case "merge":
                    int startIndex = Integer.parseInt(commandLine.split(" ")[1]);
                    int endIndex = Integer.parseInt(commandLine.split(" ")[2]);
                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    if (endIndex > stringList.size() - 1) {
                        endIndex = stringList.size() - 1;
                    }
                    boolean isValidIndexes = startIndex <= stringList.size() - 1 && endIndex >= 0 && startIndex < endIndex;

                    if (isValidIndexes) {
                        String mergeString = "";
                        for (int i = startIndex; i <= endIndex; i++) {
                            mergeString += stringList.get(i);

                        }
                        for (int i = startIndex; i <= endIndex; i++) {
                            stringList.remove(startIndex);
                        }
                        stringList.add(startIndex, mergeString);
                    }
                    break;
                case "divide":
                    int index = Integer.parseInt(commandLine.split(" ")[1]);
                    int parts = Integer.parseInt(commandLine.split(" ")[2]);
                    String elementToDivide = stringList.get(index);
                    stringList.remove(index);

                    int partSize = elementToDivide.length() / parts;
                    int startIndexOfSubstring = 0;

                    for (int part = 1; part < parts; part++) {
                        stringList.add(index, elementToDivide.substring(startIndexOfSubstring, startIndexOfSubstring + partSize));

                        index++;
                        startIndexOfSubstring += partSize;
                    }
                    stringList.add(index, elementToDivide.substring(startIndexOfSubstring));
                    break;
            }
            commandLine = scanner.nextLine();
        }
        System.out.println(String.join(" ", stringList));
    }
}
