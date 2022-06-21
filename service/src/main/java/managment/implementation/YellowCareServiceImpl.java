package managment.implementation;

import footballclub.dao.implementations.EnityDaoImplYellowCard;
import footballclub.entity.YellowCard;
import managment.interfaces.YellowCardService;

import java.util.List;

public class YellowCareServiceImpl implements YellowCardService {
    EnityDaoImplYellowCard enityDaoImplYellowCard
            = new EnityDaoImplYellowCard();
    @Override
    public List<YellowCard> showAllYellowCardInfo() {
        List<YellowCard> yellowCards = enityDaoImplYellowCard.findAll();
        return yellowCards;
    }
}
