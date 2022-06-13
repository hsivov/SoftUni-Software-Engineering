package Methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double inputNum = Double.parseDouble(scanner.nextLine());
        int inputPower = Integer.parseInt(scanner.nextLine());

        DecimalFormat df = new DecimalFormat("0.####");

        double result = mathPower(inputNum, inputPower);

        System.out.println(df.format(result));
    }

    public static double mathPower(double num, int power){
        double result = 1;
        for (int i = 1; i <= power; i++) {
            result = result * num;
        }
        return result;
    }
}
