package Exams.JavaAdvancedExam_26June2021.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {

    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        return data.stream()
                .filter(pet -> pet.getName().equals(name) && pet.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
       StringBuilder sb = new StringBuilder("The grooming salon has the following clients:");

        for (Pet pet : data) {
            sb.append(System.lineSeparator());
            sb.append(String.format("%s %s", pet.getName(), pet.getOwner()));
        }

        return sb.toString();
    }
}
