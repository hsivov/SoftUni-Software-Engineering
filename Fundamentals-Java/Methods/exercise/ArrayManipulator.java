package Methods.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandPart = command.split(" ");
            int index = 0;

            switch (commandPart[0]) {
                case "max":
                    switch (commandPart[1]) {
                        case "odd":
                            index = maxOddIndex(array);
                            if (index < 0) {
                                System.out.println("No matches");
                            } else {
                                System.out.println(index);
                            }
                            break;
                        case "even":
                            index = maxEvenIndex(array);
                            if (index < 0) {
                                System.out.println("No matches");
                            } else {
                                System.out.println(index);
                            }
                            break;
                    }
                    break;
                case "min":
                    switch (commandPart[1]) {
                        case "odd":
                            index = minOddIndex(array);
                            if (index < 0) {
                                System.out.println("No matches");
                            } else {
                                System.out.println(index);
                            }
                            break;
                        case "even":
                            index = minEvenIndex(array);
                            if (index < 0) {
                                System.out.println("No matches");
                            } else {
                                System.out.println(index);
                            }
                            break;
                    }
                    break;
                case "exchange":
                    exchange(array, Integer.parseInt(commandPart[1]));
                    break;
                case "first":
                    switch (commandPart[2]){
                        case "even":
                            firstEven(array, Integer.parseInt(commandPart[1]));
                            break;
                        case "odd":
                            firstOdd(array, Integer.parseInt(commandPart[1]));
                            break;
                    }
                    break;
                case "last":
                    switch (commandPart[2]){
                        case "even":
                            break;
                        case "odd":
                            break;
                    }
                    break;
            }

            command = scanner.nextLine();
        }
    }

    private static int maxOddIndex(int[] array) {
        int maxOddIndex = -1;
        int maxOddElementValue = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                if (array[i] >= maxOddElementValue) {
                    maxOddElementValue = array[i];
                    maxOddIndex = i;
                }
            }
        }
        return maxOddIndex;
    }

    private static int maxEvenIndex(int[] array) {
        int maxEvenIndex = -1;
        int maxEvenElementValue = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i] % 2 == 0) {
                if (array[i] >= maxEvenElementValue) {
                    maxEvenElementValue = array[i];
                    maxEvenIndex = i;
                }
            }
        }
        return maxEvenIndex;
    }

    private static int minOddIndex(int[] array) {
        int minOddIndex = -1;
        int minOddElementValue = 1000;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                if (array[i] <= minOddElementValue) {
                    minOddElementValue = array[i];
                    minOddIndex = i;
                }
            }
        }
        return minOddIndex;
    }

    private static int minEvenIndex(int[] array) {
        int minEvenIndex = -1;
        int minEvenElementValue = 1000;

        for (int i = 0; i < array.length; i++) {

            if (array[i] % 2 == 0) {
                if (array[i] <= minEvenElementValue) {
                    minEvenElementValue = array[i];
                    minEvenIndex = i;
                }
            }
        }
        return minEvenIndex;
    }

    private static void exchange(int[] array, int index) {

        if (index > array.length - 1) {
            System.out.println("Invalid index");
            return;
        }
        int[] newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (index >= i) {
                newArray[i] = array[index + i + 1];
            } else {
                newArray[i] = array[i - index];
            }
        }
        System.out.println(Arrays.toString(newArray));
    }

    private static void firstEven(int[] array, int count) {
        int[] firstEven = new int[count];
        int countEven = count;

        if (count > array.length){
            System.out.println("Invalid count");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && countEven > 0) {
                firstEven[2 - countEven] = array[i];
                countEven--;
            }
        }
        if (countEven != count) {
            System.out.println(Arrays.toString(firstEven));
        } else {
            System.out.println("[]");
        }
    }

    private static void firstOdd(int[] array, int count) {
        int[] firstEven = new int[count];
        int countOdd = count;

        if (count > array.length){
            System.out.println("Invalid count");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && countOdd > 0) {
                firstEven[2 - countOdd] = array[i];
                countOdd--;
            }
        }
        if (countOdd != count) {
            System.out.println(Arrays.toString(firstEven));
        } else {
            System.out.println("[]");
        }
    }

}
