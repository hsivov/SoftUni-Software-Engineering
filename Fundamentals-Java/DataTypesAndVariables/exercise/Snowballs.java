package DataTypesAndVariables.exercise;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n =Integer.parseInt(scanner.nextLine());

//        For each snowball you will receive 3 input lines:
//        •	On the first line, you will get the snowballSnow – an integer.
//        •	On the second line, you will get the snowballTime – an integer.
//        •	On the third line, you will get the snowballQuality – an integer.
//        For each snowball you must calculate its snowballValue by the following formula:
//        (snowballSnow / snowballTime) ^ snowballQuality
//        In the end, you must print the highest calculated snowballValue.
        double highestValue = 0;
        int highestSnowballSnow = 0;
        int highestSnowballTime = 0;
        int highestSnowballQuality = 0;

        for (int i = 0; i < n; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            double value = Math.pow(snowballSnow * 1.00 / snowballTime, snowballQuality);
            if (value > highestValue){
                highestValue = value;
                highestSnowballSnow = snowballSnow;
                highestSnowballTime = snowballTime;
                highestSnowballQuality =snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", highestSnowballSnow, highestSnowballTime, highestValue, highestSnowballQuality);
    }
}
