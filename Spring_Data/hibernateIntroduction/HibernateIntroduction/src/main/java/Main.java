import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory =
                cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student student = new Student("John");
        session.save(student);

        Student student1 = session.get(Student.class, 5);
        System.out.println(student1);

        List<Student> allStudents = session
                .createQuery("FROM Student AS s  WHERE s.name = 'Pesho2'", Student.class)
                .list();

        allStudents.forEach(System.out::println);

        session.getTransaction().commit();
        session.close();
    }
}
