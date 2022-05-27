package footballclub.dao.implementations;

import footballclub.dao.interfaces.RedCardDao;
import footballclub.entity.RedCard;
import footballclub.util.HibernateUtil;

public class EnityDaoImplRedCard extends EntityDaoImpl<RedCard> implements RedCardDao {
    public EnityDaoImplRedCard() {
        super(RedCard.class, HibernateUtil.getEntityManager());
    }
}
