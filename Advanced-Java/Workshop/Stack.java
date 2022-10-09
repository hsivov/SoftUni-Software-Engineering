package Workshop;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Custom implementation of LIFO data structure
 */
public class Stack<T> {

    private static class Node<E> {
        private final E element;
        private Node<E> prev;

        private Node(E element) {
            this.element = element;
        }
    }

    private Node<T> top;
    private int size;

    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.prev = top;
        top = newNode;
        size++;
    }

    public T pop() {
        ensureNotEmpty();
        T value = top.element;
        top = top.prev;
        size--;
        return value;
    }

    public T peek() {
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

    public void forEach(Consumer<T> consumer) {

        Node<T> current = top;

        while (current != null) {
            consumer.accept(current.element);
            current = current.prev;
        }
    }
}
