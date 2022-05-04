package managment.interfaces;


import footballclub.entity.Player;
import footballclub.entity.Team;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface TeamService {
    /**
     * Create team
     */

    Team createTeam(String teamName, String teamCity,
                    String teamCountry, String teamStadium,
                    String teamCoach);

    /**
     * Add player in team
     */
    Player addPlayerInTeam(Player player, Team team);

    /**
     * Delete player with team
     */
    void deletePlayerWithTeam(Player player)
            throws InvocationTargetException,
            NoSuchMethodException, IllegalAccessException;

    /**
     * Print OnePlayerInfo
     */
    String showOnePlayerInfo(Player player);

    /**
     * Print OnePlayerInfo
     */
    List<Player> showAllPlayerTeamInfo(Team team);
}
