package footballclub.dao.implementations;

import footballclub.dao.interfaces.TeamDao;
import footballclub.entity.Team;
import footballclub.util.HibernateUtil;

public class EnityDaoImplTeam extends EntityDaoImpl<Team> implements TeamDao {

    public EnityDaoImplTeam() {
        super(Team.class,HibernateUtil.getEntityManager());
    }

//    private static EntityManager em;

//    public List<Object[]> listOfAllTask() {
//        em = HibernateUtil.getEntityManager();
//        Query query = em.createQuery(
//                "SELECT t.id, t.team_name, t.city, t.country, t.stadium,t.coach " +
//                        "FROM footballclub.entity.Team t ");
//        List<Object[]> list = query.getResultList();
//        em.close();
//        return list;
//    }

//    public List<Team> findAllTeam() {
//        EntityManager em = HibernateUtil.getEntityManager();
//        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//        CriteriaQuery<Team> criteria = criteriaBuilder.createQuery(Team.class);
//        Root<Team> teamRoot = criteria.from(Team.class);
//        criteria.select(teamRoot);
//        return em.createQuery(criteria).getResultList();
//    }
}
