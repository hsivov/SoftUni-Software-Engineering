package ProgrammingFundamentalsFinalExam;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();

        String instruction = scanner.nextLine();
        while (!instruction.equals("Generate")) {
            String command = instruction.split(">>>")[0];
            String substring = "";
            int startIndex = 0;
            int endIndex = 0;

            switch (command) {
                case "Contains":
                    substring = instruction.split(">>>")[1];
                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperOrLower = instruction.split(">>>")[1];
                    startIndex = Integer.parseInt(instruction.split(">>>")[2]);
                    endIndex = Integer.parseInt(instruction.split(">>>")[3]);

                    substring = activationKey.substring(startIndex, endIndex);
                    if (upperOrLower.equals("Upper")) {
                        activationKey = activationKey.replace(substring, substring.toUpperCase());
                    } else if (upperOrLower.equals("Lower")) {
                        activationKey = activationKey.replace(substring, substring.toLowerCase());
                    }
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(instruction.split(">>>")[1]);
                    endIndex = Integer.parseInt(instruction.split(">>>")[2]);

                    substring = activationKey.substring(startIndex, endIndex);

                    activationKey = activationKey.replace(substring, "");
                    System.out.println(activationKey);
                    break;
            }
            instruction = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + activationKey);
    }
}
