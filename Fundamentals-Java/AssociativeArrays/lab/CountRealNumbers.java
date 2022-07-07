package AssociativeArrays.lab;

import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> countNumbersMap = new TreeMap<>();

        for (double currentNum : nums){

            if (countNumbersMap.containsKey(currentNum)){
                countNumbersMap.put(currentNum, countNumbersMap.get(currentNum) + 1);
            } else {
                countNumbersMap.put(currentNum, 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : countNumbersMap.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
