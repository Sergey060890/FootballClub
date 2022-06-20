package managment.interfaces;

import java.sql.SQLException;

public interface StatsService {
    /**
     * Player statistics
//     */
//    String statsPlayer(Player player);

    /**
     * Team statistics
     */
//    String statsTeam(Integer id) throws SQLException;

    Integer statsTeamCountGame(Integer id) throws SQLException;

    Integer statsTeamWinGame(Integer id) throws SQLException;

    Integer statsTeamLoseGame(Integer id) throws SQLException;

    Integer statsTeamDrawGame(Integer id) throws SQLException;

    Integer statsTeamGoalScore(Integer id) throws SQLException;

    Integer statsTeamGoalConc(Integer id) throws SQLException;

    Integer statsTeamYellowCard(Integer id) throws SQLException;

    Integer statsTeamRedCard(Integer id) throws SQLException;
}
