package managment.implementation;

import managment.interfaces.StatsService;

public class StatsServiceImpl implements StatsService {

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
//    @Override
//    public String statsTeam(Team team) {
//        System.out.println("********Team stats********");
//        System.out.println("Team: " + team.getTeam_name());
//        System.out.println("City: " + team.getCity());
//        System.out.println("Country " + team.getCountry());
//        System.out.println("---------------------------");
//        int countGame = 0;
//        for (Game g : GameServiceImpl.games
//        ) {
//            if (g.getTeamGame() == team) {
//                countGame++;
//            }
//        }
//        System.out.println("Total games: " + countGame);
//        System.out.println("---------------------------");
//        System.out.println("WIN GAMES: ");
//        int countGameWin = 0;
//        for (Game g : GameServiceImpl.games
//        ) {
//            if (g.getTeamGame() == team && g.getResult() == RESULT_GAME_WIN) {
//                System.out.println(g.getOpponent_name() + " "
//                        + g.getGoal_score() +
//                        ":" + g.getGoals_conceded());
//                countGameWin++;
//            }
//        }
//        System.out.println("TOTAL WIN: " + countGameWin);
//        System.out.println("---------------------------");
//
//        System.out.println("DRAW GAMES: ");
//        int countGameDraw = 0;
//        for (Game g : GameServiceImpl.games
//        ) {
//            if (g.getTeamGame() == team && g.getResult() == RESULT_GAME_DRAW) {
//                System.out.println(g.getOpponent_name() + " " + g.getGoal_score() +
//                        ":" + g.getGoals_conceded());
//                countGameDraw++;
//            }
//        }
//        System.out.println("TOTAL DRAW: " + countGameDraw);
//        System.out.println("---------------------------");
//
//        System.out.println("LOSE GAMES: ");
//        int countGameLose = 0;
//        for (Game g : GameServiceImpl.games
//        ) {
//            if (g.getTeamGame() == team && g.getResult() == RESULT_GAME_LOSE) {
//                System.out.println(g.getOpponent_name() + " " + g.getGoal_score() +
//                        ":" + g.getGoals_conceded());
//                countGameDraw++;
//            }
//        }
//        System.out.println("TOTAL LOSE: " + countGameLose);
//        System.out.println("---------------------------");
//
//        int countGoalScore = 0;
//        for (Game g : GameServiceImpl.games
//        ) {
//            if (g.getTeamGame() == team) {
//                countGoalScore += g.getGoal_score();
//            }
//        }
//        System.out.println("Goal score: " + countGoalScore);
//        System.out.println("---------------------------");
//
//        int countGoalConceded = 0;
//        for (Game g : GameServiceImpl.games
//        ) {
//            if (g.getTeamGame() == team) {
//                countGoalConceded += g.getGoals_conceded();
//            }
//        }
//        System.out.println("Goal conceded: " + countGoalConceded);
//        System.out.println("---------------------------");
//        String str = team.toString();
//        return str;
    }
