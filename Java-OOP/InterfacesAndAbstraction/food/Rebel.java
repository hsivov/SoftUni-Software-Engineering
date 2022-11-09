package InterfacesAndAbstraction.food;

public class Rebel implements Person, Buyer{

    private final String name;
    private final int age;
    private final String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = 0;
    }

    @Override
    public void buyFood() {
        food += 5;
    }

    @Override
    public int getFood() {
        return food;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }
}
