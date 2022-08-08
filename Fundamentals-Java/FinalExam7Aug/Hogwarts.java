package FinalExam7Aug;

import java.util.Scanner;

public class Hogwarts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String spell = scanner.nextLine();

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Abracadabra")) {
            String command = commandLine.split(" ")[0];

            switch (command) {
                case "Abjuration":
                    spell = spell.toUpperCase();
                    System.out.println(spell);
                    break;
                case "Necromancy":
                    spell = spell.toLowerCase();
                    System.out.println(spell);
                    break;
                case "Illusion":
                    int index = Integer.parseInt(commandLine.split(" ")[1]);
                    char letter = commandLine.split(" ")[2].charAt(0);

                    if (index >= 0 && index < spell.length()){
                        StringBuilder spellBuilder = new StringBuilder(spell);

                        spellBuilder.setCharAt(index, letter);
                        spell = spellBuilder.toString();
                        System.out.println("Done!");
                    } else {
                        System.out.println("The spell was too weak.");
                    }
                    break;
                case "Divination":
                    String firstSubstring = commandLine.split(" ")[1];
                    String secondSubstring = commandLine.split(" ")[2];

                    spell = spell.replace(firstSubstring, secondSubstring);

                    System.out.println(spell);
                    break;
                case "Alteration":
                    String substring = commandLine.split(" ")[1];

                    spell = spell.replace(substring, "");

                    System.out.println(spell);
                    break;

                default:
                    System.out.println("The spell did not work!");
                    break;
            }
            commandLine = scanner.nextLine();
        }
    }
}
