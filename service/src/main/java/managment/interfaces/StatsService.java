package managment.interfaces;

import footballclub.entity.Player;
import footballclub.entity.Team;

public interface StatsService {
    /**
     * Player statistics
     */
    String statsPlayer(Player player);

    /**
     * Team statistics
     */
    String statsTeam(Team team);
}
