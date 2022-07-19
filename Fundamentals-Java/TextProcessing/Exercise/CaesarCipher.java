package TextProcessing.Exercise;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String input = scanner.nextLine();

        for (char symbol : input.toCharArray()){
            symbol += 3;
            sb.append(symbol);
        }
        System.out.println(sb);
    }
}
