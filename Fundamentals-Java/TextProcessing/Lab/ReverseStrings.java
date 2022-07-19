package TextProcessing.Lab;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String result = "";
            for (int i = input.length() - 1; i >= 0; i--) {
                char symbol = input.charAt(i);
                result += symbol;
            }
            System.out.printf("%s = %s%n", input, result);
            input = scanner.nextLine();
        }
    }
}
