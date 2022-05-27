package managment.implementation;

import footballclub.dao.implementations.EnityDaoImplPlayer;
import footballclub.dao.interfaces.PlayerDao;
import footballclub.entity.Player;
import footballclub.entity.Team;
import managment.interfaces.PlayerService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SERGEY060890
 * @version 1.0
 * @create 2022-05-03 13:17
 */
public class PlayerServiceImpl implements PlayerService {
    PlayerDao enityDaoImplPlayer =
            new EnityDaoImplPlayer();

    public static List<Player> players = new ArrayList<>();

    @Override
    public Player createPlayer(String name, String surname,
                               String country, Integer age,
                               String position) {
        Player player = Player.builder()
                .player_name(name)
                .player_surname(surname)
                .country(country)
                .age(age)
                .position(position)
                .build();
        enityDaoImplPlayer.create(player);
        players.add(player);
        return player;
    }

    @Override
    public void updateTeam(Player player, Team team) {
        player.setTeamPlayer(team);
        enityDaoImplPlayer.update(player);
    }

    @Override
    public void updatePosition(Player player, String position) {
        player.setPosition(position);
        enityDaoImplPlayer.update(player);
    }
}
