package OnlineExam6And7July2019;

import java.util.Locale;
import java.util.Scanner;

public class TheMostPowerfulWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        int maxPoints = 0;
        String mostPowerfulWord = "";

        while (!word.equals("End of words")) {

            int currentPoints = 0;
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                currentPoints += letter;
            }

            String lowWord = word.toLowerCase(Locale.ROOT);
            if (lowWord.charAt(0) == 'a' || lowWord.charAt(0) == 'e' || lowWord.charAt(0) == 'i' ||
                    lowWord.charAt(0) == 'o' || lowWord.charAt(0) == 'u' || lowWord.charAt(0) == 'y') {

                currentPoints = currentPoints * word.length();
            } else {
                currentPoints = currentPoints / word.length();
            }

            if (currentPoints > maxPoints) {
                maxPoints = currentPoints;
                mostPowerfulWord = word;
            }
            word = scanner.nextLine();
        }
        System.out.printf("The most powerful word is %s - %d", mostPowerfulWord, maxPoints);
    }
}
