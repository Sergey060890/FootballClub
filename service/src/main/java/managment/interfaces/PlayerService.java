package managment.interfaces;

import dto.PlayerDTO;
import footballclub.entity.Player;
import footballclub.entity.Team;

import java.sql.SQLException;
import java.util.List;

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

    Player addPlayerInTeam(Player player, Team team);

    /**
     * Update position
     */
    void updatePosition(Player player, String position);

    List<PlayerDTO> findAll();

    void deletePlayer(Integer id) throws SQLException;

    public Player findPlayerById(Integer id) throws SQLException;

    public void updatePlayer(Integer id, String playerName, String playerSurname,
                             String country, Integer age,
                             String position) throws SQLException;
}
