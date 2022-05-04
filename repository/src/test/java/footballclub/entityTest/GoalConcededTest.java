package footballclub.entityTest;

import footballclub.dao.EnityDaoImplGoalConceded;
import footballclub.entity.Game;
import footballclub.entity.GoalConceded;
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

import static footballclub.Constans.CONCEDED_TIME;
import static footballclub.Constans.SET_CONCEDED_TIME;
import static org.junit.Assert.assertTrue;

public class GoalConcededTest {
    private static final List<GoalConceded>
            goalConcededs = new ArrayList<>();

    /**
     * Rigorous GoalConcededTest :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void jpqlGoalConceded() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        GoalConceded goalConceded = Utils.createGoalConceded(game, player);
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(team);
        entityManager.persist(player);
        entityManager.persist(game);
        entityManager.persist(goalConceded);
        GoalConceded goalConceded1 = entityManager.find(GoalConceded.class,
                goalConceded.getGoal_conceded_id());
        goalConcededs.add(goalConceded);
        entityManager.getTransaction().commit();
        entityManager.close();
        Assert.assertNotNull(goalConceded1);
        Assert.assertNotNull(goalConceded1.getGoal_conceded_id());
        Assert.assertEquals("Goal conceding time is different",
                CONCEDED_TIME, goalConceded.getConceded_time());
    }

    @Test
    public void insertTestGoalConceded() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        GoalConceded goalConceded = Utils.createGoalConceded(game, player);
        EnityDaoImplGoalConceded daoGoalConceded
                = new EnityDaoImplGoalConceded(GoalConceded.class);
        daoGoalConceded.insert(team);
        daoGoalConceded.insert(player);
        daoGoalConceded.insert(game);
        daoGoalConceded.insert(goalConceded);
        goalConcededs.add(goalConceded);
        Assert.assertNotNull(daoGoalConceded.getEntity
                (goalConceded.getGoal_conceded_id()));
    }

    @Test
    public void deleteTestGoalConceded() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        GoalConceded goalConceded = Utils.createGoalConceded(game, player);
        EnityDaoImplGoalConceded daoGoalConceded
                = new EnityDaoImplGoalConceded(GoalConceded.class);
        goalConcededs.add(goalConceded);
        daoGoalConceded.insert(game);
        daoGoalConceded.insert(player);
        daoGoalConceded.insert(goalConceded);
        daoGoalConceded.delete(goalConceded);
        Assert.assertNull(goalConceded.getGoal_conceded_id());
    }

    @Test
    public void deleteIdTestGoalConceded() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        GoalConceded goalConceded = Utils.createGoalConceded(game, player);
        EnityDaoImplGoalConceded daoGoalConceded
                = new EnityDaoImplGoalConceded(GoalConceded.class);
        daoGoalConceded.deleteById(goalConceded.getGoal_conceded_id());
        Assert.assertNull(goalConceded.getGoal_conceded_id());
    }

    @Test
    public void updateTestGoalConceded() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        GoalConceded goalConceded = Utils.createGoalConceded(game, player);
        EnityDaoImplGoalConceded daoGoalConceded
                = new EnityDaoImplGoalConceded(GoalConceded.class);
        daoGoalConceded.insert(team);
        daoGoalConceded.insert(game);
        daoGoalConceded.insert(player);
        daoGoalConceded.insert(goalConceded);
        goalConceded.setConceded_time(SET_CONCEDED_TIME);
        goalConcededs.add(goalConceded);
        daoGoalConceded.update(goalConceded);
        Assert.assertEquals(goalConceded.getConceded_time(),
                SET_CONCEDED_TIME);
    }

    @Test
    public void getEntityTestGoalConceded() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        GoalConceded goalConceded = Utils.createGoalConceded(game, player);
        EnityDaoImplGoalConceded daoGoalConceded
                = new EnityDaoImplGoalConceded(GoalConceded.class);
        daoGoalConceded.insert(team);
        daoGoalConceded.insert(player);
        daoGoalConceded.insert(game);
        daoGoalConceded.insert(goalConceded);
        goalConcededs.add(goalConceded);
        Assert.assertNotNull(daoGoalConceded.getEntity
                (goalConceded.getGoal_conceded_id()).toString());
    }

    @Test
    public void selectTestGoalConceded() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        GoalConceded goalConceded = Utils.createGoalConceded(game, player);
        EnityDaoImplGoalConceded daoGoalConceded
                = new EnityDaoImplGoalConceded(GoalConceded.class);
        daoGoalConceded.insert(team);
        daoGoalConceded.insert(player);
        daoGoalConceded.insert(game);
        daoGoalConceded.insert(goalConceded);
        goalConcededs.add(goalConceded);
        Assert.assertEquals(goalConcededs.toString(),
                daoGoalConceded.select().toString());
    }
}
