package footballclub.entityTest;

import footballclub.dao.EnityDaoImplGame;
import footballclub.entity.Game;
import footballclub.entity.Player;
import footballclub.entity.Team;
import footballclub.util.HibernateUtil;
import footballclub.utilsTest.Utils;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static footballclub.Constans.*;
import static org.junit.Assert.assertTrue;


public class GameTest {
    private static final List<Game> games = new ArrayList<>();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void jpqlGame() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(team);
        entityManager.persist(player);
        entityManager.persist(game);
        Game game1 = entityManager.find(Game.class,game.getGame_id());
        games.add(game);
        entityManager.getTransaction().commit();
        entityManager.close();
        Assert.assertNotNull(game1);
        Assert.assertNotNull(game1.getGame_id());
        Assert.assertEquals("Team names don't match",
                OPPONENT_NAME, game.getOpponent_name());
    }

    @Test
    public void insertTestGame () {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        EnityDaoImplGame daoGame = new EnityDaoImplGame(Game.class);
        daoGame.insert(team);
        daoGame.insert(player);
        daoGame.insert(game);
        games.add(game);
        Assert.assertNotNull(daoGame.getEntity(game.getGame_id()));
    }

    @Test
    public void deleteTestGame()  {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        EnityDaoImplGame daoGame = new EnityDaoImplGame(Game.class);
        daoGame.insert(team);
        daoGame.insert(player);
        daoGame.insert(game);
        games.add(game);
        daoGame.delete(game);
        Assert.assertNotNull(game);
    }

    @Test
    public void deleteIdTestGame ()  {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        EnityDaoImplGame daoGame = new EnityDaoImplGame(Game.class);
        daoGame.insert(team);
        daoGame.insert(player);
        daoGame.insert(game);
        daoGame.deleteById(game.getGame_id());
        Assert.assertNotNull(team);
    }

    @Test
    public void updateTestGame() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        EnityDaoImplGame daoGame = new EnityDaoImplGame(Game.class);
        daoGame.insert(team);
        daoGame.insert(player);
        daoGame.insert(game);
        game.setOpponent_name(SET_OPPONENT_NAME);
        games.add(game);
        daoGame.update(game);
        Assert.assertEquals(game.getOpponent_name(),
                SET_OPPONENT_NAME);
    }

    @Test
    public void getEntityTestGame() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        EnityDaoImplGame daoGame = new EnityDaoImplGame(Game.class);
        daoGame.insert(team);
        daoGame.insert(player);
        daoGame.insert(game);
        games.add(game);
        Assert.assertNotNull(daoGame.getEntity(game.getGame_id()).toString());
    }

    @Test
    public void selectTestGame() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        EnityDaoImplGame daoGame = new EnityDaoImplGame(Game.class);
        daoGame.insert(team);
        daoGame.insert(player);
        daoGame.insert(game);
        games.add(game);
        Assert.assertEquals(games.toString(), daoGame.select().toString());
    }
}

