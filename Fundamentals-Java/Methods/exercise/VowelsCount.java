package Methods.exercise;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine().toLowerCase();

        countVowels(inputText);
    }

    private static void countVowels (String text){
        int count = 0;
        for (char symbol: text.toCharArray()) {
            if (symbol == 'a' || symbol == 'e' || symbol=='u' || symbol=='i' || symbol == 'o'){
                count++;
            }
        }
        System.out.println(count);
    }
}
