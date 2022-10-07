package DefiningClasses.Exercise.CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> employeeList = new ArrayList<>();
        double highestAverageSalary = 0;
        String bestDepartment = "";

        for (int line = 1; line <= n; line++) {
            String[] input = scanner.nextLine().split(" ");

            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            String email = "n/a";
            int age = -1;

            if (input.length == 5) {
                if (input[4].contains("@")) {
                    email = input[4];
                } else {
                    age = Integer.parseInt(input[4]);
                }
            } else if (input.length == 6) {
                email = input[4];
                age = Integer.parseInt(input[5]);
            }
            Employee employee = new Employee(name, salary, position, department, email, age);
            employeeList.add(employee);
        }
        List<String> departmentList = employeeList.stream()
                .map(Employee::getDepartment).distinct().collect(Collectors.toList());

        for (String department : departmentList) {

            double average = employeeList.stream()
                    .filter(employee -> employee.getDepartment().equals(department))
                    .map(Employee::getSalary)
                    .mapToDouble(Double::doubleValue)
                    .average().orElse(0);

            if (average > highestAverageSalary) {
                highestAverageSalary = average;
                bestDepartment = department;
            }
        }

        System.out.println("Highest Average Salary: " + bestDepartment);

        employeeList.sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        for (Employee employee : employeeList) {
            if (employee.getDepartment().equals(bestDepartment)) {
                System.out.println(employee);
            }
        }
    }
}
