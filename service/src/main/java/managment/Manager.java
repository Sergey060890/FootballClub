package managment;

import footballclub.dao.EnityDaoImplGame;
import footballclub.dao.EnityDaoImplPlayer;
import footballclub.dao.EnityDaoImplTeam;
import footballclub.entity.Game;
import footballclub.entity.GoalConceded;
import footballclub.entity.GoalScore;
import footballclub.entity.Player;
import footballclub.entity.RedCard;
import footballclub.entity.Substitution;
import footballclub.entity.Team;
import footballclub.entity.YellowCard;
import footballclub.util.HibernateUtil;
import managment.implementation.GameServiceImpl;
import managment.implementation.PlayerServiceImpl;
import managment.implementation.StatsServiceImpl;
import managment.implementation.TeamServiceImpl;
import managment.interfaces.GameService;
import managment.interfaces.PlayerService;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static managment.ConstansManager.*;
/**
 * Manager Class
 */
public class Manager {
    public static List<Player> players = new ArrayList<>();

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        /**
         * Player Service
         */
        System.out.println("************PLAYER SERVICE************");
        PlayerService playerService =
                new PlayerServiceImpl(new EnityDaoImplPlayer(Player.class));
        /**
         * Create Player one
         */
        Player player = playerService.createPlayer(PLAYER_NAME, PLAYER_SURNAME,
                PLAYER_COUNTRY, PLAYER_AGE, PLAYER_POSITION);
        players.add(player);

        /**
         * Create Player two
         */
        Player player1 = playerService.createPlayer(PLAYER_NAME_2, PLAYER_SURNAME_2,
                PLAYER_COUNTRY_2, PLAYER_AGE_2, PLAYER_POSITION_2);
        players.add(player1);

        /**
         * Create Player three
         */
        Player player2 = playerService.createPlayer(PLAYER_NAME_3, PLAYER_SURNAME_3,
                PLAYER_COUNTRY_3, PLAYER_AGE_3, PLAYER_POSITION_3);
        players.add(player2);

        /**
         * Create Player four
         */
        Player player3 = playerService.createPlayer(PLAYER_NAME_4, PLAYER_SURNAME_4,
                PLAYER_COUNTRY_4, PLAYER_AGE_4, PLAYER_POSITION_4);
        players.add(player3);

        /**
         * Update Player Position
         */
        playerService.updatePosition(player, SET_PLAYER_POSITION);

        /**
         * Team Service
         */
        System.out.println("************TEAM SERVICE************");
        TeamServiceImpl teamService =
                new TeamServiceImpl(new EnityDaoImplTeam(Team.class));
        /**
         * Create Team One
         */
        Team team = teamService.createTeam(TEAM_NAME, TEAM_CITY,
                TEAM_COUNTRY, TEAM_STADIUM, TEAM_COUCH);
        /**
         * Create Team Two
         */
        Team team1 = teamService.createTeam(TEAM_NAME_2, TEAM_CITY_2,
                TEAM_COUNTRY_2, TEAM_STADIUM_2, TEAM_COUCH_2);
        /**
         * Add player one in team
         */
        teamService.addPlayerInTeam(player, team);

        /**
         * Add player two in team
         */
        teamService.addPlayerInTeam(player1, team);

        /**
         * Add player three in team
         */
        teamService.addPlayerInTeam(player2, team);

        /**
         * Add player four in team
         */
        teamService.addPlayerInTeam(player3, team);

        /**
         * One player info
         */
        teamService.showOnePlayerInfo(player);

        /**
         * Team all player info
         */
        teamService.showAllPlayerTeamInfo(team);

        /**
         * Update Player team
         */
        playerService.updateTeam(player, team1);

        /**
         * Delete Player with team
         */
        teamService.deletePlayerWithTeam(player);


        /**
         * Game Service
         */
        System.out.println("************GAME SERVICE************");
        GameService gameService =
                new GameServiceImpl(new EnityDaoImplGame(Game.class));

        /**
         * Create Game
         */
        Game game = gameService.createGame(GAME_DATE_1, team, team1, Set.of(player1, player2, player3));

        /**
         * Сomposition of players
         */
        gameService.showAllPlayerGame(game);

        /**
         * Goal one in the game
         */
        GoalScore goal = gameService.createGoalScore(game, player1, GOAL_TIME);

        /**
         * Goal two in the game
         */
        GoalScore goal1 = gameService.createGoalScore(game, player1, GOAL_TIME_2);

        /**
         * Goal conceded in the game
         */
        GoalConceded goalConc = gameService.createGoalConceded(game, player2, CONCEDED_TIME);

        /**
         * The player received a yellow card
         */
        YellowCard yc = gameService.createYellowCard(game, player1, YELLOW_CARD_TIME);

        /**
         * The player received a yellow card
         */
        YellowCard yc1 = gameService.createYellowCard(game, player2, YELLOW_CARD_TIME_2);

        /**
         * The player received a red card
         */
        RedCard rc = gameService.createRedCard(game, player1, RED_CARD_TIME);
        /**
         * Replacement of a player in a match
         */
        Substitution subs = gameService.createSubs(game, player3, player2, SUBS_TIME);

        /**
         * Game statistics
         */
        gameService.showGameAndStats(game, Set.of(goal, goal1), Set.of(goalConc),
                Set.of(yc, yc1), Set.of(rc), Set.of(subs));


        /**
         * Stats Service
         */
        StatsServiceImpl statsService = new StatsServiceImpl();

        /**
         * Stats player
         */
        statsService.statsPlayer(player1);

        /**
         * Stats team
         */
        statsService.statsTeam(team);

        /**
         * Hinernate Factory close
         */
        HibernateUtil.close();
    }
}
