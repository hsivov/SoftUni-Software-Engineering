package Exams.Exam_22Oct2022.shelter;

public class Animal {

    private String name;
    private int age;
    private String caretaker;

    public Animal(String name, int age, String caretaker) {
        this.name = name;
        this.age = age;
        this.caretaker = caretaker;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCaretaker() {
        return caretaker;
    }

    @Override
    public String toString() {
        return String.format("%s %d (%s)", name, age, caretaker);
    }
}
