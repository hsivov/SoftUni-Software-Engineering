package Lists.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputLine = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int listSize = inputLine.size();

        for (int i = 0; i < listSize / 2; i++) {
            int firstNum = inputLine.get(i);
            int secondNum = inputLine.get(inputLine.size() - 1);
            inputLine.set(i, firstNum + secondNum);
            inputLine.remove(inputLine.size() - 1);
        }
        System.out.println(inputLine.toString().replaceAll("[\\[\\],]", ""));
    }
}
