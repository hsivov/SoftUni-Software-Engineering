package RegularExpressions.Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> namesList = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        Map<String, Integer> racersDistances = new LinkedHashMap<>();
        namesList.forEach(name -> racersDistances.put(name, 0));

        Pattern patternLetters = Pattern.compile("[A-Za-z]+");
        Pattern patternDigit = Pattern.compile("\\d");

        String input = scanner.nextLine();
        while (!input.equals("end of race")){
            StringBuilder nameBuilder = new StringBuilder();

            Matcher matcherLetters = patternLetters.matcher(input);
            while (matcherLetters.find()){
                nameBuilder.append(matcherLetters.group());
            }

            int distance = 0;
            Matcher matcherDigit = patternDigit.matcher(input);
            while (matcherDigit.find()){
                distance += Integer.parseInt(matcherDigit.group());
            }

            String racerName = nameBuilder.toString();
            if (racersDistances.containsKey(racerName)){
                int currentDistance = racersDistances.get(racerName);
                racersDistances.put(racerName, currentDistance + distance);
            }
            input = scanner.nextLine();
        }
        List<String> namesOfFirstThree = racersDistances.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("1st place: " + namesOfFirstThree.get(0));
        System.out.println("2nd place: " + namesOfFirstThree.get(1));
        System.out.println("3rd place: " + namesOfFirstThree.get(2));
    }
}
