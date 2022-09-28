package StreamsFilesAndDirectories.Exercises;

import java.io.*;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("Advanced-Java/Streams_FilesAndDirectories/Exercises/Exercises Resources/input.txt");

        PrintWriter printWriter = new PrintWriter("Advanced-Java/Streams_FilesAndDirectories/Exercises/Exercises Resources/output.txt");

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        int oneByte = fileReader.read();

        while (oneByte >= 0) {
            char symbol = (char) oneByte;

            if (isVowel(symbol)) {
                vowels++;
            } else if (isPunctuation(symbol)) {
                punctuation++;
            } else if (!Character.isWhitespace(symbol)) {
                consonants++;
            }
            oneByte = fileReader.read();
        }
        printWriter.println("Vowels: " + vowels);
        printWriter.println("Consonants: " + consonants);
        printWriter.println("Punctuation: " + punctuation);

        fileReader.close();
        printWriter.close();
    }

    private static boolean isPunctuation(char symbol) {
        return symbol == ',' || symbol == '.' || symbol == '!' || symbol == '?';
    }

    private static boolean isVowel(char symbol) {
        return symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u';
    }
}
