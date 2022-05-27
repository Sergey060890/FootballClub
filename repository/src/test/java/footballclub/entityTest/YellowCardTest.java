package footballclub.entityTest;

//import static org.testng.AssertJUnit.assertTrue;

public class YellowCardTest {
//    private static final List<YellowCard>
//            yellowCards = new ArrayList<>();
//
//    /**
//     * Rigorous YellowCardsTest :-)
//     */
//    @Test
//    public void shouldAnswerWithTrue() {
//        assertTrue(true);
//    }
//
//    @Test
//    public void jpqlYellowCard() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        Game game = Utils.createGame(team, Set.of(player));
//        YellowCard yellowCard = Utils.createYellowCard(game, player);
//        EntityManager entityManager = HibernateUtil.getEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(team);
//        entityManager.persist(player);
//        entityManager.persist(game);
//        entityManager.persist(yellowCard);
//        YellowCard yellowCard1 = entityManager.find(YellowCard.class,
//                yellowCard.getYellow_card_id());
//        yellowCards.add(yellowCard);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        Assert.assertNotNull(yellowCard1);
//        Assert.assertNotNull(yellowCard1.getYellow_card_id());
//        Assert.assertEquals("Card pick up times vary",
//                YELLOW_CARD_TIME, yellowCard.getCard_time());
//    }
//
//    @Test
//    public void insertTestYellowCard() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        Game game = Utils.createGame(team, Set.of(player));
//        YellowCard yellowCard = Utils.createYellowCard(game, player);
//        EnityDaoImplYellowCard daoYellowCard
//                = new EnityDaoImplYellowCard();
//        daoYellowCard.insert(team);
//        daoYellowCard.insert(player);
//        daoYellowCard.insert(game);
//        daoYellowCard.insert(yellowCard);
//        yellowCards.add(yellowCard);
//        Assert.assertNotNull(daoYellowCard.getEntity
//                (yellowCard.getYellow_card_id()));
//    }
//
//    @Test
//    public void deleteTestYellowCard() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        Game game = Utils.createGame(team, Set.of(player));
//        YellowCard yellowCard = Utils.createYellowCard(game, player);
//        EnityDaoImplRedCard daoRedCard
//                = new EnityDaoImplRedCard();
//        daoRedCard.insert(game);
//        daoRedCard.insert(player);
//        daoRedCard.delete(yellowCard);
//        Assert.assertNull(yellowCard.getYellow_card_id());
//    }
//
//    @Test
//    public void deleteIdTestYellowCard() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        Game game = Utils.createGame(team, Set.of(player));
//        YellowCard yellowCard = Utils.createYellowCard(game, player);
//        EnityDaoImplYellowCard daoYellowCard
//                = new EnityDaoImplYellowCard();
//        daoYellowCard.deleteById(yellowCard.getYellow_card_id());
//        Assert.assertNull(yellowCard.getYellow_card_id());
//    }
//
//    @Test
//    public void updateTestYellowCard() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        Game game = Utils.createGame(team, Set.of(player));
//        YellowCard yellowCard = Utils.createYellowCard(game, player);
//        EnityDaoImplYellowCard daoYellowCard
//                = new EnityDaoImplYellowCard();
//        daoYellowCard.insert(team);
//        daoYellowCard.insert(player);
//        daoYellowCard.insert(game);
//        daoYellowCard.insert(yellowCard);
//        yellowCard.setCard_time(SET_YELLOW_CARD_TIME);
//        yellowCards.add(yellowCard);
//        daoYellowCard.update(yellowCard);
//        Assert.assertEquals(yellowCard.getCard_time(),
//                SET_YELLOW_CARD_TIME);
//    }
//
//    @Test
//    public void getEntityTestYellowCard() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        Game game = Utils.createGame(team, Set.of(player));
//        YellowCard yellowCard = Utils.createYellowCard(game, player);
//        EnityDaoImplYellowCard daoYellowCard
//                = new EnityDaoImplYellowCard();
//        daoYellowCard.insert(team);
//        daoYellowCard.insert(player);
//        daoYellowCard.insert(game);
//        daoYellowCard.insert(yellowCard);
//        yellowCards.add(yellowCard);
//        Assert.assertNotNull(daoYellowCard.getEntity
//                (yellowCard.getYellow_card_id()).toString());
//    }
//
//    @Test
//    public void selectTestYellowCard() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        Game game = Utils.createGame(team, Set.of(player));
//        YellowCard yellowCard = Utils.createYellowCard(game, player);
//        EnityDaoImplYellowCard daoYellowCard
//                = new EnityDaoImplYellowCard();
//        daoYellowCard.insert(player);
//        daoYellowCard.insert(game);
//        daoYellowCard.insert(yellowCard);
//        Assert.assertEquals(yellowCards.toString(),
//                daoYellowCard.select().toString());
//    }
}
