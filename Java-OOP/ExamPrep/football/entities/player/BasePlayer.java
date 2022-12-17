package ExamPrep.football.entities.player;

import ExamPrep.football.common.ExceptionMessages;

public abstract class BasePlayer implements Player{

    private String name;
    private String nationality;
    private double kg;
    private int strength;

    protected BasePlayer(String name, String nationality, double kg, int strength) {
        this.name = name;
        this.nationality = nationality;
        this.kg = kg;
        this.strength = strength;
    }

    @Override
    public void setName(String name) {
        if (stringIsNullOrEmpty(name)) {
            throw new NullPointerException(ExceptionMessages.PLAYER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setNationality(String nationality) {
        if (stringIsNullOrEmpty(nationality)) {
            throw new NullPointerException(ExceptionMessages.PLAYER_NATIONALITY_NULL_OR_EMPTY);
        }
        this.nationality = nationality;
    }

    public void setStrength(int strength) {
        if (strength <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    private static boolean stringIsNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}
