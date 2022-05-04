package managment.implementation;

import footballclub.dao.EnityDaoImplPlayer;
import footballclub.dao.EnityDaoImplTeam;
import footballclub.entity.Player;
import footballclub.entity.Team;
import managment.Manager;
import managment.interfaces.TeamService;

import java.util.ArrayList;
import java.util.List;

public class TeamServiceImpl implements TeamService {
    EnityDaoImplTeam enityDaoImplTeam;
    EnityDaoImplPlayer enityDaoImplPlayer =
            new EnityDaoImplPlayer(Player.class);

    public TeamServiceImpl(EnityDaoImplTeam enityDaoImplTeam) {
        this.enityDaoImplTeam = enityDaoImplTeam;
    }


    @Override
    public Team createTeam(String teamName, String teamCity,
                           String teamCountry, String teamStadium,
                           String teamCoach) {
        Team team = Team.builder()
                .team_name(teamName)
                .city(teamCity)
                .country(teamCountry)
                .stadium(teamStadium)
                .coach(teamCoach)
                .build();
        enityDaoImplTeam.insert(team);
        return team;
    }

    @Override
    public Player addPlayerInTeam(Player player, Team team) {
        player.setTeam(team);
        enityDaoImplPlayer.update(player);
        System.out.println("A new player has been added to the team: " +
                player.getPlayer_name() + " " + player.getPlayer_surname());
        return player;
    }

    @Override
    public void deletePlayerWithTeam(Player player) {
        Team team = null;
        player.setTeam(team);
        enityDaoImplPlayer.update(player);
    }

    @Override
    public String showOnePlayerInfo(Player player) {
        String str = enityDaoImplPlayer.getEntity
                (player.getPlayer_id()).toString();
        System.out.println(enityDaoImplPlayer.getEntity
                (player.getPlayer_id()).toString());
        return str;
    }

    @Override
    public List<Player> showAllPlayerTeamInfo(Team team) {
        List<Player> players = new ArrayList<>();
        System.out.println("All team players: " + team.getTeam_name());
        for (Player p : Manager.players
        ) {
            if (p.getTeam() == team) {
                System.out.println(p);
                players.add(p);
            }
        }
        return players;
    }
}
