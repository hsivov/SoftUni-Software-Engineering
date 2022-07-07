package AssociativeArrays.lab;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine().split(" ");

        Map<String, Integer> wordsCountMap = new LinkedHashMap<>();
        for (int i = 0; i < inputLine.length; i++) {
            String currentWord = inputLine[i].toLowerCase();
            Integer count = wordsCountMap.get(currentWord);

            if (wordsCountMap.containsKey(currentWord)){
                wordsCountMap.put(currentWord, count + 1);
            } else {
                wordsCountMap.put(currentWord, 1);
            }
        }
        List<String> oddWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordsCountMap.entrySet()) {
            if (entry.getValue() % 2 != 0){
                oddWords.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", oddWords));
    }
}
