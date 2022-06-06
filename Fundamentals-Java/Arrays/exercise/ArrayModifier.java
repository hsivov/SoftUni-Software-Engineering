package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("end")) {
            String[] commandPart = commandLine.split(" ");
            String command = commandPart[0];

            switch (command) {
                case "swap":
                    int index1 = Integer.parseInt(commandPart[1]);
                    int index2 = Integer.parseInt(commandPart[2]);
                    int temp = array[index1];
                    array[index1] = array[index2];
                    array[index2] = temp;
                    break;
                case "multiply":
                    int multiplyIndex1 = Integer.parseInt(commandPart[1]);
                    int multiplyIndex2 = Integer.parseInt(commandPart[2]);
                    int product = array[multiplyIndex1] * array[multiplyIndex2];
                    array[multiplyIndex1] = product;
                    break;
                case "decrease":
                    for (int i = 0; i < array.length; i++) {
                        array[i] = array[i] - 1;
                    }
                    break;
            }
            commandLine = scanner.nextLine();
        }

        System.out.println(Arrays.toString(array).replace("[", "").replace("]", ""));
    }
}
