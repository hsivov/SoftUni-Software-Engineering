package StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.util.ArrayList;

public class SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(5.66);
        doubles.add(6.00);
        doubles.add(4.54);
        doubles.add(5.85);

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(
                "Advanced-Java/StreamsFilesAndDirectories/Exercises/Exercises Resources/list.ser"
        ));
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(
                "Advanced-Java/StreamsFilesAndDirectories/Exercises/Exercises Resources/list.ser"
        ));

        outputStream.writeObject(doubles);

        ArrayList<?> listFromFile = (ArrayList<?>) inputStream.readObject();

        for (Object o : listFromFile) {
            System.out.println(o);
        }
    }
}
