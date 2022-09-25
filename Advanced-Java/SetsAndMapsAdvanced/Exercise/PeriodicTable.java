package SetsAndMapsAdvanced.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> periodicTable = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            periodicTable.addAll(Arrays.asList(input));
        }
        periodicTable.forEach(element -> System.out.print(element + " "));
    }
}
