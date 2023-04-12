package ExamPrep.viceCity.models.neighbourhood;

import ExamPrep.viceCity.models.guns.Gun;
import ExamPrep.viceCity.models.players.Player;
import ExamPrep.viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Repository<Gun> gunRepository = mainPlayer.getGunRepository();
        Deque<Player> players = new ArrayDeque<>(civilPlayers);
        Deque<Gun> guns = new ArrayDeque<>(gunRepository.getModels());

        Player player = players.poll();
        Gun gun = guns.poll();

        while (player != null && gun != null) {
            while (gun.canFire() && player.isAlive()) {
                int fire = gun.fire();
                player.takeLifePoints(fire);
            }

            if (gun.canFire()) {
                player = players.poll();
            } else if (player.isAlive()) {
                gun = guns.poll();
            }
        }

        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.isAlive()) {
                Deque<Gun> civilPlayersGuns = new ArrayDeque<>(civilPlayer.getGunRepository().getModels());
                Gun civilPlayerGun = civilPlayersGuns.poll();
                while (civilPlayerGun != null) {
                    while (civilPlayerGun.canFire() && mainPlayer.isAlive()) {
                        int fire = civilPlayerGun.fire();
                        mainPlayer.takeLifePoints(fire);
                    }

                    if (!mainPlayer.isAlive()) {
                        return;
                    }

                    civilPlayerGun = civilPlayersGuns.poll();
                }
            }
        }
    }
}
