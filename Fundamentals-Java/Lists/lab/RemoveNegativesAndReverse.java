package Lists.lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        numList.removeIf(e -> e < 0);

        if (numList.isEmpty()){
            System.out.println("empty");
        } else {
            Collections.reverse(numList);
            System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
