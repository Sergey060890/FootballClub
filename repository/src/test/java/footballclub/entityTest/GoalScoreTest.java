package footballclub.entityTest;

import footballclub.dao.EnityDaoImplGoalScore;
import footballclub.entity.Game;
import footballclub.entity.GoalScore;
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
//import static org.testng.AssertJUnit.assertTrue;

public class GoalScoreTest {
    private static final List<GoalScore>
            goalScores = new ArrayList<>();

    /**
     * Rigorous GoalScoreTest :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void jpqlGoalScore() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        GoalScore goalScore = Utils.createGoalScore(game, player);
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(team);
        entityManager.persist(player);
        entityManager.persist(game);
        entityManager.persist(goalScore);
        GoalScore goalScore1 = entityManager.find(GoalScore.class,
                goalScore.getGoal_id());
        goalScores.add(goalScore);
        entityManager.getTransaction().commit();
        entityManager.close();
        Assert.assertNotNull(goalScore1);
        Assert.assertNotNull(goalScore1.getGoal_id());
        Assert.assertEquals("Goal time doesn't match",
                GOAL_TIME, goalScore.getGoal_time());
    }

    @Test
    public void insertTestGoalScore() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        GoalScore goalScore = Utils.createGoalScore(game, player);
        EnityDaoImplGoalScore daoGoalScore
                = new EnityDaoImplGoalScore(GoalScore.class);
        daoGoalScore.insert(team);
        daoGoalScore.insert(player);
        daoGoalScore.insert(game);
        daoGoalScore.insert(goalScore);
        goalScores.add(goalScore);
        Assert.assertNotNull(daoGoalScore.getEntity(goalScore.getGoal_id()));
    }

    @Test
    public void deleteTestGoalScore() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        GoalScore goalScore = Utils.createGoalScore(game, player);
        EnityDaoImplGoalScore daoGoalScore
                = new EnityDaoImplGoalScore(GoalScore.class);
        daoGoalScore.insert(game);
        daoGoalScore.insert(player);
        daoGoalScore.delete(goalScore);
        Assert.assertNull(goalScore.getGoal_id());
    }

    @Test
    public void deleteIdTestGoalScore() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        GoalScore goalScore = Utils.createGoalScore(game, player);
        EnityDaoImplGoalScore daoGoalScore
                = new EnityDaoImplGoalScore(GoalScore.class);
        daoGoalScore.insert(team);
        daoGoalScore.insert(player);
        daoGoalScore.insert(game);
        daoGoalScore.deleteById(goalScore.getGoal_id());
        Assert.assertNull(goalScore.getGoal_id());
    }

    @Test
    public void updateTestGoalScore() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        GoalScore goalScore = Utils.createGoalScore(game, player);
        EnityDaoImplGoalScore daoGoalScore
                = new EnityDaoImplGoalScore(GoalScore.class);
        daoGoalScore.insert(team);
        daoGoalScore.insert(player);
        daoGoalScore.insert(game);
        daoGoalScore.insert(goalScore);
        goalScore.setGoal_time(SET_GOAL_TIME);
        goalScores.add(goalScore);
        daoGoalScore.update(goalScore);
        Assert.assertEquals(goalScore.getGoal_time(),
                SET_GOAL_TIME);
    }

    @Test
    public void getEntityTestGoalScore() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        GoalScore goalScore = Utils.createGoalScore(game, player);
        EnityDaoImplGoalScore daoGoalScore
                = new EnityDaoImplGoalScore(GoalScore.class);
        daoGoalScore.insert(team);
        daoGoalScore.insert(player);
        daoGoalScore.insert(game);
        daoGoalScore.insert(goalScore);
        goalScores.add(goalScore);
        Assert.assertNotNull(daoGoalScore.getEntity(goalScore.
                getGoal_id()).toString());
    }

    @Test
    public void selectTestGoalScore() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        GoalScore goalScore = Utils.createGoalScore(game, player);
        EnityDaoImplGoalScore daoGoalScore
                = new EnityDaoImplGoalScore(GoalScore.class);
        daoGoalScore.insert(team);
        daoGoalScore.insert(player);
        daoGoalScore.insert(game);
        daoGoalScore.insert(goalScore);
        goalScores.add(goalScore);
        Assert.assertEquals(goalScores.toString(), daoGoalScore.select().toString());
    }
}
