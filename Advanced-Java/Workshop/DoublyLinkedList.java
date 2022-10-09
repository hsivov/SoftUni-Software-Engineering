package Workshop;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element) {
        Node newNode = new Node(element);

        if (!isEmpty()) {
            newNode.next = head;
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    public void addLast(int element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }
        Node newNode = new Node(element);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        int value = head.value;
        size--;
        head = head.next;
        if (size > 1) {
            head.prev = null;
        }
        if (isEmpty()) {
            head = null;
            tail = null;
        }
        return value;
    }

    public int removeLast() {
        if (size < 2) {
            return removeFirst();
        }

        int result = tail.value;
        tail = tail.prev;
        tail.next = null;
        size--;
        return result;
    }

    public int get(int index) {
        indexValidation(index);

        int currentIndex;
        Node currentNode;

        if (index > size / 2) {
            currentNode = tail;
            currentIndex = size - 1;

            while (currentIndex > index){
                currentNode = currentNode.prev;
                currentIndex--;
            }

        } else {
            currentNode = head;
            currentIndex = 0;

            while (currentIndex < index) {
                currentNode = currentNode.next;
                currentIndex++;
            }
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
