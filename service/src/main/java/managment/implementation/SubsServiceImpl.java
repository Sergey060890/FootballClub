package managment.implementation;

import footballclub.dao.implementations.EnityDaoImplSubstitution;
import footballclub.entity.Substitution;
import managment.interfaces.SubsService;

import java.util.List;

public class SubsServiceImpl implements SubsService {
    EnityDaoImplSubstitution enityDaoImplSubstitution
            = new EnityDaoImplSubstitution();
    @Override
    public List<Substitution> showAllSubstitutionInfo() {
        List<Substitution> substitutions = enityDaoImplSubstitution.findAll();
        return substitutions;
    }
}
