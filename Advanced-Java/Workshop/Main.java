package Workshop;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(10);
        list.addLast(45);
        list.addLast(-9);
        list.addLast(0);
        list.addLast(2);
        list.addLast(6);
        list.addLast(77);
        list.addLast(7);
        System.out.println("Removed: " + list.removeFirst());

        System.out.println(list.get(0));
        System.out.println(list.get(4));
        System.out.println(list.get(5));
        System.out.println(list.get(10));

        list.forEach(e -> System.out.print(e + " "));
    }
}
