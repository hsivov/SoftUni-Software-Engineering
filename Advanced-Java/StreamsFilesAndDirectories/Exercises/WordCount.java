package StreamsFilesAndDirectories.Exercises;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws IOException {
        Scanner wordsScanner = new Scanner(new FileReader(
                "Advanced-Java/StreamsFilesAndDirectories/Exercises/Exercises Resources/words.txt"));

        String[] words = wordsScanner.nextLine().split(" ");
        Map<String, Integer> countWordsMap = new LinkedHashMap<>();

        for (String word : words) {
            countWordsMap.put(word, 0);
        }

        Scanner textScanner = new Scanner(new FileReader(
                "Advanced-Java/StreamsFilesAndDirectories/Exercises/Exercises Resources/text.txt"
        ));

        String singleWord = textScanner.next();

        while (textScanner.hasNext()) {
            if (countWordsMap.containsKey(singleWord)) {
                int occurrences = countWordsMap.get(singleWord);
                occurrences++;
                countWordsMap.put(singleWord, occurrences);
            }
            singleWord = textScanner.next();
        }
        PrintWriter pw = new PrintWriter("Advanced-Java/StreamsFilesAndDirectories/Exercises/Exercises Resources/results.txt");

        countWordsMap.forEach((key, value) -> pw.printf("%s - %d%n", key, value));

        wordsScanner.close();
        textScanner.close();
        pw.close();
    }
}
