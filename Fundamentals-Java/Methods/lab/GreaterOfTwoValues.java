package Methods.lab;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        switch (type) {
            case "int":
                int num1 = Integer.parseInt(scanner.nextLine());
                int num2 = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(num1, num2));
                break;
            case "char":
                char char1 = scanner.nextLine().charAt(0);
                char char2 = scanner.nextLine().charAt(0);
                System.out.println(getMax(char1, char2));
                break;
            case "string":
                String string1 = scanner.nextLine();
                String string2 = scanner.nextLine();
                System.out.println(getMax(string1, string2));
                break;
        }
    }

    static int getMax(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        }
        return num2;
    }

    static char getMax(char char1, char char2) {
        if (char1 > char2) {
            return char1;
        }
        return char2;
    }

    static String getMax(String string1, String string2) {
        if (string1.compareTo(string2) >= 0) {
            return string1;
        }
        return string2;
    }
}
