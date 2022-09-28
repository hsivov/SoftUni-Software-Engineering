package StreamsFilesAndDirectories.Exercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) throws IOException {

        String[] filesToAdd = {
                "Advanced-Java/StreamsFilesAndDirectories/Exercises/Exercises Resources/input.txt",
                "Advanced-Java/StreamsFilesAndDirectories/Exercises/Exercises Resources/output.txt",
                "Advanced-Java/StreamsFilesAndDirectories/Exercises/Exercises Resources/text.txt"
        };

       FileOutputStream fileOutputStream = new FileOutputStream(
               "Advanced-Java/StreamsFilesAndDirectories/Exercises/Exercises Resources/archive.zip");
       ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

        for (String filePath : filesToAdd) {
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);

            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));

            byte[] buffer = new byte[1024];
            int length = fileInputStream.read(buffer);

            while (length != -1) {
                zipOutputStream.write(buffer, 0, length);
                length = fileInputStream.read(buffer);
            }
            zipOutputStream.closeEntry();
            fileInputStream.close();
        }
        zipOutputStream.close();
    }
}
