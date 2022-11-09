package InterfacesAndAbstraction.collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] items = scanner.nextLine().split(" ");
        int numberOfRemoveOperations = Integer.parseInt(scanner.nextLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        performAddOperation(items, addCollection);
        performAddOperation(items, addRemoveCollection);
        performAddOperation(items, myList);

        performRemoveOperation(addRemoveCollection, numberOfRemoveOperations);
        performRemoveOperation(myList, numberOfRemoveOperations);
    }
    public static void performAddOperation(String[] items, Addable addable) {
        for (String item : items) {
            System.out.print(addable.add(item) + " ");
        }
        System.out.println();
    }

    public static void performRemoveOperation(AddRemovable addRemovable, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(addRemovable.remove() + " ");
        }
        System.out.println();
    }
}
