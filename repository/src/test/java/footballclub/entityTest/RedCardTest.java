package footballclub.entityTest;

import footballclub.dao.EnityDaoImplRedCard;
import footballclub.entity.Game;
import footballclub.entity.Player;
import footballclub.entity.RedCard;
import footballclub.entity.Team;
import footballclub.util.HibernateUtil;
import footballclub.utilsTest.Utils;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static footballclub.Constans.RED_CARD_TIME;
import static footballclub.Constans.SET_RED_CARD_TIME;
import static org.junit.Assert.assertTrue;
//import static org.testng.AssertJUnit.assertTrue;

public class RedCardTest {
    private static final List<RedCard>
            redCards = new ArrayList<>();

    /**
     * Rigorous RedCardTest :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void jpqlRedCard() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        RedCard redCard = Utils.createRedCard(game, player);
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(team);
        entityManager.persist(player);
        entityManager.persist(game);
        entityManager.persist(redCard);
        RedCard redCard1 = entityManager.find(RedCard.class,
                redCard.getRed_card_id());
        redCards.add(redCard);
        entityManager.getTransaction().commit();
        entityManager.close();
        Assert.assertNotNull(redCard1);
        Assert.assertNotNull(redCard1.getRed_card_id());
        Assert.assertEquals("Player removal time is different",
                RED_CARD_TIME, redCard.getCard_time());
    }

    @Test
    public void insertTestRedCard() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        RedCard redCard = Utils.createRedCard(game, player);
        EnityDaoImplRedCard daoRedCard
                = new EnityDaoImplRedCard(RedCard.class);
        daoRedCard.insert(team);
        daoRedCard.insert(player);
        daoRedCard.insert(game);
        daoRedCard.insert(redCard);
        redCards.add(redCard);
        Assert.assertNotNull(daoRedCard.getEntity
                (redCard.getRed_card_id()));
    }

    @Test
    public void deleteTestRedCard() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        RedCard redCard = Utils.createRedCard(game, player);
        EnityDaoImplRedCard daoRedCard
                = new EnityDaoImplRedCard(RedCard.class);
        redCards.add(redCard);
        daoRedCard.insert(game);
        daoRedCard.insert(player);
        daoRedCard.insert(redCard);
        daoRedCard.delete(redCard);
        Assert.assertNull(redCard.getRed_card_id());
    }

    @Test
    public void deleteIdTestRedCard() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        RedCard redCard = Utils.createRedCard(game, player);
        EnityDaoImplRedCard daoRedCard
                = new EnityDaoImplRedCard(RedCard.class);
        daoRedCard.deleteById(redCard.getRed_card_id());
        Assert.assertNull(redCard.getRed_card_id());
    }

    @Test
    public void updateTestRedCard() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        RedCard redCard = Utils.createRedCard(game, player);
        EnityDaoImplRedCard daoRedCard
                = new EnityDaoImplRedCard(RedCard.class);
        daoRedCard.insert(team);
        daoRedCard.insert(player);
        daoRedCard.insert(game);
        daoRedCard.insert(redCard);
        redCard.setCard_time(SET_RED_CARD_TIME);
        redCards.add(redCard);
        daoRedCard.update(redCard);
        Assert.assertEquals(redCard.getCard_time(),
                SET_RED_CARD_TIME);
    }

    @Test
    public void getEntityTestRedCard() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        RedCard redCard = Utils.createRedCard(game, player);
        EnityDaoImplRedCard daoRedCard
                = new EnityDaoImplRedCard(RedCard.class);
        daoRedCard.insert(team);
        daoRedCard.insert(player);
        daoRedCard.insert(game);
        daoRedCard.insert(redCard);
        redCards.add(redCard);
        Assert.assertNotNull(daoRedCard.getEntity(redCard.
                getRed_card_id()).toString());

    }

    @Test
    public void selectTestRedCard() {
        Team team = Utils.createTeam();
        Player player = Utils.createPlayer(team);
        Game game = Utils.createGame(team, Set.of(player));
        RedCard redCard = Utils.createRedCard(game, player);
        EnityDaoImplRedCard daoRedCard
                = new EnityDaoImplRedCard(RedCard.class);
        daoRedCard.insert(team);
        daoRedCard.insert(player);
        daoRedCard.insert(game);
        daoRedCard.insert(redCard);
        redCards.add(redCard);
        Assert.assertEquals(redCards.toString(), daoRedCard.select().toString());
    }
}
