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
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface GameService {
    /**
     * Create game
     */
    Game createGame(LocalDate date, Team team, String opponentTeam) throws SQLException;

    Game createGameNoPlayers(LocalDate date, Team team,
                                    String opponentTeam);
    /**
     * Create Goal
     */
    GoalScore createGoalScore(Game game, Player player, Integer time);
    /**
     * Create Goal conceded
     */
    GoalConceded createGoalConceded(Game game, Player player, Integer time);
    /**
     * Create yellow card
     */
    YellowCard createYellowCard(Game game, Player player, Integer time);
    /**
     * Create red card
     */
    RedCard createRedCard(Game game, Player player, Integer time);
    /**
     * Create substitution
     */
    Substitution createSubs(Game game, Player playerIn, Player playerOut, Integer time);

    /**
     * Print AllPlayerGameInfo
     */
    Set<Game> showAllPlayerGame(Game game);

    /**
     * Print GameStats
     */
    List<String> showGameAndStats(Game game, Set<GoalScore> goal,
                                  Set<GoalConceded> goalConc,
                                  Set<YellowCard> yc,
                                  Set<RedCard> rc,
                                  Set<Substitution> subs);

    List<GameDTO> findAll();

    Set<Game> showAllGameTeamInfo(Integer id);

    void deleteGame(Integer id) throws SQLException;

    void updateGame(Integer id, LocalDate date,
                           String opponentTeam) throws SQLException;

    Game findGameById(Integer id) throws SQLException;
}
