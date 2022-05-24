package OnlineExam18and19July2020;

import java.util.Scanner;

public class BarcodeGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        int f1 = firstNum / 1000;
        int f2 = firstNum / 100 % 10;
        int f3 = firstNum / 10 % 10;
        int f4 = firstNum % 10;

        int s1 = secondNum / 1000;
        int s2 = secondNum / 100 % 10;
        int s3 = secondNum / 10 % 10;
        int s4 = secondNum % 10;

        for (int i = f1; i <= s1; i++)
        {
            for (int j = f2; j <= s2; j++)
            {
                for (int k = f3; k <= s3; k++)
                {
                    for (int l = f4; l <= s4; l++)
                    {
                        if (i % 2!= 0 && j % 2 != 0 && k %2 != 0 && l % 2 !=0 )
                        {
                            System.out.printf("%d%d%d%d ", i, j ,k, l);
                        }
                    }
                }
            }
        }

        //OR
        /*
        String first = "" + firstNum;
        String second = "" + secondNum;

        int f1 = Integer.parseInt("" + first.charAt(0));
        int f2 = Integer.parseInt("" + first.charAt(1));
        int f3 = Integer.parseInt("" + first.charAt(2));
        int f4 = Integer.parseInt("" + first.charAt(3));

        int s1 = Integer.parseInt("" + second.charAt(0));
        int s2 = Integer.parseInt("" + second.charAt(1));
        int s3 = Integer.parseInt("" + second.charAt(2));
        int s4 = Integer.parseInt("" + second.charAt(3));

        for (int i = f1; i <= s1; i++) {
            for (int j = f2; j <= s2; j++) {
                for (int k = f3; k <= s3; k++) {
                    for (int l = f4; l <= s4; l++) {
                        if (i % 2 != 0 && j % 2 != 0 && k % 2 != 0 && l % 2 != 0) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                    }
                }
            }
        }
         */
    }
}
