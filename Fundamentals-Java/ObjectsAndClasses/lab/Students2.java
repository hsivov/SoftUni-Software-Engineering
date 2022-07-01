package ObjectsAndClasses.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students2 {
    static  class Student{
        String firstName;
        String lastName;
        String age;
        String town;

        Student(String firstName, String lastName, String age, String town){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.town = town;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getAge() {
            return age;
        }

        public String getTown() {
            return town;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public void setTown(String town) {
            this.town = town;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Student> studentList = new ArrayList<>();

        while (!input.equals("end")){
            String[] inputStudentArr = input.split(" ");
            String firstName = inputStudentArr[0];
            String lastName = inputStudentArr[1];
            String age = inputStudentArr[2];
            String town = inputStudentArr[3];

            if (!isStudentExisting(studentList, firstName, lastName)){
                Student currentStudent = new Student(firstName, lastName, age, town);
                studentList.add(currentStudent);
            }

            if (isStudentExisting(studentList, firstName, lastName)) {
                Student student = getStudent(studentList, firstName,lastName);

                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setTown(town);
            }

            input = scanner.nextLine();
        }
        String searchTown = scanner.nextLine();

        for (Student student : studentList){
            if (student.getTown().equals(searchTown)){
                System.out.printf("%s %s is %s years old%n",
                        student.getFirstName(),
                        student.getLastName(),
                        student.getAge());
            }
        }

    }
    private static boolean isStudentExisting (List<Student> students, String firstName, String lastName){
        for (Student student : students){
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                return true;
            }
        }
        return false;
    }

    private static Student getStudent(List<Student> students, String firstName, String lastName){
        Student existingStudent = null;

        for (Student student : students){
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                existingStudent = student;
            }
        }
        return existingStudent;
    }
}
