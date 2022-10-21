package Workshop.BasicAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] sortedArray = mergeSort(array);

        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
    }

    private static int[] mergeSort(int[] array) {

        if (array.length == 1) {
            return array;
        }

        int halfIndex = array.length / 2;

        int secondArrayLength = array.length - halfIndex;

        int[] firstPartition = new int[halfIndex];
        int[] secondPartition = new int[secondArrayLength];

        for (int i = 0; i < halfIndex; i++) {
            firstPartition[i] = array[i];
        }

        for (int i = halfIndex; i < array.length; i++) {
            secondPartition[i - halfIndex] = array[i];
        }

        mergeSort(firstPartition);
        mergeSort(secondPartition);

        int mainIndex = 0;

        int firstPartitionIndex = 0;
        int secondPartitionIndex = 0;

        while (firstPartitionIndex < halfIndex && secondPartitionIndex < secondArrayLength) {

            if (firstPartition[firstPartitionIndex] < secondPartition[secondPartitionIndex]) {
                array[mainIndex] = firstPartition[firstPartitionIndex];

                mainIndex++;
                firstPartitionIndex++;
            } else {
                array[mainIndex] = secondPartition[secondPartitionIndex];

                mainIndex++;
                secondPartitionIndex++;
            }
        }

        while (firstPartitionIndex < halfIndex) {
            array[mainIndex] = firstPartition[firstPartitionIndex];

            mainIndex++;
            firstPartitionIndex++;
        }

        while (secondPartitionIndex < secondArrayLength) {
            array[mainIndex] = secondPartition[secondPartitionIndex];

            mainIndex++;
            secondPartitionIndex++;
        }

        return array;
    }
}
