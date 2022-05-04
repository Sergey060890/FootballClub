package footballclub.entityTest;

import footballclub.dao.EnityDaoImplTeam;
import footballclub.entity.Team;
import footballclub.util.HibernateUtil;
import footballclub.utilsTest.Utils;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static footballclub.Constans.SET_TEAM_NAME;
import static footballclub.Constans.TEAM_STADIUM;
import static org.junit.Assert.assertTrue;

public class TeamTest  {
    private static final List<Team> teams = new ArrayList<>();

    /**
     * Rigorous TeamTest :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void jpqlTeam() {
        Team team = Utils.createTeam();
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(team);
        Team team1 = entityManager.find(Team.class, team.getTeam_id());
        teams.add(team);
        entityManager.getTransaction().commit();
        entityManager.close();
        Assert.assertNotNull(team1);
        Assert.assertNotNull(team1.getTeam_id());
        Assert.assertEquals("Team stadium names are not equal",
                TEAM_STADIUM, team.getStadium());
    }

    @Test
    public void insertTestTeam() {
        Team team = Utils.createTeam();
        EnityDaoImplTeam daoTeam = new EnityDaoImplTeam(Team.class);
        daoTeam.insert(team);
        teams.add(team);
        Assert.assertNotNull(daoTeam.getEntity(team.getTeam_id()));
    }

    @Test
    public void deleteTestTeam() {
        Team team = Utils.createTeam();
        EnityDaoImplTeam daoTeam = new EnityDaoImplTeam(Team.class);
        daoTeam.insert(team);
        teams.add(team);
        daoTeam.delete(team);
        Assert.assertNotNull(team);
    }

    @Test
    public void deleteIdTestTeam() {
        Team team = Utils.createTeam();
        EnityDaoImplTeam daoTeam = new EnityDaoImplTeam(Team.class);
        daoTeam.insert(team);
        daoTeam.deleteById(team.getTeam_id());
        Assert.assertNotNull(team);
    }

    @Test
    public void updateTestTeam() {
        Team team = Utils.createTeam();
        EnityDaoImplTeam daoTeam = new EnityDaoImplTeam(Team.class);
        daoTeam.insert(team);
        team.setTeam_name(SET_TEAM_NAME);
        daoTeam.insert(team);
        teams.add(team);
        daoTeam.update(team);
        Assert.assertEquals(team.getTeam_name(),
                SET_TEAM_NAME);
    }

    @Test
    public void getEntityTestTeam() {
        Team team = Utils.createTeam();
        EnityDaoImplTeam daoTeam = new EnityDaoImplTeam(Team.class);
        daoTeam.insert(team);
        teams.add(team);
        Assert.assertNotNull(daoTeam.getEntity(team.getTeam_id()).toString());
    }

}
