package Workshop;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class LinkedList {

    private Node head;
    private int size;

    public void addFirst(int element) {
        Node newNode = new Node(element);

        if (!isEmpty()) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    public void addLast(int element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }
        Node currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = new Node(element);
        size++;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public int removeLast() {
        if (size < 2) {
            return removeFirst();
        }

        Node currentNode = head;

        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        int result = currentNode.next.value;
        currentNode.next = null;
        size--;
        return result;
    }

    public int get(int index) {
        indexValidation(index);

        int currentIndex = 0;
        Node currentNode = head;

        while (currentIndex < index) {
            currentNode = head.next;
            currentIndex++;
        }
        return currentNode.value;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = head;

        while (currentNode != null) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        int[] arr = new int[size];
        int count = 0;
        Node currentNode = head;

        while (currentNode != null) {
            arr[count] = currentNode.value;
            count++;
            currentNode = currentNode.next;
        }
        return arr;
    }

    private void indexValidation(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
