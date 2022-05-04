package managment.interfaces;

import footballclub.entity.Player;
import footballclub.entity.Team;

public interface PlayerService {
    /**
     * Create player
     */
    Player createPlayer(String name, String surname,
                        String country, Integer age,
                        String position);
    /**
     * Update team
     */
    void updateTeam(Player player, Team team);

    /**
     * Update position
     */
    void updatePosition(Player player, String position);
}
