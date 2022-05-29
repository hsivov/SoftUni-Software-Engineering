package DataTypesAndVariables.more;

import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int sum = 0;
            long leftNumber = scanner.nextLong();
            long rightNumber = scanner.nextLong();

            if (leftNumber > rightNumber){
                while (Math.abs(leftNumber) > 0){
                    sum += leftNumber % 10;
                    leftNumber /= 10;
                }
            } else {
                while (Math.abs(rightNumber) > 0){
                    sum += rightNumber % 10;
                    rightNumber /= 10;
                }
            }
            System.out.println(Math.abs(sum));
        }
    }
}
