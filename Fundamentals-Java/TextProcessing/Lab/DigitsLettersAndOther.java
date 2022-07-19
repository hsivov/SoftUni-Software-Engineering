package TextProcessing.Lab;

import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder letterStr = new StringBuilder();
        StringBuilder digitStr = new StringBuilder();
        StringBuilder otherStr = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (Character.isDigit(symbol)){
                digitStr.append(symbol);
            } else if (Character.isLetter(symbol)) {
                letterStr.append(symbol);
            } else {
                otherStr.append(symbol);
            }
        }
        System.out.println(digitStr);
        System.out.println(letterStr);
        System.out.println(otherStr);
    }
}
