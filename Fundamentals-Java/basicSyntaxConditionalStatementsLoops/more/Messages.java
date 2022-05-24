package basicSyntaxConditionalStatementsLoops.more;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commands; i++) {

            String input = scanner.nextLine();
            int index;
            int numberOfDigits = input.length();
            int mainDigit = Integer.parseInt(input) % 10;
            int offset = (mainDigit - 2) * 3;
            if (mainDigit == 0) {
                index = -65;
            } else if (mainDigit == 8 || mainDigit == 9) {
                index = (offset + numberOfDigits);
            } else {
                index = (offset + numberOfDigits - 1);
            }
            System.out.printf("%c", index + 97);
        }
    }
}
