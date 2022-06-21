package managment.interfaces;


import DTO.GameDTO;
import footballclub.entity.Game;
import footballclub.entity.GoalConceded;
import footballclub.entity.GoalScore;
import footballclub.entity.Player;
import footballclub.entity.RedCard;
import footballclub.entity.Substitution;
import footballclub.entity.Team;
import footballclub.entity.YellowCard;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface GameService {
    /**
     * Create game
     */
    Game createGame(Team team, String opponentTeam,Set<Player> players) throws SQLException;

    Game createGameNoPlayers(Team team,
                             String opponentTeam);


    Game addPlayersInStartGame(Integer idGame, Set<Player> players) throws SQLException;

    /**
     * Create Goal score
     */
    GoalScore createGoalScore(Game game, Set<Player> players);

    /**
     * Create Goal conceded
     */
    GoalConceded createGoalConceded(Game game, Set<Player> players);

    /**
     * Create yellow card
     */
    YellowCard createYellowCard(Game game, Set<Player> players);

    /**
     * Create red card
     */
    RedCard createRedCard(Game game, Set<Player> players);

    /**
     * Create substitution
     */
    Substitution createSubs(Game game, Set<Player> playersIn, Set<Player> playersOut);

    /**
     * Print AllPlayerGameInfo
     */
    Set<Game> showAllPlayerGame(Game game);

    /**
     * Print GameStats
     */
    List<String> showGameAndStats(GameService service, Game game, Set<Player> start, Set<Player> noStart);

    List<GameDTO> findAll();

    Map<Integer, String> showAllOpponentTeamInfo(Set<Game> gameSet);

    Set<Game> showAllGameTeamInfo(Integer id);

    void deleteGame(Integer id) throws SQLException;

    void updateGame(Integer id,
                    String opponentTeam) throws SQLException;

    Game findGameById(Integer id) throws SQLException;

    Set<Player> showAllGamePlayerInfo(Integer id) throws SQLException;

    Set<Player> startGamePlayer(Integer id, String[] players) throws SQLException;

    Set<Player> noStartGamePlayer(Integer id, String[] players) throws SQLException;

    Map<Integer, String> opponentRemoveTeam(GameService service, Game game, Set<Game> gameSet);

    Integer goalkeeperСheck(Set<Player> playersGo) throws SQLException;

    Integer countAttendance();

    String refereeGame();

}
