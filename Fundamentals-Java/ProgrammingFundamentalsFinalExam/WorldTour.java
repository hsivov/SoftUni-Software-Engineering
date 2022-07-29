package ProgrammingFundamentalsFinalExam;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        StringBuilder stopsBuilder = new StringBuilder(stops);

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Travel")) {
            String command = commandLine.split(":")[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(commandLine.split(":")[1]);
                    String destination = commandLine.split(":")[2];
                    if (isValidIndex(index, stopsBuilder)) {
                        stopsBuilder.insert(index, destination);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandLine.split(":")[1]);
                    int endIndex = Integer.parseInt(commandLine.split(":")[2]);
                    if (isValidIndex(startIndex, stopsBuilder) && isValidIndex(endIndex, stopsBuilder)){
                        stopsBuilder.delete(startIndex, endIndex + 1);
                    }
                    break;
                case "Switch":
                    String oldStop = commandLine.split(":")[1];
                    String newStop = commandLine.split(":")[2];
                    if (stopsBuilder.toString().contains(oldStop)){
                        String updatedText = stopsBuilder.toString().replace(oldStop, newStop);
                        stopsBuilder = new StringBuilder(updatedText);
                    }
                    break;
            }
            System.out.println(stopsBuilder);
            commandLine = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", stopsBuilder);
    }
    public static boolean isValidIndex (int index, StringBuilder builder){
        return index >= 0 && index < builder.length();
    }
}
