package Arrays.exercise;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numWagons = Integer.parseInt(scanner.nextLine());
        int totalPassengers = 0;
        int[] passengers = new int[numWagons];

        for (int i = 0; i < numWagons; i++) {
            passengers[i] = Integer.parseInt(scanner.nextLine());
            totalPassengers += passengers[i];
        }
        for (int wagon:passengers
             ) {
            System.out.print(wagon + " ");
        }
        System.out.printf("%n%d", totalPassengers);
    }
}
