package Methods.exercise;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            if (isPalindrome(input)){
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            input = scanner.nextLine();
        }
    }
    private static boolean isPalindrome(String input){
        String reverseInput = "";

        for (int i = 0; i < input.length(); i++) {
            reverseInput += input.charAt(input.length() - 1 - i);
        }
        int inputNumber = Integer.parseInt(input);
        int reverseNumber = Integer.parseInt(reverseInput);
        for (int i = 0; i < input.length(); i++) {
            if (inputNumber != reverseNumber){
                return  false;
            }
        }
        return true;
    }
}
