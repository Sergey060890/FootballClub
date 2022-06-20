package footballclub.dao.implementations;

import footballclub.dao.interfaces.ResultDao;
import footballclub.entity.Result;
import footballclub.util.HibernateUtil;

public class EntityDaoImplResult extends EntityDaoImpl<Result> implements ResultDao {
    public EntityDaoImplResult() {
        super(Result.class, HibernateUtil.getEntityManager());
    }
}
