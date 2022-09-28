package StreamsFilesAndDirectories.Exercises;

import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Course course = new Course();
        course.name = "Advanced Java SoftUni September 2022";
        course.numberOfStudents = 250;

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(
                "Advanced-Java/StreamsFilesAndDirectories/Exercises/Exercises Resources/course.ser"
        ));
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(
                        "Advanced-Java/StreamsFilesAndDirectories/Exercises/Exercises Resources/course.ser"
        ));
        output.writeObject(course);

        Course courseFromFile = (Course) input.readObject();
        System.out.println(courseFromFile.name);
        System.out.println(courseFromFile.numberOfStudents);
    }
}
