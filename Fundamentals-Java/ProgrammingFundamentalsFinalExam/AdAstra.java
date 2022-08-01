package ProgrammingFundamentalsFinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        String regex = "([|#])(?<food>[A-Za-z\\s]+)\\1(?<expirationDate>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(inputString);
        List<String> items = new ArrayList<>();

        int totalCalories = 0;
        while (matcher.find()) {
            String food = matcher.group("food");
            String expirationDate = matcher.group("expirationDate");
            int calories = Integer.parseInt(matcher.group("calories"));

            totalCalories += calories;

            String output = String.format("Item: %s, Best before: %s, Nutrition: %d", food, expirationDate, calories);
            items.add(output);
        }
        int daysLast = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", daysLast);

        items.forEach(System.out::println);
    }
}
