package footballclub.utilsTest;


import footballclub.entity.Game;
import footballclub.entity.GoalConceded;
import footballclub.entity.GoalScore;
import footballclub.entity.Player;
import footballclub.entity.RedCard;
import footballclub.entity.Substitution;
import footballclub.entity.Team;
import footballclub.entity.YellowCard;

import java.util.Set;

import static footballclub.Constans.*;

public class Utils {

    public static Team createTeam() {
        return Team.builder()
                .team_name(TEAM_NAME)
                .city(TEAM_CITY)
                .country(TEAM_COUNTRY)
                .stadium(TEAM_STADIUM)
                .coach(TEAM_COUCH)
                .build();
    }

    public static Player createPlayer(Team team) {
        return Player.builder()
                .player_name(PLAYER_NAME)
                .player_surname(PLAYER_SURNAME)
                .country(PLAYER_COUNTRY)
                .age(PLAYER_AGE)
                .position(PLAYER_POSITION)
                .team(team)
                .build();
    }

    public static Player createPlayerSubs(Team team) {
        return Player.builder()
                .player_name(PLAYER_SUBS_NAME)
                .player_surname(PLAYER_SUBS_SURNAME)
                .country(PLAYER_SUBS_COUNTRY)
                .age(PLAYER_SUBS_AGE)
                .position(PLAYER_SUBS_POSITION)
                .team(team)
                .build();
    }

    public static Game createGame(Team team, Set<Player> players) {
        return Game.builder()
                .team(team)
                .game_date(GAME_DATE_1)
                .players(players)
                .opponent_name(OPPONENT_NAME)
                .result(RESULT_GAME)
                .goal_score(GOAL_SCORE)
                .goals_conceded(GOALS_CONCEDED)
                .yellow_card_score(YELLOW_CARD_SCORE)
                .red_card_score(RED_CARD_SCORE)
                .build();
    }

    public static GoalScore createGoalScore(Game game, Player player) {
        return GoalScore.builder()
                .game(game)
                .player(player)
                .goal_time(GOAL_TIME)
                .build();
    }

    public static GoalConceded createGoalConceded(Game game, Player player) {
        return GoalConceded.builder()
                .game(game)
                .player(player)
                .conceded_time(CONCEDED_TIME)
                .build();
    }

    public static YellowCard createYellowCard(Game game, Player player) {
        return YellowCard.builder()
                .game(game)
                .player(player)
                .card_time(YELLOW_CARD_TIME)
                .build();
    }

    public static RedCard createRedCard(Game game, Player player) {
        return RedCard.builder()
                .game(game)
                .player(player)
                .card_time(RED_CARD_TIME)
                .build();
    }

    public static Substitution createSubstitution(Game game,
                                                  Player playerIn,
                                                  Player playerOut) {
        return Substitution.builder()
                .game(game)
                .playerIn(playerIn)
                .playerOut(playerOut)
                .subs_time(SUBS_TIME)
                .build();
    }
}
