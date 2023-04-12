package ExamPrep.viceCity.core;

import ExamPrep.viceCity.core.interfaces.Controller;
import ExamPrep.viceCity.models.guns.Gun;
import ExamPrep.viceCity.models.guns.Pistol;
import ExamPrep.viceCity.models.guns.Rifle;
import ExamPrep.viceCity.models.neighbourhood.GangNeighbourhood;
import ExamPrep.viceCity.models.neighbourhood.Neighbourhood;
import ExamPrep.viceCity.models.players.CivilPlayer;
import ExamPrep.viceCity.models.players.MainPlayer;
import ExamPrep.viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;

import static ExamPrep.viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {

    Player mainPlayer;
    Map<String, Player> civilPlayers;
    Deque<Gun> guns;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new LinkedHashMap<>();
        this.guns = new ArrayDeque<>();
    }

    @Override
    public String addPlayer(String name) {
        Player civilPlayer = new CivilPlayer(name);
        civilPlayers.put(civilPlayer.getName(), civilPlayer);

        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {

        Gun gun;
        if (type.equals("Pistol")) {
            gun = new Pistol(name);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name);
        } else {
            return GUN_TYPE_INVALID;
        }

        guns.offer(gun);

        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (guns.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }

        Gun gun;

        if (name.equals("Vercetti")) {
            gun = guns.poll();
            mainPlayer.getGunRepository().add(gun);

            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        }

        Player civilPlayer = civilPlayers.get(name);
        if (civilPlayer == null) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        gun = guns.poll();
        civilPlayer.getGunRepository().add(gun);

        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), civilPlayer.getName());
    }

    @Override
    public String fight() {
        Neighbourhood neighbourhood = new GangNeighbourhood();

        neighbourhood.action(mainPlayer, civilPlayers.values());

        if (mainPlayer.getLifePoints() == 100 && civilPlayers.values().stream().allMatch(player -> player.getLifePoints() == 50)) {

            return FIGHT_HOT_HAPPENED;
        }

        long leftAlive = civilPlayers.values().stream()
                .filter(Player::isAlive)
                .count();

        return FIGHT_HAPPENED + System.lineSeparator() +
                String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()) + System.lineSeparator() +
                String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, civilPlayers.size() - leftAlive) + System.lineSeparator() +
                String.format(CIVIL_PLAYERS_LEFT_MESSAGE, leftAlive);
    }
}
