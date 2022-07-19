package TextProcessing.Exercise;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder text = new StringBuilder(input);

        int totalStrength = 0;
        for (int position = 0; position < text.length(); position++) {
            char currentSymbol = text.charAt(position);

            if (currentSymbol == '>'){
                int explosionStrength = Integer.parseInt("" + text.charAt(position + 1));
                totalStrength += explosionStrength;
            } else if (totalStrength > 0) {
                text.deleteCharAt(position);
                totalStrength--;
                position--;
            }
        }
        System.out.println(text);
    }
}
