package TextProcessing.Lab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String text = scanner.nextLine();

        int indexToRemove = text.indexOf(key);
        while (indexToRemove != -1){
            text = text.replace(key, "");
            indexToRemove = text.indexOf(key);
        }
        System.out.println(text);
    }
}
