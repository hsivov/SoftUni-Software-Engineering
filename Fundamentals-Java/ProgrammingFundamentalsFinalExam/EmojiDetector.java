package ProgrammingFundamentalsFinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern patternEmoji = Pattern.compile("(:{2}|\\*{2})[A-Z][a-z]{2,}\\1");
        Pattern patternDigits = Pattern.compile("\\d");

        Matcher matcherEmoji = patternEmoji.matcher(text);
        Matcher matcherDigits = patternDigits.matcher(text);
        List<String> emojiList = new ArrayList<>();

        int coolThreshold = 1;
        while (matcherDigits.find()) {
            int digit = Integer.parseInt(matcherDigits.group());
            coolThreshold *= digit;
        }
        int countOfAllEmojis = 0;
        while (matcherEmoji.find()) {
            countOfAllEmojis++;
            String emoji = matcherEmoji.group();

            int coolness = 0;
            String emojiLetters = emoji.replaceAll("[*:]", "");
            for (char symbol : emojiLetters.toCharArray()) {
                coolness += symbol;
            }
            if (coolness > coolThreshold) {
                emojiList.add(emoji);
            }
        }
        System.out.println("Cool threshold: " + coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", countOfAllEmojis);

        emojiList.forEach(System.out::println);
    }
}
