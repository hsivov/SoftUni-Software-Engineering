package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("Advanced-Java/Streams_FilesAndDirectories/Exercises/Exercises Resources/input.txt"));

        String line = bufferedReader.readLine();

        while (line != null) {
            int sum = 0;

            char[] charactersFromLine = line.toCharArray();
            for (char character : charactersFromLine) {
                sum += character;
            }
            System.out.println(sum);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }
}
