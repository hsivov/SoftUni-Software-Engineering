package Exams.Retake_14Dec2022.christmas;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {

    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return data.size();
    }

    public String insert(Student student) {
        if (getCount() == capacity) {
            return "The hall is full.";
        }
        if (data.contains(student)) {
            return "Student is already in the hall.";
        }
        data.add(student);
        return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
    }

    public String remove(Student student) {
        boolean removed = data.remove(student);
        if (!removed) {
            return "Student not found.";
        }
        return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
    }

    public Student getStudent(String firstName, String lastName) {
        return data.stream()
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hall size: %d", getCount()));
        for (Student student : data) {
            sb.append(System.lineSeparator())
                    .append(student);
        }
        return sb.toString();
    }
}
