package ProgrammingFundamentalsFinalExam;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        StringBuilder passBuilder = new StringBuilder(inputString);

        String commandsLine = scanner.nextLine();
        while (!commandsLine.equals("Done")) {
            String command = commandsLine.split(" ")[0];

            switch (command) {
                case "TakeOdd":
                    StringBuilder newPassBuilder = new StringBuilder();
                    for (int index = 0; index < passBuilder.length(); index++) {
                        if (index % 2 != 0) {
                            newPassBuilder.append(passBuilder.charAt(index));
                        }
                    }
                    passBuilder = new StringBuilder(newPassBuilder.toString());
                    System.out.println(passBuilder);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commandsLine.split(" ")[1]);
                    int length = Integer.parseInt(commandsLine.split(" ")[2]);
                    if (isValidIndexAndLength(index, length, passBuilder)) {
                        passBuilder.delete(index, index + length);
                    }
                    System.out.println(passBuilder);
                    break;
                case "Substitute":
                    String subString = commandsLine.split(" ")[1];
                    String substitute = commandsLine.split(" ")[2];
                    if (passBuilder.toString().contains(subString)) {
                        String updatedPass = passBuilder.toString().replace(subString, substitute);
                        passBuilder = new StringBuilder(updatedPass);
                        System.out.println(passBuilder);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            commandsLine = scanner.nextLine();
        }
        System.out.println("Your password is: " + passBuilder);
    }

    public static boolean isValidIndexAndLength(int index, int length, StringBuilder builder) {
        return index >= 0 && index < builder.length() && index + length <= builder.length();
    }
}
