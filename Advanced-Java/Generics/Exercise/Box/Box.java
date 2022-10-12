package Generics.Exercise.Box;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Comparable<T>> {

    private final List<T> values;

    Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T temp = values.get(firstIndex);
        values.set(firstIndex, values.get(secondIndex));
        values.set(secondIndex, temp);
    }

    public int countGreater(T elementToCompare) {
        int count = 0;

        for (T element : values) {
            if (element.compareTo(elementToCompare) > 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T value : values) {
            sb.append(String.format("%s: %s%n", value.getClass().getName(), value));
        }
        return sb.toString();
    }
}
