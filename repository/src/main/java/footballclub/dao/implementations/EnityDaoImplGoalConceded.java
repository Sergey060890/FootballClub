package footballclub.dao.implementations;

import footballclub.dao.interfaces.GoalConcededDao;
import footballclub.entity.GoalConceded;
import footballclub.util.HibernateUtil;

public class EnityDaoImplGoalConceded extends EntityDaoImpl<GoalConceded> implements GoalConcededDao {
    public EnityDaoImplGoalConceded() {
        super(GoalConceded.class, HibernateUtil.getEntityManager());
    }
}
