package ExamPrep.football.entities.field;

import ExamPrep.football.common.ConstantMessages;
import ExamPrep.football.common.ExceptionMessages;
import ExamPrep.football.entities.player.Player;
import ExamPrep.football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseField implements Field {

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (stringIsNullOrEmpty(name)) {
            throw new NullPointerException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int sumEnergy() {
        return supplements.stream().map(Supplement::getEnergy).mapToInt(Integer::intValue).sum();
    }

    public void addPlayer(Player player) {
        if (players.size() < capacity) {
            players.add(player);
        } else {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    public void drag() {
        for (Player player : players) {
            player.stimulation();
        }
    }

    public String getInfo() {

        String playerReport = players.isEmpty()
                ? "none"
                : players.stream().map(Player::getName).collect(Collectors.joining(" "));

        StringBuilder output = new StringBuilder();

        output.append(String.format("%s (%s):", name, getClass().getSimpleName())).append(System.lineSeparator());
        output.append("Player: ");
        output.append(playerReport);
        output.append(System.lineSeparator())
                .append("Supplement: ").append(supplements.size());
        output.append(System.lineSeparator())
                .append("Energy: ").append(sumEnergy());
        return output.toString();
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    private static boolean stringIsNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}
