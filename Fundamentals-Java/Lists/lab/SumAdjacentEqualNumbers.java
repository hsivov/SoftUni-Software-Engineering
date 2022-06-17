package Lists.lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble).collect(Collectors.toList());

        for (int i = 0; i < numbers.size() - 1; i++) {

            double firstNum = numbers.get(i);
            double secondNum = numbers.get(i + 1);

            if (firstNum == secondNum){
                numbers.set(i, firstNum + secondNum);
                numbers.remove(i + 1);

                i = -1;
            }
        }
            System.out.println(joinElementsByDelimiter(numbers, " "));
    }
    public static StringBuilder joinElementsByDelimiter(List<Double> items, String delimiter){
        StringBuilder output = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.#");

        for (double item : items){
            output.append(df.format(item)).append(delimiter);
        }
        return output;
    }
}
