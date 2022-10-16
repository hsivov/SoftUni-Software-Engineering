package Exams.JavaAdvancedRetakeExam_19August2020.VetClinic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.data = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {

        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
         return Collections.max(data, Comparator.comparingInt(Pet::getAge));
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append("The clinic has the following patients:")
                .append(System.lineSeparator());
        for (Pet pet : data) {
            sb.append(String.format("%s %s%n", pet.getName(), pet.getOwner()));
        }
        return sb.toString();
    }
}
