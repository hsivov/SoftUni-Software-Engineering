package blueOrigin;

import java.util.ArrayList;
import java.util.Collection;

public class Spaceship {
    private static final String INVALID_SPACESHIP_NAME = "Invalid spaceship name!";
    private static final String INVALID_CAPACITY = "Invalid capacity!";
    private static final String SPACESHIP_FULL = "Spaceship is full!";
    private static final String ASTRONAUT_EXIST = "Astronaut %s is already in!";
    private static final int ZERO_CAPACITY = 0;

    private int capacity;
    private String name;
    private Collection<Astronaut> astronauts;

    public Spaceship(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.astronauts = new ArrayList<>();
    }

    public int getCount() {
        return this.astronauts.size();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Astronaut astronaut) {
        if (astronauts.size() == this.getCapacity()) {
            throw new IllegalArgumentException(SPACESHIP_FULL);
        }

        boolean astronautExists = this.astronauts
                .stream()
                .anyMatch(a -> a.getName().equals(astronaut.getName()));

        if (astronautExists) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_EXIST, astronaut.getName()));
        }

        this.astronauts.add(astronaut);
    }

    public boolean remove(String astronautName) {
        Astronaut astronaut = this.astronauts
                .stream()
                .filter(a -> a.getName().equals(astronautName))
                .findFirst()
                .orElse(null);

        boolean isRemove = this.astronauts.remove(astronaut);
        return isRemove;
    }

    private void setCapacity(int capacity) {
        if (capacity < ZERO_CAPACITY) {
            throw new IllegalArgumentException(INVALID_CAPACITY);
        }

        this.capacity = capacity;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(INVALID_SPACESHIP_NAME);
        }

        this.name = name;
    }
}
