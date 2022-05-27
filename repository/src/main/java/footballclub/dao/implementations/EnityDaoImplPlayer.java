package footballclub.dao.implementations;

import footballclub.dao.interfaces.PlayerDao;
import footballclub.entity.Player;
import footballclub.entity.Team;
import footballclub.util.HibernateUtil;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;

public class EnityDaoImplPlayer extends EntityDaoImpl<Player> implements PlayerDao {
    private static EntityManager em;

    public EnityDaoImplPlayer() {
        super(Player.class,HibernateUtil.getEntityManager());
    }

    public void addPlayerTeamID(Integer team_id, Player player) {
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Team team = em.find(Team.class, team_id);
            Player player1 = Player.builder()
                    .player_name(player.getPlayer_name())
                    .player_surname(player.getPlayer_surname())
                    .teamPlayer(team)
                    .age(player.getAge())
                    .country(player.getCountry())
                    .position(player.getPosition())
                    .build();
            System.out.println("Player " + player.getPlayer_name() +
                    " " + player.getPlayer_surname() + " added to team "
                    + team.getTeam_name());
            em.persist(player1);
            em.getTransaction().commit();
        } catch (HibernateException e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
