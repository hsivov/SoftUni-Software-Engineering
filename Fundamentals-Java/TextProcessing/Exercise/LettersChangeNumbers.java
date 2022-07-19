package TextProcessing.Exercise;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] codesArr = input.split("\\s+");

        double totalSum = 0;
        for (String code : codesArr) {
            double resultNumber = getProcessedNumber(code);
            totalSum += resultNumber;
        }
        System.out.printf("%.2f", totalSum);
    }

    private static double getProcessedNumber(String code) {
        char firstLetter = code.charAt(0);
        char secondLetter = code.charAt(code.length() - 1);
        double number = Double.parseDouble(code.replace(firstLetter, ' ')
                .replace(secondLetter, ' ')
                .trim());

        if (Character.isUpperCase(firstLetter)) {
            int positionUpperLetter = firstLetter - 64;
            number /= positionUpperLetter;
        } else {
            int positionLowerLetter = firstLetter - 96;
            number *= positionLowerLetter;
        }

        if (Character.isUpperCase(secondLetter)) {
            int positionUpperLetter = secondLetter - 64;
            number -= positionUpperLetter;
        } else {
            int positionLowerLetter = secondLetter - 96;
            number += positionLowerLetter;
        }
        return number;
    }
}
