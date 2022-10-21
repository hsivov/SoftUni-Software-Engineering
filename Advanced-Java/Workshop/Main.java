package Workshop;

import java.util.Arrays;
import java.util.Scanner;

import static Workshop.SmartArray.sort;

public class Main {
    public static void main(String[] args) {

        SmartArray<String> list = new SmartArray<>();

        list.add("Ford");
        list.add("Opel");
        list.add("Honda");
        list.add("Lamborghini");
        list.add("Ferrari");
        list.add("Lada");

        System.out.println(list.remove(5) + " is removed from the garage");

        list.set(1, "Mercedes");

        list.add(2, "Toyota");

        if (list.contains("Lamborghini")) {
            sort(list);
            list.forEach(System.out::println);
        }
        Stack<SmartArray<String>> stack = new Stack<>();

        stack.push(list);
        System.out.println(stack.size());

        SmartArray<String> stringSmartArray = null;

        if (!stack.isEmpty()) {
            stringSmartArray = stack.pop();
        }

        if (stringSmartArray != null) {
            System.out.println(stringSmartArray.get(stringSmartArray.size() - 1));
        }

        Stack<Integer> integerStack = new Stack<>();

        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(integerStack::push);

        integerStack.forEach(System.out::println);
    }
}
