package FinalRetake15Aug;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^(?<name>[A-Z][a-z]{2,}\\s[A-Z][a-z]{2,})#+(?<position>([A-Z][a-zA-Z]+|&[A-Z][a-zA-Z]+){0,3})(?<company>\\d{2}[A-Z][A-Za-z0-9]+\\s(Ltd.|JSC))$";

        Pattern pattern = Pattern.compile(regex);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        for (int input = 1; input <= numberOfInputs; input++) {
            String inputLine = scanner.nextLine();

            Matcher matcher = pattern.matcher(inputLine);

            if (matcher.find()) {
                String name = matcher.group("name");
                String jobPosition = matcher.group("position");
                jobPosition = jobPosition.replace("&", " ");
                String company = matcher.group("company");
                company = company.replaceAll("\\d+", "");
                System.out.printf("%s is %s at %s%n", name, jobPosition, company);
            }
        }
    }
}
