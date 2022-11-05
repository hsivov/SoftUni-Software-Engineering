package WorkingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getIntsToArray(scanner.nextLine());
        int rows = dimensions[0];
        int cols = dimensions[1];

        Field field = new Field(rows, cols);

        String command = scanner.nextLine();
        long collectedStars = 0;
        while (!"Let the Force be with you".equals(command)) {
            Jedi jedi = new Jedi(Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray());
            int[] evilPosition = getIntsToArray(scanner.nextLine());
            int evilRow = evilPosition[0];
            int evilCol = evilPosition[1];

            Galaxy galaxy = new Galaxy(field, jedi);
            galaxy.moveEvil(evilRow, evilCol);

            collectedStars += galaxy.moveJedi();

            command = scanner.nextLine();
        }

        System.out.println(collectedStars);


    }

    private static int[] getIntsToArray(String scanner) {
        return Arrays.stream(scanner.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
