package ExamPrep.viceCity.models.neighbourhood;

import ExamPrep.viceCity.models.players.Player;

import java.util.Collection;

public interface Neighbourhood {
    void action(Player mainPlayer, Collection<Player> civilPlayers);
}
