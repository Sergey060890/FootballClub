package managment.interfaces;


import DTO.TeamDTO;
import footballclub.entity.Player;
import footballclub.entity.Team;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

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
//    void deletePlayerWithTeam(Player player)
//            throws InvocationTargetException,
//            NoSuchMethodException, IllegalAccessException;

//    /**
//     * Print AllTeam
//     */
//    List<Team> showAllTeam();

    /**
     * FindAllTEam
     */
    List<TeamDTO> findAll();

    Player showOnePlayerInfo(Integer id) throws SQLException;

    /**
     * Print AllPlayerInfo
     */

    Set<Player> showAllPlayerTeamInfo(Integer id);

    /**
     * UpdateTeam
     */
    void updateTeam(Integer id, String teamName, String teamCity,
                    String teamCountry, String teamStadium,
                    String teamCoach) throws SQLException;

    /**
     * DeleteTeam
     */
    void deleteTeam(Integer id) throws SQLException;

    TeamDTO findTeamById(Integer id) throws SQLException;

    Team findTeamId(Integer id) throws SQLException;

    void deleteAllPlayerTeam(TeamService teamService, PlayerService playerService, Integer id) throws SQLException;

    void deleteAllGameTeam(GameService gameService, Integer id) throws SQLException;
}
