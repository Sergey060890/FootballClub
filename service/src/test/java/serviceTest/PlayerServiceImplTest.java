package serviceTest;

import footballclub.dao.EnityDaoImplPlayer;
import footballclub.dao.EnityDaoImplTeam;
import footballclub.entity.Player;
import footballclub.entity.Team;
import junit.framework.TestCase;
import managment.implementation.PlayerServiceImpl;
import managment.implementation.TeamServiceImpl;
import managment.interfaces.PlayerService;
import org.junit.Assert;
import org.junit.Test;

import static managment.ConstansManager.*;

public class PlayerServiceImplTest extends TestCase {
    @Test
    public void testCreatePlayer() {
        EnityDaoImplPlayer daoImplPlayer = new EnityDaoImplPlayer(Player.class);
        PlayerService playerService =
                new PlayerServiceImpl(new EnityDaoImplPlayer(Player.class));
        Player player = playerService.createPlayer(PLAYER_NAME,PLAYER_SURNAME,
                PLAYER_COUNTRY,PLAYER_AGE,PLAYER_POSITION);
        Assert.assertNotNull(daoImplPlayer.getEntity(player.getPlayer_id()));
    }

    @Test
    public void testUpdateTeam() {
        PlayerService playerService =
                new PlayerServiceImpl(new EnityDaoImplPlayer(Player.class));
        Player player = playerService.createPlayer(PLAYER_NAME,PLAYER_SURNAME,
                PLAYER_COUNTRY,PLAYER_AGE,PLAYER_POSITION);
        TeamServiceImpl teamService =
                new TeamServiceImpl(new EnityDaoImplTeam(Team.class));
        Team team = teamService.createTeam(TEAM_NAME, TEAM_CITY,
                TEAM_COUNTRY, TEAM_STADIUM, TEAM_COUCH);
        Team team1 = teamService.createTeam(TEAM_NAME_2, TEAM_CITY_2,
                TEAM_COUNTRY_2, TEAM_STADIUM_2, TEAM_COUCH_2);
        teamService.addPlayerInTeam(player,team);
        playerService.updateTeam(player,team1);
        Assert.assertEquals(player.getTeam().getTeam_name(),TEAM_NAME_2);
    }

    @Test
    public void testUpdatePosition() {
        PlayerService playerService =
                new PlayerServiceImpl(new EnityDaoImplPlayer(Player.class));
        Player player = playerService.createPlayer(PLAYER_NAME,PLAYER_SURNAME,
                PLAYER_COUNTRY,PLAYER_AGE,PLAYER_POSITION);
        playerService.updatePosition(player,SET_PLAYER_POSITION);
        Assert.assertEquals(player.getPosition(),SET_PLAYER_POSITION);
    }
}