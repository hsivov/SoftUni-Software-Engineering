package Workshop.BasicAlgorithms;

import java.util.Scanner;

public class RecursivePow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(pow(x, n));
    }

    static int pow(int x, int n) {

        if (n == 1) {
            return x;
        }
        return x * pow(x, n - 1);
    }
}
