package IteratorsAndComparators.ListyIterator;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {

    private List<String> elements;
    private int currentIndex;

    public ListyIterator(String... elements) {
        this.elements = List.of(elements);
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex + 1 < elements.size();
    }

    public boolean move() {
        if (hasNext()){
            currentIndex++;
            return true;
        }
        return false;
    }

    public void print() {
        if (elements.isEmpty()){
            throw new IllegalStateException("Invalid Operation!");
        } else {
            System.out.println(elements.get(currentIndex));
        }
    }

    public void printAll() {
        if (elements.isEmpty()){
            throw new IllegalStateException("Invalid Operation!");
        } else {
            elements.forEach(e -> System.out.printf("%s ", e));
            System.out.println();
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {

            int internalIndex = 0;

            @Override
            public boolean hasNext() {
                return internalIndex < elements.size();
            }

            @Override
            public String next() {
                String element = elements.get(internalIndex);
                internalIndex++;
                return element;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        Iterable.super.forEach(action);
    }
}
