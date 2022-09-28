package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNumbers {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(
                "Advanced-Java/Streams_FilesAndDirectories/Exercises/Exercises Resources/inputLineNumbers.txt"));

        PrintWriter pw = new PrintWriter("Advanced-Java/Streams_FilesAndDirectories/Exercises/Exercises Resources/output.txt");

        String line = br.readLine();
        int count = 1;

        while (line != null) {
            pw.println(count + ". " + line);
            line = br.readLine();
            count++;
        }
        br.close();
        pw.close();
    }
}
