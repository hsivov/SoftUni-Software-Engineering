import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Engine implements Runnable{

    private final EntityManager entityManager;
    private BufferedReader bufferedReader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.print("Select ex number: ");
        try {
            int exNum = Integer.parseInt(bufferedReader.readLine());

            switch (exNum) {
                case 2 -> changeCasing();
                case 3 -> containsEmployee();
                case 4 -> employeesWithASalaryOver50000();
                case 5 -> employeesFromDepartment();
                case 6 -> addingANewAddressAndUpdatingTheEmployee();
                case 7 -> addressesWithEmployeeCount();
                case 8 -> getEmployeesWithProject();
                case 9 -> findTheLatest10Projects();
                case 10 -> increaseSalaries();
                case 11 -> findEmployeesByFirstName();
                case 12 -> employeesMaximumSalaries();
                case 13 -> removeTowns();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }

    }

    private void changeCasing() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Town t " +
                "SET t.name = UPPER(t.name) " +
                "WHERE length(t.name) <= 5");

        System.out.println(query.executeUpdate());

        entityManager.getTransaction().commit();
    }

    private void containsEmployee() throws IOException {
        System.out.println("Enter employee full name: ");
        String[] fullName = bufferedReader.readLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

        Long singleResult = entityManager
                .createQuery("SELECT count(e) FROM Employee e WHERE e.firstName =: f_name AND e.lastName =: l_name", Long.class)
                .setParameter("f_name", firstName)
                .setParameter("l_name", lastName)
                .getSingleResult();

        System.out.println(singleResult == 0 ? "No" : "Yes");
    }

    private void employeesWithASalaryOver50000() {
        entityManager
                .createQuery("SELECT e FROM Employee e WHERE e.salary > :min_salary", Employee.class)
                .setParameter("min_salary", BigDecimal.valueOf(50000L))
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    private void employeesFromDepartment() {
        entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name =: d_name " +
                        "ORDER BY e.salary, e.id", Employee.class)
                .setParameter("d_name", "Research and Development")
                .getResultStream()
                .forEach(employee -> {
                    System.out.printf("%s %s from %s - $%.2f%n",
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getDepartment().getName(),
                            employee.getSalary());
                });
    }

    private void addingANewAddressAndUpdatingTheEmployee() throws IOException {
        System.out.println("Enter employee last name: ");
        String lastName = bufferedReader.readLine();

        Employee employee = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.lastName = :l_name", Employee.class)
                .setParameter("l_name", lastName)
                .getSingleResult();

        Address address = createAddress();

        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private Address createAddress() {
        Address address = new Address();
        address.setText("Vitoshka 15");

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        return address;
    }

    private void addressesWithEmployeeCount() {
        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address a " +
                        "ORDER BY size(a.employees) DESC ", Address.class)
                .setMaxResults(10)
                .getResultList();

        addresses.forEach(address -> {
            System.out.printf("%s, %s - %d employees%n",
                    address.getText(),
                    address.getTown() == null
                    ? "Unknown" : address.getTown().getName(),
                    address.getEmployees().size());
        });
    }
    private void getEmployeesWithProject() throws IOException {
        System.out.println("Enter employee id: ");
        int id = Integer.parseInt(bufferedReader.readLine());

        Employee employee = entityManager.find(Employee.class, id);

        System.out.printf("%s %s - %s%n",
                employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
        employee.getProjects().stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project -> System.out.printf("      %s%n", project.getName()));
    }

    private void findTheLatest10Projects() {
        entityManager
                .createQuery("SELECT p FROM Project p " +
                        "ORDER BY startDate desc, name", Project.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(project -> {
                    System.out.printf("Project name: %s%n" +
                            "      Project Description: %s%n" +
                            "      Project Start Date:%s%n" +
                            "      Project End Date: %s%n",
                            project.getName(),
                            project.getDescription(),
                            project.getStartDate(),
                            project.getEndDate());
                });
    }

    private void increaseSalaries() {
        entityManager.getTransaction().begin();
        int affectedRows = entityManager
                .createQuery("UPDATE Employee e " +
                        "SET e.salary = e.salary * 1.2 " +
                        "WHERE e.department.id IN :ids")
                .setParameter("ids", Set.of(1, 2, 4, 11))
                .executeUpdate();
        entityManager.getTransaction().commit();

        System.out.println("Affected Rows: " + affectedRows);
    }

    private void findEmployeesByFirstName() throws IOException {
        System.out.println("Please enter start pattern: ");
        String pattern = bufferedReader.readLine();
        entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.firstName LIKE : pattern ", Employee.class)
                .setParameter("pattern", pattern + "%")
                .getResultStream()
                .forEach(employee -> {
                    System.out.printf("%s %s - %s - ($%.2f)%n",
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getJobTitle(),
                            employee.getSalary());
                });
    }

    @SuppressWarnings("unchecked")
    private void employeesMaximumSalaries() {
        List<Object[]> rows = entityManager
                .createNativeQuery("SELECT d.name, MAX(e.salary) AS 'm_salary' FROM departments d\n" +
                        "JOIN employees e ON d.department_id = e.department_id\n" +
                        "GROUP BY d.name\n" +
                        "HAVING m_salary NOT BETWEEN 30000 AND 70000;")
                .getResultList();

        rows.forEach(row -> System.out.printf("%s %.2f%n", row[0], row[1]));
    }

    private void removeTowns() throws IOException {
        System.out.println("Enter town name: ");
        String townName = bufferedReader.readLine();

        Town town = entityManager.createQuery("SELECT t FROM Town t " +
                "WHERE t.name = :t_name", Town.class)
                .setParameter("t_name", townName)
                .getSingleResult();

        setEmployeeAddressToNull(townName);

        int affectedRows = removeAddressesByTownId(town.getId());

        entityManager.getTransaction().begin();
        entityManager.remove(town);
        entityManager.getTransaction().commit();

        System.out.printf("%d address in %s deleted", affectedRows, town.getName());
    }

    private int removeAddressesByTownId(Integer id) {

        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address a " +
                        "WHERE a.town.id = :p_id", Address.class)
                .setParameter("p_id", id)
                .getResultList();

        entityManager.getTransaction().begin();
        addresses.forEach(entityManager::remove);
        entityManager.getTransaction().commit();

        return addresses.size();
    }

    private void setEmployeeAddressToNull(String townName) {

        String query = "SELECT e FROM Employee AS e WHERE e.address.town.name = '" + townName + "'";

        List<Employee> employees = entityManager.createQuery(query).getResultList();
        entityManager.getTransaction().begin();
        for (Employee employee : employees) {
            employee.setAddress(null);
            entityManager.persist(employee);
        }
        entityManager.getTransaction().commit();
    }
}
