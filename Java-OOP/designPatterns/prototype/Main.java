package designPatterns.prototype;

public class Main {
    public static void main(String[] args) {

        Prototype employee1 = new EmployeeRecord(1, "Stefan", "Manager", 2000, "Varna");
        Prototype employee2 = employee1.clone();
    }
}
