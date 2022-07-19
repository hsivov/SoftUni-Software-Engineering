package TextProcessing.Exercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String str1 = input.split(" ")[0];
        String str2 = input.split(" ")[1];

        multiplyCharacters(str1, str2);
    }

    private static void multiplyCharacters(String firstString, String secondString) {
        int sum = 0;
        // проверяваме каква е дължината на двата стринга - има ли разлика или са еднакви.
        //използвам метод за самото умножение. Понеже в метода не правя проверка, а тука
        // винаги по-дългият стринг го подавам като първи аргумент.
        if (firstString.length() > secondString.length()) {
            sum = multiply(firstString, secondString);
        }

        if (firstString.length() < secondString.length()) {
            sum = multiply(secondString, firstString);
        }
        //ако са еднакви
        if (firstString.length() == secondString.length()) {
            for (int i = 0; i < firstString.length(); i++) {
                int product = firstString.charAt(i) * secondString.charAt(i);
                sum += product;
            }
        }
        System.out.println(sum);
    }

    public static int multiply(String str1, String str2) {
        int result = 0;
        //умножавам до дължината на по-късият стринг.
        for (int i = 0; i < str2.length(); i++) {
            int product = str1.charAt(i) * str2.charAt(i);
            result += product;
        }
        //остатъка от по-дългият стринг - добавям стойноста на всеки символ към резултатът
        for (int i = str2.length(); i < str1.length(); i++) {
            char currentSymbol = str1.charAt(i);
            result += currentSymbol;
        }
        return result;
    }
}
