package BasicSyntaxConditionalStatementsLoops.more;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder reversedStr = new StringBuilder();

        String text = scanner.nextLine();

        for (int i = text.length()-1; i >= 0; i--) {
            char letter = text.charAt(i);
            reversedStr.append(letter);
        }
        System.out.println(reversedStr);
    }
}
