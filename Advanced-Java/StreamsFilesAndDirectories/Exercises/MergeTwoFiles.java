package StreamsFilesAndDirectories.Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        Path firstFile = Paths.get("Advanced-Java/StreamsFilesAndDirectories/Exercises/Exercises Resources/inputOne.txt");
        List<String> firstFileLines = Files.readAllLines(firstFile);

        Path secondFile = Paths.get("Advanced-Java/StreamsFilesAndDirectories/Exercises/Exercises Resources/inputTwo.txt");
        List<String> secondFileLines = Files.readAllLines(secondFile);

        Path output = Paths.get("Advanced-Java/StreamsFilesAndDirectories/Exercises/Exercises Resources/output.txt");
        Files.write(output, firstFileLines, StandardOpenOption.APPEND);
        Files.write(output, secondFileLines, StandardOpenOption.APPEND);
    }
}
