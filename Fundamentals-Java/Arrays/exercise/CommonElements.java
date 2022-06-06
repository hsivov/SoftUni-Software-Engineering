package Arrays.exercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArray = scanner.nextLine().split(" ");
        String[] secondArray = scanner.nextLine().split(" ");

        for (String elementInSecondArray:secondArray
             ) {
            for (String elementInFirstArray:firstArray
                 ) {
                if (elementInSecondArray.equals(elementInFirstArray)){
                    System.out.print(elementInSecondArray + " ");
                }
            }
        }
    }
}
