package FirstStepsInCoding.more;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        List<Integer> firstArray = new ArrayList<>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10));
        List<Integer> secondArray = new ArrayList<>(Arrays.asList(1, 6, -1, 10));

        if (isValidSubsequence(firstArray, secondArray)){
            System.out.println("Is Valid");
        }else {
            System.out.println("Is Not valid");
        }
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int index = 0;
        for (int i = 0; i < array.size(); i++){

            if (array.get(i) == sequence.get(index)) {
                index++;
            }
        }
        return index == sequence.size();
    }
}
