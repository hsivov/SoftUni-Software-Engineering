package Methods.exercise;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //6 – 10 characters (inclusive);
        //Consists only of letters and digits;
        //Have at least 2 digits.

        String password = scanner.nextLine();

        if (!isValidLength(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        if (!isLettersAndDigitsConsist(password)) {
            System.out.println("Password must consist only of letters and digits");
        }

        if (!isAtLeast2Digits(password)) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isValidLength(password) && isLettersAndDigitsConsist(password) && isAtLeast2Digits(password)) {
            System.out.println("Password is valid");
        }
    }

    private static boolean isValidLength(String password) {

        return password.length() >= 6 && password.length() <= 10;
    }

    private static boolean isLettersAndDigitsConsist(String password) {

        for (char symbol :
                password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAtLeast2Digits(String password) {
        int countDigits = 0;
        for (char symbol :
                password.toCharArray()) {
            if (Character.isDigit(symbol)) {
                countDigits++;
            }
        }
        return countDigits >= 2;
    }
}
