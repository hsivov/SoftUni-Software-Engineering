package StreamsFilesAndDirectories.Exercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAPicture {
    public static void main(String[] args) throws IOException {

        String inputPath = "Advanced-Java/StreamsFilesAndDirectories/Exercises/Exercises Resources/picture.jpg";
        String outputPath = "Advanced-Java/StreamsFilesAndDirectories/Exercises/Exercises Resources/picture-copy.jpg";

        FileInputStream fis = new FileInputStream(inputPath);
        FileOutputStream fos = new FileOutputStream(outputPath);

        byte[] buffer = new byte[1024];

        while (fis.read(buffer) != -1) {
            fos.write(buffer);
        }
        fis.close();
        fos.close();
    }
}
