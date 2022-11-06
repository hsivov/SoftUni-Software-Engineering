package Inheritance.computer;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final String name;
    private final List<Component> components;

    public Computer(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public double getTotalPrice() {
        return components.stream().mapToDouble(Component::getPrice).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(": ").append(name).append(System.lineSeparator());
        sb.append("Configuration:");
        components.forEach(sb::append);

        return sb.toString();
    }
}
