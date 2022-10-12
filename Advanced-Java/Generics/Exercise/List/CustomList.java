package Generics.Exercise.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class CustomList <T extends Comparable<T>> implements Iterable<T> {

    private final List<T> values;

    CustomList(){
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public T get(int index) {
        return values.get(index);
    }

    public T remove(int index) {
        return values.remove(index);
    }

    public boolean contains(T element) {
        return values.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(values, firstIndex, secondIndex);
    }

    public int countGreaterThan(T element) {
        return (int) values.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }

    public T getMax() {
        return values.stream()
                .max(Comparable::compareTo).get();
    }

    public T getMin() {
        return values.stream()
                .min(Comparable::compareTo).get();
    }
    @Override
    public Iterator<T> iterator() {
        return values.listIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    public int size() {
        return values.size();
    }
}
