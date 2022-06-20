package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String[] bombNumbers = scanner.nextLine().split("\\s+");

        String specialBombNumber = bombNumbers[0];
        int power = Integer.parseInt(bombNumbers[1]);

        while (numbers.contains(specialBombNumber)){
            int elementIndex = numbers.indexOf(specialBombNumber);

            int left = Math.max(0, elementIndex - power);

            int right = Math.min(elementIndex + power, numbers.size() - 1);

            for (int i = right; i >= left; i--) {
                numbers.remove(i);
            }
        }

        System.out.println(numbers.stream().mapToInt(Integer::parseInt).sum());
    }
}
