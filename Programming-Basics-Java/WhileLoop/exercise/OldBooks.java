package WhileLoop.exercise;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wantedBook = scanner.nextLine();

        int counter = 0;
        boolean isFound = false;

        String input = scanner.nextLine();
        while (!input.equals("No More Books")) {
            if (input.equals(wantedBook)) {
                isFound = true;
                break;
            }
            counter++;
            input = scanner.nextLine();
        }
        if(isFound){
            System.out.printf("You checked %d books and found it.", counter);
        }else{
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", counter);
        }
    }
}
