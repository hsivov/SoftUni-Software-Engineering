package ProgrammingFundamentalsFinalExam;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String inputCommands = scanner.nextLine();
        while (!inputCommands.equals("Decode")) {
            String[] token = inputCommands.split("\\|");
            String command = token[0];

            switch (command) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(token[1]);
                    String substring = message.substring(0, numberOfLetters);
                    message = message.replace(substring, "");
                    message = message + substring;
                    break;
                case "Insert":
                    int index = Integer.parseInt(token[1]);
                    String value = token[2];
                    String firstPartSubstring = message.substring(0,index);
                    String secondPartSubstring = message.substring(index);
                    message = firstPartSubstring + value + secondPartSubstring;
                    break;
                case "ChangeAll":
                    String substringToChange = token[1];
                    String replacement = token[2];

                    message = message.replace(substringToChange, replacement);
                    break;
            }
            inputCommands = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + message);
    }
}
