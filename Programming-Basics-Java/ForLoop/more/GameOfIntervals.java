package ForLoop.more;

import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int turns = Integer.parseInt(scanner.nextLine());
        double result = 0;
        double from0to9 = 0;
        double from10to19 = 0;
        double from20to29 = 0;
        double from30to39 = 0;
        double from40to50 = 0;
        double invalidNumber = 0;

        for (int i = 0; i < turns; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number >= 0 && number < 10) {
                result = result + number * 0.2;
                from0to9++;
            } else if (number >= 10 && number < 20) {
                result = result + number * 0.3;
                from10to19++;
            } else if (number >= 20 && number < 30) {
                result = result + number * 0.4;
                from20to29++;
            } else if (number >= 30 && number < 40) {
                result += 50;
                from30to39++;
            } else if (number >= 40 && number <= 50) {
                result += 100;
                from40to50++;
            } else {
                result = result / 2;
                invalidNumber++;
            }
        }
        double percent0to9 = from0to9 / turns * 100;
        double percent10to19 = from10to19 / turns * 100;
        double percent20to29 = from20to29 / turns * 100;
        double percent30to39 = from30to39 / turns * 100;
        double percent40to50 = from40to50 / turns * 100;
        double percentInvalidNumbers = invalidNumber / turns * 100;
        System.out.printf("%.2f%n", result);
        System.out.printf("From 0 to 9: %.2f%%%n", percent0to9);
        System.out.printf("From 10 to 19: %.2f%%%n", percent10to19);
        System.out.printf("From 20 to 29: %.2f%%%n", percent20to29);
        System.out.printf("From 30 to 39: %.2f%%%n", percent30to39);
        System.out.printf("From 40 to 50: %.2f%%%n", percent40to50);
        System.out.printf("Invalid numbers: %.2f%%", percentInvalidNumbers);
    }
}
