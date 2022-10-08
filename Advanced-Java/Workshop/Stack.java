package Workshop;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Custom implementation of LIFO data structure
 */
public class Stack {

    private static class Node {
        private final int element;
        private Node prev;

        private Node(int element) {
            this.element = element;
        }
    }

    private Node top;
    private int size;

    public void push(int element) {
        Node newNode = new Node(element);
        newNode.prev = top;
        top = newNode;
        size++;
    }

    public int pop() {
        ensureNotEmpty();
        int value = top.element;
        top = top.prev;
        size--;
        return value;
    }

    public int peek() {
        ensureNotEmpty();
        return top.element;
    }

    private void ensureNotEmpty() {
        if (top == null) {
            throw new NoSuchElementException("Stack is empty");
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void forEach(Consumer<Integer> consumer) {

        Node current = top;

        while (current != null) {
            consumer.accept(current.element);
            current = current.prev;
        }
    }
}
