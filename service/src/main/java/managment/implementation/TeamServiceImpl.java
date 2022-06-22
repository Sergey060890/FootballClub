package managment.implementation;

import dto.TeamDTO;
import dto.mapper.TeamMapper;
import footballclub.dao.implementations.EnityDaoImplPlayer;
import footballclub.dao.implementations.EnityDaoImplTeam;
import footballclub.dao.interfaces.PlayerDao;
import footballclub.dao.interfaces.TeamDao;
import footballclub.entity.Game;
import footballclub.entity.Player;
import footballclub.entity.Team;
import managment.interfaces.GameService;
import managment.interfaces.PlayerService;
import managment.interfaces.TeamService;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TeamServiceImpl implements TeamService {

    PlayerDao enityDaoImplPlayer =
            new EnityDaoImplPlayer();

    TeamDao enityDaoImplTeam = new EnityDaoImplTeam();

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
        enityDaoImplTeam.create(team);
        return team;
    }

//    @Override
//    public List<Team> showAllTeam() {
//       return enityDaoImplTeam.findAll();
//    }

    @Override
    public List<TeamDTO> findAll() {
        return enityDaoImplTeam.findAll()
                .stream()
                .map(TeamMapper::mapFrom)
                .collect(Collectors.toList());
    }


    @Override
    public void updateTeam(Integer id, String teamName, String teamCity,
                           String teamCountry, String teamStadium,
                           String teamCoach) throws SQLException {
        Team team = enityDaoImplTeam.findOne(id);
        team.setTeam_name(teamName);
        team.setCity(teamCity);
        team.setCountry(teamCountry);
        team.setStadium(teamStadium);
        team.setCoach(teamCoach);
        enityDaoImplTeam.update(team);
    }

    @Override
    public void deleteTeam(Integer id) throws SQLException {
        enityDaoImplTeam.deleteById(id);
    }

    @Override
    public TeamDTO findTeamById(Integer id) throws SQLException {
        return TeamMapper.mapFrom(enityDaoImplTeam.findOne(id));
    }

    @Override
    public Team findTeamId(Integer id) throws SQLException {
        Team team = enityDaoImplTeam.findOne(id);
        return team;
    }

    @Override
    public Player addPlayerInTeam(Player player, Team team) {
        player.setTeamPlayer(team);
        enityDaoImplPlayer.update(player);
        return player;
    }

//    @Override
//    public void deletePlayerWithTeam(Player player) {
//        Team team = new Team();
//        team.setTeam_name("free agent");
//        player.setTeamPlayer(team);
//        enityDaoImplPlayer.update(player);
//    }

    @Override
    public Player showOnePlayerInfo(Integer id) throws SQLException {
        Player player = enityDaoImplPlayer.findOne(id);
        return player;
    }

    @Override
    public Set<Player> showAllPlayerTeamInfo(Integer id) {
        Set<Player> players = new HashSet<>();
        for (Player p : enityDaoImplPlayer.findAll()
        ) {
            if (p.getTeamPlayer().getTeam_id() == id) {
                players.add(p);
            }
        }
        return players;
    }

    @Override
    public void deleteAllPlayerTeam(TeamService teamService, PlayerService playerService, Integer id) throws SQLException {
        for (Player p : teamService.showAllPlayerTeamInfo(id)
        ) {
            playerService.deletePlayer(p.getPlayer_id());
        }
    }

    @Override
    public void deleteAllGameTeam(GameService gameService, Integer id) throws SQLException {
        for (Game game : gameService.showAllGameTeamInfo(id)
        ) {
            gameService.deleteGame(game.getGame_id());
        }
    }
}
