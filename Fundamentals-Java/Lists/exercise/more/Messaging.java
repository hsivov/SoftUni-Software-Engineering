package Lists.exercise.more;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).toList();

        String text = scanner.nextLine();

        StringBuilder sb = new StringBuilder(text);
        StringBuilder removed = new StringBuilder();
        List<Integer> indexes = new ArrayList<>();

        //1. Сумата от всеки елемент в numberList
        //   Всяка сума е индекс
        for (int number : numberList) {
            int sum = 0;
            while (number > 0) {
                int digit = number % 10;
                sum += digit;
                number /= 10;
            }
            indexes.add(sum);
        }
        //2. Взимаме елемента от текста, който отговаря на плочуените индекси

        int index = 0;

        for (int i = 0; i < indexes.size(); i++) {
            if (indexes.get(i) > text.length()) {
                index = indexes.get(i) - text.length();
            } else {
                index = indexes.get(i);
            }
            char removedChar = sb.charAt(index);
            removed.append(removedChar);
            sb.deleteCharAt(index);
        }
        System.out.println(removed);
    }
}