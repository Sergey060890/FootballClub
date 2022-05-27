package footballclub.dao.implementations;

import footballclub.dao.interfaces.SubsDao;
import footballclub.entity.Substitution;
import footballclub.util.HibernateUtil;

public class EnityDaoImplSubstitution extends EntityDaoImpl<Substitution> implements SubsDao {
    public EnityDaoImplSubstitution() {
        super(Substitution.class, HibernateUtil.getEntityManager());
    }
}
