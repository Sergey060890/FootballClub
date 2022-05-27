package footballclub.dao.implementations;

import footballclub.dao.interfaces.GoalScoreDao;
import footballclub.entity.GoalScore;
import footballclub.util.HibernateUtil;

public class EnityDaoImplGoalScore extends EntityDaoImpl<GoalScore> implements GoalScoreDao {
    public EnityDaoImplGoalScore() {
        super(GoalScore.class, HibernateUtil.getEntityManager());
    }
}
