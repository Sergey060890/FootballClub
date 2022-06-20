package managment.implementation;

import footballclub.entity.Game;
import managment.interfaces.GameService;
import managment.interfaces.StatsService;
import managment.interfaces.TeamService;

import java.sql.SQLException;
import java.util.Set;

public class StatsServiceImpl implements StatsService {
    public static final String WIN = "WIN";
    public static final int COUNT_GAME = 0;
    public static final String LOSE = "LOSE";
    public static final String DRAW = "DRAW";
    public static final int GOAL_SCORE = 0;
    public static final int CARD = 0;
    TeamService teamService = new TeamServiceImpl();
    GameService gameService = new GameServiceImpl();

    //    @Override
//    public String statsPlayer(Player player) {
//        System.out.println("********Player stats********");
//        System.out.println("Player: " + player.getPlayer_name() + " "
//                + player.getPlayer_surname());
//        System.out.println("Team: " + player.getTeamPlayer().getTeam_name() + " "
//                + player.getTeamPlayer().getCity());
//
//        int countMatch = 0;
//        for (Game g : GameServiceImpl.games
//        ) {
//            for (Player pl : g.getPlayers()
//            ) {
//                if (pl.getPlayer_surname() ==
//                        player.getPlayer_surname()) {
//                    countMatch++;
//                }
//            }
//        }
//        System.out.println("Total games: " + countMatch);
//
//        System.out.println("Goals:");
//        int countPlayerGoles = 0;
//        String opponentName = null;
//        for (GoalScore g : GameServiceImpl.goalScores
//        ) {
//            if (g.getPlayer().getPlayer_surname() ==
//                    player.getPlayer_surname()) {
//                if (opponentName != g.getGame().getOpponent_name()) {
//                    opponentName = g.getGame().getOpponent_name();
//                }
//                countPlayerGoles++;
//            }
//        }
//        System.out.println(opponentName + " - " + countPlayerGoles);
//
//        int countYellowCard = 0;
//        for (YellowCard ycrd : GameServiceImpl.yellowCards
//        ) {
//            if (ycrd.getPlayer().getPlayer_surname() ==
//                    player.getPlayer_surname()) {
//                countYellowCard++;
//            }
//        }
//        System.out.println("Yellow cards: " + countYellowCard);
//
//        int countRedCard = 0;
//        for (RedCard rc : GameServiceImpl.redCards
//        ) {
//            if (rc.getPlayer().getPlayer_surname() ==
//                    player.getPlayer_surname()) {
//                countRedCard++;
//            }
//        }
//        System.out.println("Red cards: " + countRedCard);
//        String str = player.toString();
//        return str;
//
//    }
//
    @Override
    public Integer statsTeamCountGame(Integer id) throws SQLException {
        Set<Game> gameSet = gameService.showAllGameTeamInfo(id);
        return gameSet.size();
    }

    @Override
    public Integer statsTeamWinGame(Integer id) throws SQLException {
        Set<Game> gameSet = gameService.showAllGameTeamInfo(id);
        int countGameWin = COUNT_GAME;
        for (Game g : gameSet
        ) {
            if (g.getResult().equals(WIN)) {
                countGameWin++;
            }
        }
        return countGameWin;
    }

    @Override
    public Integer statsTeamLoseGame(Integer id) throws SQLException {
        Set<Game> gameSet = gameService.showAllGameTeamInfo(id);
        int countGameLose = COUNT_GAME;
        for (Game g : gameSet
        ) {
            if (g.getResult().equals(LOSE)) {
                countGameLose++;
            }
        }
        return countGameLose;
    }


    @Override
    public Integer statsTeamDrawGame(Integer id) throws SQLException {
        Set<Game> gameSet = gameService.showAllGameTeamInfo(id);
        int countGameDraw = COUNT_GAME;
        for (Game g : gameSet
        ) {
            if (g.getResult().equals(DRAW)) {
                countGameDraw++;
            }
        }
        return countGameDraw;
    }


    @Override
    public Integer statsTeamGoalScore(Integer id) throws SQLException {
        Set<Game> gameSet = gameService.showAllGameTeamInfo(id);
        int countGoalScore = GOAL_SCORE;
        for (Game g : gameSet
        ) {
            countGoalScore += g.getGoal_score();
        }
        return countGoalScore;
    }

    @Override
    public Integer statsTeamGoalConc(Integer id) throws SQLException {
        Set<Game> gameSet = gameService.showAllGameTeamInfo(id);
        int countGoalConc = GOAL_SCORE;
        for (Game g : gameSet
        ) {
            countGoalConc += g.getGoals_conceded();
        }
        return countGoalConc;
    }

    @Override
    public Integer statsTeamYellowCard(Integer id) throws SQLException {
        Set<Game> gameSet = gameService.showAllGameTeamInfo(id);
        int countYellowCard = CARD;
        for (Game g : gameSet) {
            countYellowCard += g.getYellow_card_score();
        }
        return countYellowCard;
    }

    @Override
    public Integer statsTeamRedCard(Integer id) throws SQLException {
        Set<Game> gameSet = gameService.showAllGameTeamInfo(id);
        int countRedCard = CARD;
        for (Game g : gameSet
        ) {
            countRedCard += g.getRed_card_score();
        }
        return countRedCard;
    }
}
