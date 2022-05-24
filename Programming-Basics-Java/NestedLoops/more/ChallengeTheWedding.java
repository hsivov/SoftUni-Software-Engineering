package NestedLoops.more;

import java.util.Scanner;

public class ChallengeTheWedding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int men = Integer.parseInt(scanner.nextLine());
        int women = Integer.parseInt(scanner.nextLine());
        int allTables = Integer.parseInt(scanner.nextLine());
        int table = 0;

        for (int i = 1; i <= men ; i++) {
            for (int j = 1; j <= women; j++) {
                table++;
                if (table <= allTables){
                    System.out.printf("(%d <-> %d) ", i, j);
                }
            }
        }
    }
}
