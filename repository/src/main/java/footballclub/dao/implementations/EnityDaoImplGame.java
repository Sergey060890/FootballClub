package footballclub.dao.implementations;

import footballclub.dao.interfaces.GameDao;
import footballclub.entity.Game;
import footballclub.util.HibernateUtil;

public class EnityDaoImplGame extends EntityDaoImpl<Game> implements GameDao {
    public EnityDaoImplGame() {
        super(Game.class, HibernateUtil.getEntityManager());
    }
}
