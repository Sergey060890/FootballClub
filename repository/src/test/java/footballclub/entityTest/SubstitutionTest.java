package footballclub.entityTest;

public class SubstitutionTest {
//    private static final List<Substitution>
//            substitutions = new ArrayList<>();
//
//    /**
//     * Rigorous SubstitutionTest :-)
//     */
//    @Test
//    public void shouldAnswerWithTrue() {
//        assertTrue(true);
//    }
//
//    @Test
//    public void jpqlSubstitution() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        Player player1 = Utils.createPlayerSubs(team);
//        Game game = Utils.createGame(team, Set.of(player));
//        Substitution substitution = Utils.createSubstitution
//                (game, player, player1);
//        EntityManager entityManager = HibernateUtil.getEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(team);
//        entityManager.persist(player);
//        entityManager.persist(player1);
//        entityManager.persist(game);
//        entityManager.persist(substitution);
//        Substitution substitution1 = entityManager.find(Substitution.class,
//                substitution.getSubstitution_id());
//        substitutions.add(substitution);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        Assert.assertNotNull(substitution1);
//        Assert.assertNotNull(substitution1.getSubstitution_id());
//        Assert.assertEquals("Replacement time does not match",
//                SUBS_TIME, substitution.getSubs_time());
//    }
//
//    @Test
//    public void insertTestSubstitution() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        Player player1 = Utils.createPlayerSubs(team);
//        Game game = Utils.createGame(team, Set.of(player));
//        Substitution substitution = Utils.createSubstitution
//                (game, player, player1);
//        EnityDaoImplSubstitution daoSubs
//                = new EnityDaoImplSubstitution();
//        daoSubs.insert(team);
//        daoSubs.insert(player);
//        daoSubs.insert(player1);
//        daoSubs.insert(game);
//        daoSubs.insert(substitution);
//        substitutions.add(substitution);
//        Assert.assertNotNull(daoSubs.getEntity
//                (substitution.getSubstitution_id()));
//    }
//
//    @Test
//    public void deleteTestSubstitution() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        Player player1 = Utils.createPlayerSubs(team);
//        Game game = Utils.createGame(team, Set.of(player));
//        Substitution substitution = Utils.createSubstitution
//                (game, player, player1);
//        EnityDaoImplSubstitution daoSubs
//                = new EnityDaoImplSubstitution();
//        daoSubs.insert(game);
//        daoSubs.insert(player);
//        daoSubs.delete(substitution);
//        Assert.assertNull(substitution.getSubstitution_id());
//    }
//
//    @Test
//    public void deleteIdTestSubstitution() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        Player player1 = Utils.createPlayerSubs(team);
//        Game game = Utils.createGame(team, Set.of(player));
//        Substitution substitution = Utils.createSubstitution
//                (game, player, player1);
//        EnityDaoImplSubstitution daoSubs
//                = new EnityDaoImplSubstitution();
//        daoSubs.deleteById(substitution.getSubstitution_id());
//        Assert.assertNull(substitution.getSubstitution_id());
//    }
//
//    @Test
//    public void updateTestSubstitution() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        Player player1 = Utils.createPlayerSubs(team);
//        Game game = Utils.createGame(team, Set.of(player));
//        Substitution substitution = Utils.createSubstitution
//                (game, player, player1);
//        EnityDaoImplSubstitution daoSubs
//                = new EnityDaoImplSubstitution();
//        daoSubs.insert(team);
//        daoSubs.insert(player);
//        daoSubs.insert(player1);
//        daoSubs.insert(game);
//        daoSubs.insert(substitution);
//        substitution.setSubs_time(SET_SUBS_TIME);
//        substitutions.add(substitution);
//        daoSubs.update(substitution);
//        Assert.assertEquals(substitution.getSubs_time(),
//                SET_SUBS_TIME);
//    }
//
//    @Test
//    public void getEntityTestSubstitution() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        Player player1 = Utils.createPlayerSubs(team);
//        Game game = Utils.createGame(team, Set.of(player));
//        Substitution substitution = Utils.createSubstitution
//                (game, player, player1);
//        EnityDaoImplSubstitution daoSubs
//                = new EnityDaoImplSubstitution();
//        daoSubs.insert(team);
//        daoSubs.insert(player);
//        daoSubs.insert(player1);
//        daoSubs.insert(game);
//        daoSubs.insert(substitution);
//        substitutions.add(substitution);
//        Assert.assertNotNull(daoSubs.getEntity
//                (substitution.getSubstitution_id()).toString());
//    }
//
//    @Test
//    public void selectTestSubstitution() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        Player player1 = Utils.createPlayerSubs(team);
//        Game game = Utils.createGame(team, Set.of(player));
//        Substitution substitution = Utils.createSubstitution
//                (game, player, player1);
//        EnityDaoImplSubstitution daoSubs
//                = new EnityDaoImplSubstitution();
//        daoSubs.insert(team);
//        daoSubs.insert(player);
//        daoSubs.insert(player1);
//        daoSubs.insert(game);
//        daoSubs.insert(substitution);
//        substitutions.add(substitution);
//        Assert.assertEquals(substitutions.toString(),
//                daoSubs.select().toString());
//    }
}
