package Workshop;

import java.util.Iterator;
import java.util.function.Consumer;

public class SmartArray<T> implements Iterable<T> {

    private static final int INITIAL_CAPACITY = 4;
    private Object[] data;
    private int size;

    public class SmartArrayIterator implements Iterator<T> {
        int index = 0;
        @Override
        public boolean hasNext() {
            return index < getSize();
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            return (T) data[index++];
        }
    }

    SmartArray() {
        this.size = 0;
        this.data = new Object[INITIAL_CAPACITY];
    }

    public void add(T element) {
        if (size == data.length) {
            data = grow();
        }

        data[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        ensureIndex(index);

        return (T) data[index];
    }

    public T remove(int index) {
        T removedElement = get(index);

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = 0;
        size--;
        return removedElement;
    }

    public void remove(T element) {
        if (indexOf(element) != -1) {
            remove(indexOf(element));
        }
    }

    public boolean contains(T element) {

        for (int i = 0; i < size; i++) {
            T next = get(i);

            if (element.equals(next)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {

            if (contains(element)) {
                return i;
            }
        }
        return -1;
    }

    public void add(int index, T element) {
        T lastElement = get(size - 1);

        for (int i = size - 1; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = element;
        add(lastElement);
    }

    public void set(int index, T element) {
        ensureIndex(index);
        data[index] = element;
    }

    public int getSize() {
        return size;
    }

    public int size() {
        return getSize();
    }

    private Object[] grow() {
        int newLength = data.length * 2;

        Object[] newData = new Object[newLength];

        System.arraycopy(data, 0, newData, 0, data.length);
        return newData;
    }

    private void ensureIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SmartArrayIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    public static <T extends Comparable<T>> void sort(SmartArray<T> tSmartArray) {
        for (int i = 0; i < tSmartArray.getSize() - 1; i++) {
            for (int j = 0; j < tSmartArray.getSize() - i - 1; j++) {

                if (tSmartArray.get(j).compareTo(tSmartArray.get(j + 1)) > 0) {
                    T temp = tSmartArray.get(j);
                    tSmartArray.set(j, tSmartArray.get(j + 1));
                    tSmartArray.set(j + 1, temp);
                }
            }
        }
    }
}
