package TextProcessing.More;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        String input = scanner.nextLine();

        int sum = 0;
        for (char symbol : input.toCharArray()) {
            if (symbol > firstChar && symbol < secondChar) {
                sum += symbol;
            }
        }
        System.out.println(sum);
    }
}
