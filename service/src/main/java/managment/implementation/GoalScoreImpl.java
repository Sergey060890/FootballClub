package managment.implementation;

import footballclub.dao.implementations.EnityDaoImplGoalScore;
import footballclub.entity.GoalScore;
import managment.interfaces.GoalScoreService;

import java.util.List;

public class GoalScoreImpl implements GoalScoreService {
    EnityDaoImplGoalScore goalScore = new EnityDaoImplGoalScore();
    @Override
    public List<GoalScore> showAllGoalInfo() {
        List<GoalScore> goalScores = goalScore.findAll();
        return goalScores;
    }
}
