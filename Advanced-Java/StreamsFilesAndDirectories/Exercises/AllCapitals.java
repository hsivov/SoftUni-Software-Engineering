package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AllCapitals {

    public static void main(String[] args) throws IOException {

        PrintWriter printWriter = new PrintWriter("Advanced-Java/Streams_FilesAndDirectories/Exercises/Exercises Resources/output.txt");
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("Advanced-Java/Streams_FilesAndDirectories/Exercises/Exercises Resources/input.txt"));

        bufferedReader.lines().forEach(line -> printWriter.println(line.toUpperCase()));

        printWriter.close();
        bufferedReader.close();
    }
}
