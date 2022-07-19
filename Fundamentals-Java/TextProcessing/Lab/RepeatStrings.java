package TextProcessing.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //StringBuilder result = new StringBuilder();

        String[] words = scanner.nextLine().split(" ");
        List<String> result = new ArrayList<>();

        for (String word : words){
//            int len = word.length();
//            for (int i = 0; i < len; i++) {
//                result.append(word);
//            }
            result.add(repeatStr(word, word.length()));
        }
        result.forEach(System.out::println);
    }
    public static String repeatStr (String s, int count){
        String[] repeatArr = new String[count];
        for (int i = 0; i < count; i++) {
            repeatArr[i] = s;
        }
        return String.join("", repeatArr);
    }
}
