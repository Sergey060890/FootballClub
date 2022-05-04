package serviceTest;

import footballclub.dao.EnityDaoImplPlayer;
import footballclub.dao.EnityDaoImplTeam;
import footballclub.entity.Player;
import footballclub.entity.Team;
import junit.framework.TestCase;
import managment.implementation.PlayerServiceImpl;
import managment.implementation.StatsServiceImpl;
import managment.implementation.TeamServiceImpl;
import managment.interfaces.PlayerService;
import org.junit.Assert;
import org.junit.Test;

import static managment.ConstansManager.*;

public class StatsServiceImplTest extends TestCase {
    @Test
    public void testStatsPlayer() {
        PlayerService playerService =
                new PlayerServiceImpl(new EnityDaoImplPlayer(Player.class));
        Player player = playerService.createPlayer(PLAYER_NAME, PLAYER_SURNAME,
                PLAYER_COUNTRY, PLAYER_AGE, PLAYER_POSITION);
        TeamServiceImpl teamService =
                new TeamServiceImpl(new EnityDaoImplTeam(Team.class));
        Team team = teamService.createTeam(TEAM_NAME, TEAM_CITY,
                TEAM_COUNTRY, TEAM_STADIUM, TEAM_COUCH);
        teamService.addPlayerInTeam(player, team);
        StatsServiceImpl statsService = new StatsServiceImpl();
        Assert.assertEquals(player.toString(), statsService.statsPlayer(player));
    }

    @Test
    public void testStatsTeam() {
        TeamServiceImpl teamService =
                new TeamServiceImpl(new EnityDaoImplTeam(Team.class));
        Team team = teamService.createTeam(TEAM_NAME, TEAM_CITY,
                TEAM_COUNTRY, TEAM_STADIUM, TEAM_COUCH);
        StatsServiceImpl statsService = new StatsServiceImpl();
        Assert.assertNotNull(statsService.statsTeam(team));
    }
}