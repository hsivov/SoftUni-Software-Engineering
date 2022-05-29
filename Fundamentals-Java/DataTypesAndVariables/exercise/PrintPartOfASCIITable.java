package DataTypesAndVariables.exercise;

import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startIndex = Integer.parseInt(scanner.nextLine());
        int endIndex = Integer.parseInt(scanner.nextLine());

        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf("%c ", i);
        }
    }
}
