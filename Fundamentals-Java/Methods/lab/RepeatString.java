package Methods.lab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatString(inputString, n));
    }

    public static String repeatString(String text, int n) {
        String result = "";
        for (int i = 1; i <= n; i++) {

            result += text;
        }
        return result;
    }
}
