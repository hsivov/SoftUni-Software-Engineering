package TextProcessing.Lab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String banWord : banWords){
            if (text.contains(banWord)){
                text = text.replace(banWord, repeatStr("*", banWord.length()));
            }
        }
        System.out.println(text);
    }
    public static String repeatStr (String s, int count){
        String[] repeatArr = new String[count];
        for (int i = 0; i < count; i++) {
            repeatArr[i] = s;
        }
        return String.join("", repeatArr);
    }
}
