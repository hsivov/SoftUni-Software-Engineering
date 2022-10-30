package ExamPreparation.JavaAdvancedRetakeExam_18August2022.sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {

    private List<Elephant> data;
    private int capacity;

    public Habitat(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Elephant elephant) {
        if (data.size() < capacity) {
            data.add(elephant);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(e -> e.getName().equals(name));
    }

    public Elephant getElephant(String retiredFrom) {
        return data.stream()
                .filter(elephant -> elephant.getRetiredFrom().equals(retiredFrom)).findAny().orElse(null);
    }

    public Elephant getOldestElephant() {
        return data.stream().max(Comparator.comparingInt(Elephant::getAge)).orElse(null);
    }

    public int getAllElephants() {
        return data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder("Saved elephants in the park:");
        for (Elephant elephant : data) {
            sb.append(System.lineSeparator());
            sb.append(String.format("%s came from: %s", elephant.getName(), elephant.getRetiredFrom()));
        }
        return sb.toString();
    }
}
