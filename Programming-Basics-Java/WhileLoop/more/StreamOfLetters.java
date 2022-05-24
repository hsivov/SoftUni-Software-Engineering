package WhileLoop.more;

import java.util.Scanner;

public class StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = "";

        boolean isLetterCReceived = false;
        boolean isLetterOReceived = false;
        boolean isLetterNReceived = false;
        String input = scanner.nextLine();

        while (!input.equals("End")) {

            char letter = input.charAt(0);

            if ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')) {

                if (letter == 'c' && !isLetterCReceived) {
                    isLetterCReceived = true;

                } else if (letter == 'o' && !isLetterOReceived) {
                    isLetterOReceived = true;

                } else if (letter == 'n' && !isLetterNReceived) {
                    isLetterNReceived = true;

                } else {
                    word += letter;
                }
            }

            if (isLetterCReceived && isLetterOReceived && isLetterNReceived) {
                isLetterCReceived = false;
                isLetterOReceived = false;
                isLetterNReceived = false;
                System.out.print(word + " ");
                word = "";
            }
            input = scanner.nextLine();
        }
    }
}
