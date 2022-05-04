package managment.implementation;

import footballclub.dao.EnityDaoImplPlayer;
import footballclub.entity.Player;
import footballclub.entity.Team;
import managment.interfaces.PlayerService;

/**
 * @author SERGEY060890
 * @version 1.0
 * @create 2022-05-03 13:17
 */
public class PlayerServiceImpl implements PlayerService {
    EnityDaoImplPlayer enityDaoImplPlayer =
            new EnityDaoImplPlayer(Player.class);

    public PlayerServiceImpl(EnityDaoImplPlayer enityDaoImplPlayer) {
        this.enityDaoImplPlayer = enityDaoImplPlayer;
    }

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
        enityDaoImplPlayer.insert(player);
        return player;
    }

    @Override
    public void updateTeam(Player player, Team team) {
        player.setTeam(team);
        enityDaoImplPlayer.update(player);
    }

    @Override
    public void updatePosition(Player player, String position) {
        player.setPosition(position);
        enityDaoImplPlayer.update(player);
    }
}
