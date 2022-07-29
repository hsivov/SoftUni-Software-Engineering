package RegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "[A-Za-z0-9]+[._-]?[A-Za-z0-9]+@[A-Za-z]+-?[A-Za-z]+(\\.[A-Za-z]+-?[A-Za-z]+)+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        //input = "Just send email to s.miller@mit.edu and j.hopking@york.ac.uk for more information."
        //matcher = ["s.miller@mit.edu", "j.hopking@york.ac.uk"]
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
