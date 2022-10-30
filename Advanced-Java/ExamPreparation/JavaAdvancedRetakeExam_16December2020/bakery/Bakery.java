package ExamPreparation.JavaAdvancedRetakeExam_16December2020.bakery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bakery {

    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return employees.removeIf(p -> p.getName().equals(name));
    }

    public Employee getEmployee(String name) {
        return employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElseThrow();
    }

    public Employee getOldestEmployee() {
        return Collections.max(employees, Comparator.comparingInt(Employee::getAge));
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Employees working at Bakery %s:", getName()));
        for (Employee employee : employees) {
            sb.append(System.lineSeparator());
            sb.append(employee);
        }
        return sb.toString();
    }
}
