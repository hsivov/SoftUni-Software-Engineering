package FinalExam7Aug;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncryptingPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputCount = Integer.parseInt(scanner.nextLine());

        for (int line = 1; line <= inputCount; line++) {
            String input = scanner.nextLine();
            String regex = "(.+)>(?<digits>\\d{3})\\|(?<lowerLetters>[a-z]{3})\\|(?<upperLetters>[A-Z]{3})\\|(?<symbols>[^<>]{3})<\\1";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()){
                String digits = matcher.group("digits");
                String lowerLetters = matcher.group("lowerLetters");
                String upperLetters = matcher.group("upperLetters");
                String symbols = matcher.group("symbols");

                String password = digits + lowerLetters + upperLetters + symbols;

                System.out.println("Password: " + password);
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
