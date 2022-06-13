package serviceTest;

public class TeamServiceImplTest {
//    @Test
//    public void testCreateTeam() {
//        EnityDaoImplTeam daoImplTeam = new EnityDaoImplTeam(Team.class);
//        TeamServiceImpl teamService =
//                new TeamServiceImpl(new EnityDaoImplTeam(Team.class));
//        Team team = teamService.createTeam(TEAM_NAME, TEAM_CITY,
//                TEAM_COUNTRY, TEAM_STADIUM, TEAM_COUCH);
//        Assert.assertNotNull(daoImplTeam.getEntity(team.getTeam_id()));
//    }
//
//    @Test
//    public void testAddPlayerInTeam() {
//        PlayerService playerService =
//                new PlayerServiceImpl(new EnityDaoImplPlayer(Player.class));
//        Player player = playerService.createPlayer(PLAYER_NAME,PLAYER_SURNAME,
//                PLAYER_COUNTRY,PLAYER_AGE,PLAYER_POSITION);
//        TeamServiceImpl teamService =
//                new TeamServiceImpl(new EnityDaoImplTeam(Team.class));
//        Team team = teamService.createTeam(TEAM_NAME, TEAM_CITY,
//                TEAM_COUNTRY, TEAM_STADIUM, TEAM_COUCH);
//        teamService.addPlayerInTeam(player,team);
//        Assert.assertEquals(player.getTeam().getTeam_name(),TEAM_NAME);
//    }
//
//    @Test
//    public void testDeletePlayerWithTeam() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
//        PlayerService playerService =
//                new PlayerServiceImpl(new EnityDaoImplPlayer(Player.class));
//        Player player = playerService.createPlayer(PLAYER_NAME, PLAYER_SURNAME,
//                PLAYER_COUNTRY, PLAYER_AGE, PLAYER_POSITION);
//        TeamServiceImpl teamService =
//                new TeamServiceImpl(new EnityDaoImplTeam(Team.class));
//        Team team = teamService.createTeam(TEAM_NAME, TEAM_CITY,
//                TEAM_COUNTRY, TEAM_STADIUM, TEAM_COUCH);
//        teamService.addPlayerInTeam(player, team);
//        teamService.deletePlayerWithTeam(player);
//        Assert.assertNull(player.getTeam());
//    }
//
//    @Test
//    public void testShowOnePlayerInfo() {
//        PlayerService playerService =
//                new PlayerServiceImpl(new EnityDaoImplPlayer(Player.class));
//        Player player = playerService.createPlayer(PLAYER_NAME, PLAYER_SURNAME,
//                PLAYER_COUNTRY, PLAYER_AGE, PLAYER_POSITION);
//        TeamServiceImpl teamService =
//                new TeamServiceImpl(new EnityDaoImplTeam(Team.class));
//        Team team = teamService.createTeam(TEAM_NAME, TEAM_CITY,
//                TEAM_COUNTRY, TEAM_STADIUM, TEAM_COUCH);
//        teamService.addPlayerInTeam(player, team);
//        Assert.assertEquals(player.toString(), teamService.showOnePlayerInfo(player));
//    }
//
//    @Test
//    public void testShowAllPlayerTeamInfo() {
//        List<Player> players = new ArrayList<>();
//        PlayerService playerService =
//                new PlayerServiceImpl(new EnityDaoImplPlayer(Player.class));
//        Player player = playerService.createPlayer(PLAYER_NAME, PLAYER_SURNAME,
//                PLAYER_COUNTRY, PLAYER_AGE, PLAYER_POSITION);
//        Player player1 = playerService.createPlayer(PLAYER_NAME_2, PLAYER_SURNAME_2,
//                PLAYER_COUNTRY_2, PLAYER_AGE_2, PLAYER_POSITION_2);
//        TeamServiceImpl teamService =
//                new TeamServiceImpl(new EnityDaoImplTeam(Team.class));
//        Team team = teamService.createTeam(TEAM_NAME, TEAM_CITY,
//                TEAM_COUNTRY, TEAM_STADIUM, TEAM_COUCH);
//        teamService.addPlayerInTeam(player, team);
//        teamService.addPlayerInTeam(player1, team);
//        Assert.assertEquals(players, teamService.showAllPlayerTeamInfo(team));
//    }
}
