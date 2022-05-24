package NestedLoops.lab;

import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int floors = Integer.parseInt(scanner.nextLine());
        int rooms = Integer.parseInt(scanner.nextLine());

        for (int i = floors; i > 0; i--) {
            for (int j = 0; j < rooms; j++) {
                String designation;
                if (i == floors) {
                    designation = "L";
                }else if (i % 2 == 0){
                   designation = "O";
                }else{
                    designation = "A";
                }
                System.out.printf("%s%d%d ",designation, i, j);
            }
            System.out.println();
        }
    }
}
