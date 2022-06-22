package managment.implementation;

import footballclub.dao.implementations.EnityDaoImplRedCard;
import footballclub.entity.RedCard;
import managment.interfaces.RedCardService;

import java.util.List;

public class RedCardServiceImpl implements RedCardService {
    EnityDaoImplRedCard enityDaoImplRedCard
            = new EnityDaoImplRedCard();
    @Override
    public List<RedCard> showAllRedCardInfo() {
        List<RedCard> redCards = enityDaoImplRedCard.findAll();
        return redCards;
    }
}
