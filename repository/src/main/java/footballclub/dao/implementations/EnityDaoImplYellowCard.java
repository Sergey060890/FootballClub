package footballclub.dao.implementations;

import footballclub.dao.interfaces.YellowCardDao;
import footballclub.entity.YellowCard;
import footballclub.util.HibernateUtil;

public class EnityDaoImplYellowCard extends EntityDaoImpl<YellowCard> implements YellowCardDao {
    public EnityDaoImplYellowCard() {
        super(YellowCard.class, HibernateUtil.getEntityManager());
    }
}
