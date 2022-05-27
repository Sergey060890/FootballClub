package footballclub.entityTest;


//import static org.testng.AssertJUnit.assertTrue;

public class PlayerTest {
//    private static final List<Player> players = new ArrayList<>();
//    /**
//     * Rigorous PlayerTest :-)
//     */
//    @Test
//    public void shouldAnswerWithTrue() {
//        assertTrue(true);
//    }
//
//    @Test
//    public void jpqlPlayer() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        EntityManager entityManager = HibernateUtil.getEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(team);
//        entityManager.persist(player);
//        Player player1 = entityManager.find(Player.class,player.getPlayer_id());
//        players.add(player);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        Assert.assertNotNull(player1);
//        Assert.assertNotNull(player1.getPlayer_id());
//        Assert.assertEquals("Player names don't match",
//                PLAYER_SURNAME, player.getPlayer_surname());
//    }
//
//    @Test
//    public void insertTestPlayer() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        EnityDaoImplPlayer daoPlayer = new EnityDaoImplPlayer();
//        daoPlayer.insert(team);
//        daoPlayer.insert(player);
//        players.add(player);
//        Assert.assertNotNull(daoPlayer.getEntity(player.getPlayer_id()));
//    }
//
//    @Test
//    public void deleteTestPlayer()  {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        EnityDaoImplPlayer daoPlayer = new EnityDaoImplPlayer();
//        daoPlayer.insert(team);
//        daoPlayer.insert(player);
//        players.add(player);
//        daoPlayer.delete(player);
//        Assert.assertNotNull(player);
//    }
//
//    @Test
//    public void deleteIdTestPlayer ()  {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        EnityDaoImplPlayer daoPlayer = new EnityDaoImplPlayer();
//        daoPlayer.insert(team);
//        daoPlayer.insert(player);
//        daoPlayer.deleteById(player.getPlayer_id());
//        Assert.assertNotNull(player);
//    }
//
//    @Test
//    public void updateTestPlayer() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        EnityDaoImplPlayer daoPlayer = new EnityDaoImplPlayer();
//        daoPlayer.insert(team);
//        daoPlayer.insert(player);
//        player.setAge(SET_PLAYER_AGE);
//        players.add(player);
//        daoPlayer.update(player);
//        Assert.assertEquals(player.getAge(),
//                SET_PLAYER_AGE);
//    }
//
//    @Test
//    public void getEntityTestPlayer() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        EnityDaoImplPlayer daoPlayer = new EnityDaoImplPlayer();
//        daoPlayer.insert(team);
//        daoPlayer.insert(player);
//        players.add(player);
//        Assert.assertNotNull(daoPlayer.getEntity(player.getPlayer_id()).toString());
//    }
//
//    @Test
//    public void addPlayerTeamIDTest() {
//        Team team = Utils.createTeam();
//        Player player = Utils.createPlayer(team);
//        EnityDaoImplPlayer daoPlayer = new EnityDaoImplPlayer();
//        player.setPlayer_id(SET_PLAYER_ID);
//        daoPlayer.insert(team);
//        players.add(player);
//        daoPlayer.addPlayerTeamID(team.getTeam_id(), player);
//        Assert.assertEquals(team.getTeam_id(),player.getTeamPlayer().getTeam_id());
//    }

}
