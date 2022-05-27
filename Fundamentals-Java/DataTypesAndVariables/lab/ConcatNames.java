package DataTypesAndVariables.lab;

import java.util.Scanner;

public class ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String delimiter = scanner.nextLine();

        String resultStr = String.format("%s%s%s", firstName, delimiter, lastName);
        System.out.println(resultStr);
    }
}
