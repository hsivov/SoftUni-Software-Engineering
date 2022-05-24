package basicSyntaxConditionalStatementsLoops.more;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int temp;

        if (num3 > num2) {
            temp = num3;
            num3 = num2;
            num2 = temp;
        }
        if (num3 > num1){
            temp = num3;
            num3 = num1;
            num1 = temp;
        }
        if (num2 > num1){
            temp = num2;
            num2 = num1;
            num1 = temp;
        }
        System.out.printf("%d%n%d%n%d%n", num1, num2, num3);
    }
}
