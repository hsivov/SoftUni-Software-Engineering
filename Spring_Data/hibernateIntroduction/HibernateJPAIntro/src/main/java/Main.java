import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = new Student("TeoNew");
        em.persist(student);

        student.setName("TeoUpdated");
        em.persist(student);

        Student findStudent = em.find(Student.class, 5);
        em.remove(findStudent);
        System.out.println(findStudent);

        List<Student> studentList = em.createQuery("FROM Student", Student.class).getResultList();

        studentList.forEach(System.out::println);

        em.getTransaction().commit();
    }
}
