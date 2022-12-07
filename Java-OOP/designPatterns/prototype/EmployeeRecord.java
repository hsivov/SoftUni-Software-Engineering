package designPatterns.prototype;

public class EmployeeRecord implements Prototype{

    private int id;
    private String name;
    private String designate;
    private double salary;
    private String address;

    public EmployeeRecord() {
        System.out.println("Files of the employees of the Ministry of Interior Sofia");
        System.out.println("--------------------------------------------------------");
        System.out.println("Id" + "\t" + "Name" + "\t" + "Designation" + "\t\t" + "Salary" + "\t\t" + "Address");
    }

    public EmployeeRecord(int id, String name, String designate, double salary, String address) {
        this();
        this.id = id;
        this.name = name;
        this.designate = designate;
        this.salary = salary;
        this.address = address;
    }

    public void showRecord() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "EmployeeRecord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", designate='" + designate + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public Prototype clone() {
        return new EmployeeRecord(id, name, designate, salary, address);
    }
}
