package NestedLoops.more;

import java.util.Scanner;

public class WeddingSeats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char symbol = scanner.nextLine().charAt(0);
        int rows = Integer.parseInt(scanner.nextLine());
        int oddRowSeats = Integer.parseInt(scanner.nextLine());
        int evenRowSeats = oddRowSeats + 2;
        int countSeats = 0;

        for (int i = 'A'; i <= symbol ; i++) {

            for (int j = 1; j <= rows ; j++) {
                if (j % 2 == 0){
                    for (int k = 'a'; k < 'a' + evenRowSeats; k++) {
                        System.out.printf("%c%d%c%n", i, j, k);
                        countSeats++;
                    }
                }else {
                    for (int k = 'a'; k < 'a' + oddRowSeats; k++) {
                        System.out.printf("%c%d%c%n", i, j, k);
                        countSeats++;
                    }
                }
            }
            rows++;
        }
        System.out.println(countSeats);
    }
}
