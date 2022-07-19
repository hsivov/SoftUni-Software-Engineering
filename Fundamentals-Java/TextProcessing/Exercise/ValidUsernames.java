package TextProcessing.Exercise;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        for (String userName : input) {
            boolean isValid = true;
            for (char symbol : userName.toCharArray()) {

                if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                    isValid = false;
                } else if (userName.length() < 3 || userName.length() > 16) {
                    isValid = false;
                }
            }
            if (isValid){
                System.out.println(userName);
            }
        }
    }
}
