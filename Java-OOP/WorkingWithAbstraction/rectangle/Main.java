package WorkingWithAbstraction.rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = getInts(scanner);

        Point bottomLeft = new Point(coordinates[0], coordinates[1]);
        Point topRight = new Point(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int numberOfPoints = Integer.parseInt(scanner.nextLine());

        for (int p = 1; p <= numberOfPoints; p++) {
            int[] pointCoordinates = getInts(scanner);

            Point pointToCheck = new Point(pointCoordinates[0], pointCoordinates[1]);
            System.out.println(rectangle.contains(pointToCheck));
        }
    }

    private static int[] getInts(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
