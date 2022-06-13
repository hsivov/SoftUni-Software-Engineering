package Methods.exercise;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        printMiddleCharacters(text);
    }

    public static void printMiddleCharacters(String text){

        if (text.length() % 2 != 0){
            int middleChar = text.length() / 2;
            System.out.println(text.charAt(middleChar));
        } else {
            int middleChar1 = (text.length() / 2) - 1;
            int middleChar2 = text.length() / 2;
            System.out.print("" + text.charAt(middleChar1) + text.charAt(middleChar2));
        }
    }
}
