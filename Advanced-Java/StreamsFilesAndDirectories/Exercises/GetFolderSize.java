package StreamsFilesAndDirectories.Exercises;

import java.io.File;
import java.util.ArrayDeque;

public class GetFolderSize {
    public static void main(String[] args) {

        File folder = new File("Advanced-Java/StreamsFilesAndDirectories/Exercises/Exercises Resources/Exercises Resources");

        ArrayDeque<File> directories = new ArrayDeque<>();
        directories.offer(folder);

        int sumOfBytes = 0;

        while (!directories.isEmpty()) {
            File current = directories.poll();
            File[] files = current.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    directories.offer(file);
                } else {
                    sumOfBytes += file.length();
                }
            }
        }
        System.out.printf("Folder size: %d", sumOfBytes);
    }
}
