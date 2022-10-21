package Workshop;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Custom implementation of LIFO data structure
 */
public class Stack<T> implements Iterable<T> {

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

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            Node<T> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T element = current.element;
                current = current.prev;
                return element;
            }
        };
    }
}
