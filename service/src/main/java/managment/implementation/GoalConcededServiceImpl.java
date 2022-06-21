package managment.implementation;

import footballclub.dao.implementations.EnityDaoImplGoalConceded;
import footballclub.entity.GoalConceded;
import managment.interfaces.GoalConcededService;

import java.util.List;

public class GoalConcededServiceImpl implements GoalConcededService {
    EnityDaoImplGoalConceded goalConceded = new EnityDaoImplGoalConceded();
    @Override
    public List<GoalConceded> showAllGoalConcededInfo() {
        List<GoalConceded> goalConcededs = goalConceded.findAll();
        return goalConcededs;
    }
}
