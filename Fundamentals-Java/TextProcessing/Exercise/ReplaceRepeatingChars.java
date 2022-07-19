package TextProcessing.Exercise;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String input = scanner.nextLine();

        sb.append(input.charAt(0));
        for (int i = 0; i < input.length() - 1; i++) {
            char currentSymbol = input.charAt(i);
            char nextSymbol = input.charAt(i + 1);
            if (currentSymbol != nextSymbol) {
                sb.append(nextSymbol);
            }

        }
        System.out.println(sb);
    }
}
