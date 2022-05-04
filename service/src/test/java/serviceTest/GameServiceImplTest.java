package serviceTest;

import footballclub.dao.EnityDaoImplGame;
import footballclub.dao.EnityDaoImplGoalConceded;
import footballclub.dao.EnityDaoImplGoalScore;
import footballclub.dao.EnityDaoImplPlayer;
import footballclub.dao.EnityDaoImplRedCard;
import footballclub.dao.EnityDaoImplSubstitution;
import footballclub.dao.EnityDaoImplTeam;
import footballclub.dao.EnityDaoImplYellowCard;
import footballclub.entity.Game;
import footballclub.entity.GoalConceded;
import footballclub.entity.GoalScore;
import footballclub.entity.Player;
import footballclub.entity.RedCard;
import footballclub.entity.Substitution;
import footballclub.entity.Team;
import footballclub.entity.YellowCard;
import junit.framework.TestCase;
import managment.implementation.GameServiceImpl;
import managment.implementation.PlayerServiceImpl;
import managment.implementation.TeamServiceImpl;
import managment.interfaces.GameService;
import managment.interfaces.PlayerService;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static managment.ConstansManager.*;

public class GameServiceImplTest extends TestCase {
    @Test
    public void testCreateGame() {
        EnityDaoImplGame daoImplGame = new EnityDaoImplGame(Game.class);
        PlayerService playerService =
                new PlayerServiceImpl(new EnityDaoImplPlayer(Player.class));
        Player player = playerService.createPlayer(PLAYER_NAME,PLAYER_SURNAME,
                PLAYER_COUNTRY,PLAYER_AGE,PLAYER_POSITION);
        TeamServiceImpl teamService =
                new TeamServiceImpl(new EnityDaoImplTeam(Team.class));
        Team team = teamService.createTeam(TEAM_NAME, TEAM_CITY,
                TEAM_COUNTRY, TEAM_STADIUM, TEAM_COUCH);
        Team team1 = teamService.createTeam(TEAM_NAME_2, TEAM_CITY_2,
                TEAM_COUNTRY_2, TEAM_STADIUM_2, TEAM_COUCH_2);
        GameService gameService =
                new GameServiceImpl(new EnityDaoImplGame(Game.class));
        Game game = gameService.createGame(GAME_DATE_1, team, team1,
                Set.of(player));
        Assert.assertNotNull(daoImplGame.getEntity(game.getGame_id()));
    }

    @Test
    public void testCreateGoalScore() {
        PlayerService playerService =
                new PlayerServiceImpl(new EnityDaoImplPlayer(Player.class));
        Player player = playerService.createPlayer(PLAYER_NAME,PLAYER_SURNAME,
                PLAYER_COUNTRY,PLAYER_AGE,PLAYER_POSITION);
        TeamServiceImpl teamService =
                new TeamServiceImpl(new EnityDaoImplTeam(Team.class));
        Team team = teamService.createTeam(TEAM_NAME, TEAM_CITY,
                TEAM_COUNTRY, TEAM_STADIUM, TEAM_COUCH);
        Team team1 = teamService.createTeam(TEAM_NAME_2, TEAM_CITY_2,
                TEAM_COUNTRY_2, TEAM_STADIUM_2, TEAM_COUCH_2);
        GameService gameService =
                new GameServiceImpl(new EnityDaoImplGame(Game.class));
        Game game = gameService.createGame(GAME_DATE_1, team, team1,
                Set.of(player));

        EnityDaoImplGoalScore enityDaoImplGoalScore =
                new EnityDaoImplGoalScore(GoalScore.class);
        GoalScore goal = gameService.createGoalScore(game,player,GOAL_TIME);
        Assert.assertEquals(goal,enityDaoImplGoalScore.
                getEntity(goal.getGoal_id()));

    }

    @Test
    public void testCreateGoalConceded() {
        PlayerService playerService =
                new PlayerServiceImpl(new EnityDaoImplPlayer(Player.class));
        Player player = playerService.createPlayer(PLAYER_NAME,PLAYER_SURNAME,
                PLAYER_COUNTRY,PLAYER_AGE,PLAYER_POSITION);

        TeamServiceImpl teamService =
                new TeamServiceImpl(new EnityDaoImplTeam(Team.class));
        Team team = teamService.createTeam(TEAM_NAME, TEAM_CITY,
                TEAM_COUNTRY, TEAM_STADIUM, TEAM_COUCH);
        Team team1 = teamService.createTeam(TEAM_NAME_2, TEAM_CITY_2,
                TEAM_COUNTRY_2, TEAM_STADIUM_2, TEAM_COUCH_2);

        GameService gameService =
                new GameServiceImpl(new EnityDaoImplGame(Game.class));
        Game game = gameService.createGame(GAME_DATE_1, team, team1,
                Set.of(player));

        EnityDaoImplGoalConceded enityDaoImplGoalConceded =
                new EnityDaoImplGoalConceded(GoalConceded.class);

        GoalConceded goalConc = gameService.createGoalConceded(game,player,GOALS_CONCEDED);
        Assert.assertEquals(goalConc,enityDaoImplGoalConceded.getEntity
                (goalConc.getGoal_conceded_id()));
    }

    @Test
    public void testCreateYellowCard() {
        PlayerService playerService =
                new PlayerServiceImpl(new EnityDaoImplPlayer(Player.class));
        Player player = playerService.createPlayer(PLAYER_NAME,PLAYER_SURNAME,
                PLAYER_COUNTRY,PLAYER_AGE,PLAYER_POSITION);

        TeamServiceImpl teamService =
                new TeamServiceImpl(new EnityDaoImplTeam(Team.class));
        Team team = teamService.createTeam(TEAM_NAME, TEAM_CITY,
                TEAM_COUNTRY, TEAM_STADIUM, TEAM_COUCH);
        Team team1 = teamService.createTeam(TEAM_NAME_2, TEAM_CITY_2,
                TEAM_COUNTRY_2, TEAM_STADIUM_2, TEAM_COUCH_2);

        GameService gameService =
                new GameServiceImpl(new EnityDaoImplGame(Game.class));
        Game game = gameService.createGame(GAME_DATE_1, team, team1,
                Set.of(player));

        EnityDaoImplYellowCard enityDaoImplYellowCard =
                new EnityDaoImplYellowCard(YellowCard.class);

        YellowCard yc = gameService.createYellowCard(game,player,YELLOW_CARD_TIME);
        Assert.assertEquals(yc,enityDaoImplYellowCard.getEntity
                (yc.getYellow_card_id()));

    }

    @Test
    public void testCreateRedCard() {
        PlayerService playerService =
                new PlayerServiceImpl(new EnityDaoImplPlayer(Player.class));
        Player player = playerService.createPlayer(PLAYER_NAME,PLAYER_SURNAME,
                PLAYER_COUNTRY,PLAYER_AGE,PLAYER_POSITION);

        TeamServiceImpl teamService =
                new TeamServiceImpl(new EnityDaoImplTeam(Team.class));
        Team team = teamService.createTeam(TEAM_NAME, TEAM_CITY,
                TEAM_COUNTRY, TEAM_STADIUM, TEAM_COUCH);
        Team team1 = teamService.createTeam(TEAM_NAME_2, TEAM_CITY_2,
                TEAM_COUNTRY_2, TEAM_STADIUM_2, TEAM_COUCH_2);

        GameService gameService =
                new GameServiceImpl(new EnityDaoImplGame(Game.class));
        Game game = gameService.createGame(GAME_DATE_1, team, team1,
                Set.of(player));

        EnityDaoImplRedCard enityDaoImplRedCard =
                new EnityDaoImplRedCard(RedCard.class);

        RedCard rc = gameService.createRedCard(game,player,RED_CARD_TIME);
        Assert.assertEquals(rc,enityDaoImplRedCard.getEntity
                (rc.getRed_card_id()));
    }

    @Test
    public void testCreateSubs() {
        PlayerService playerService =
                new PlayerServiceImpl(new EnityDaoImplPlayer(Player.class));
        Player player = playerService.createPlayer(PLAYER_NAME, PLAYER_SURNAME,
                PLAYER_COUNTRY, PLAYER_AGE, PLAYER_POSITION);
        Player player1 = playerService.createPlayer(PLAYER_NAME_2, PLAYER_SURNAME_2,
                PLAYER_COUNTRY_2, PLAYER_AGE_2, PLAYER_POSITION_2);

        TeamServiceImpl teamService =
                new TeamServiceImpl(new EnityDaoImplTeam(Team.class));
        Team team = teamService.createTeam(TEAM_NAME, TEAM_CITY,
                TEAM_COUNTRY, TEAM_STADIUM, TEAM_COUCH);
        Team team1 = teamService.createTeam(TEAM_NAME_2, TEAM_CITY_2,
                TEAM_COUNTRY_2, TEAM_STADIUM_2, TEAM_COUCH_2);

        GameService gameService =
                new GameServiceImpl(new EnityDaoImplGame(Game.class));
        Game game = gameService.createGame(GAME_DATE_1, team, team1,
                Set.of(player));

        EnityDaoImplSubstitution enityDaoImplSubstitution =
                new EnityDaoImplSubstitution(Substitution.class);

        Substitution subs = gameService.createSubs(game, player1, player, SUBS_TIME);
        Assert.assertEquals(subs, enityDaoImplSubstitution.getEntity
                (subs.getSubstitution_id()));
    }

    @Test
    public void testShowAllPlayerGame() {
        Set<Game> games = new HashSet<>();
        PlayerService playerService =
                new PlayerServiceImpl(new EnityDaoImplPlayer(Player.class));
        Player player = playerService.createPlayer(PLAYER_NAME, PLAYER_SURNAME,
                PLAYER_COUNTRY, PLAYER_AGE, PLAYER_POSITION);
        TeamServiceImpl teamService =
                new TeamServiceImpl(new EnityDaoImplTeam(Team.class));
        Team team = teamService.createTeam(TEAM_NAME, TEAM_CITY,
                TEAM_COUNTRY, TEAM_STADIUM, TEAM_COUCH);
        Team team1 = teamService.createTeam(TEAM_NAME_2, TEAM_CITY_2,
                TEAM_COUNTRY_2, TEAM_STADIUM_2, TEAM_COUCH_2);

        GameService gameService =
                new GameServiceImpl(new EnityDaoImplGame(Game.class));
        Game game = gameService.createGame(GAME_DATE_1, team, team1,
                Set.of(player));
        gameService.showAllPlayerGame(game);
        games.add(game);
        Assert.assertEquals(games,gameService.showAllPlayerGame(game));

    }

    @Test
    public void testShowGameAndStats() {
        PlayerService playerService =
                new PlayerServiceImpl(new EnityDaoImplPlayer(Player.class));
        Player player = playerService.createPlayer(PLAYER_NAME, PLAYER_SURNAME,
                PLAYER_COUNTRY, PLAYER_AGE, PLAYER_POSITION);
        Player player1 = playerService.createPlayer(PLAYER_NAME_2, PLAYER_SURNAME_2,
                PLAYER_COUNTRY_2, PLAYER_AGE_2, PLAYER_POSITION_2);
        TeamServiceImpl teamService =
                new TeamServiceImpl(new EnityDaoImplTeam(Team.class));
        Team team = teamService.createTeam(TEAM_NAME, TEAM_CITY,
                TEAM_COUNTRY, TEAM_STADIUM, TEAM_COUCH);
        Team team1 = teamService.createTeam(TEAM_NAME_2, TEAM_CITY_2,
                TEAM_COUNTRY_2, TEAM_STADIUM_2, TEAM_COUCH_2);
        GameService gameService =
                new GameServiceImpl(new EnityDaoImplGame(Game.class));
        Game game = gameService.createGame(GAME_DATE_1, team, team1,
                Set.of(player));
        GoalScore goal = gameService.createGoalScore(game, player, GOAL_TIME);
        GoalScore goal1 = gameService.createGoalScore(game, player, GOAL_TIME_2);
        GoalConceded goalConc = gameService.createGoalConceded(game, player, GOALS_CONCEDED);
        YellowCard yc = gameService.createYellowCard(game, player, YELLOW_CARD_TIME);
        YellowCard yc1 = gameService.createYellowCard(game, player, YELLOW_CARD_TIME_2);
        RedCard rc = gameService.createRedCard(game, player, RED_CARD_TIME);
        Substitution subs = gameService.createSubs(game, player1, player, SUBS_TIME);

        Assert.assertNotNull(gameService.showGameAndStats(game, Set.of(goal, goal1), Set.of(goalConc),
                Set.of(yc, yc1), Set.of(rc), Set.of(subs)));
    }
}