package Workshop;

import java.util.function.Consumer;

public class SmartArray {

    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;

    SmartArray () {
        this.size = 0;
        this.data = new int[INITIAL_CAPACITY];
    }

    public void add(int element) {
        if (size == data.length) {
            data = grow();
        }

        data[size++] = element;
    }

    public int get(int index) {
        ensureIndex(index);

        return data[index];
    }

    public int remove(int index) {
        int removedElement = get(index);

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = 0;
        size--;
        return removedElement;
    }

    public boolean contains(int element) {

        for (int i = 0; i < size; i++) {
            int next = data[i];

            if (element == next){
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element) {
        int lastElement = data[size - 1];

        for (int i = size - 1; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = element;
        add(lastElement);
    }

    public void set(int index, int element) {
        ensureIndex(index);
        data[index] = element;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(data[i]);
        }
    }

    public int size() {
        return size;
    }
    private int[] grow() {
        int newLength = data.length * 2;

        int[] newData = new int[newLength];

        System.arraycopy(data, 0, newData, 0, data.length);
        return newData;
    }

    private void ensureIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }
}
