package Retake_19Dec2022.magicGame.models.magicians;

import Retake_19Dec2022.magicGame.models.magics.Magic;

import static Retake_19Dec2022.magicGame.common.ExceptionMessages.*;

public abstract class MagicianImpl implements Magician{

    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        setUsername(username);
        setHealth(health);
        setProtection(protection);
        setMagic(magic);
        this.isAlive = true;
    }

    @Override
    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    @Override
    public void takeDamage(int points) {
        if (protection > 0) {
            protection -= points;
        } else {
            health -= points;
        }
        if (health <= 0) {
            isAlive = false;
        }
    }

    @Override
    public int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    @Override
    public int getProtection() {
        return protection;
    }

    private void setProtection(int protection) {
        if (protection < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public Magic getMagic() {
        return magic;
    }

    private void setMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public String toString() {

        return String.format("%s: %s", getClass().getSimpleName(), username) + System.lineSeparator() +
                String.format("Health: %d", health) + System.lineSeparator() +
                String.format("Protection: %d", protection) + System.lineSeparator() +
                String.format("Magic: %s", magic.getName());
    }
}
