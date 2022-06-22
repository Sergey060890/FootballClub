package managment.implementation;

import dto.ResultDTO;
import dto.mapper.ResultMapper;
import footballclub.dao.implementations.EntityDaoImplResult;
import footballclub.entity.Result;
import footballclub.entity.Team;
import managment.interfaces.ResultService;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ResultServiceImpl implements ResultService {
    EntityDaoImplResult implResult = new EntityDaoImplResult();

    @Override
    public Result createResult(Team team, String opponentTeam) throws SQLException {
        Result result = Result.builder()
                .teamGame(team)
                .opponent_name(opponentTeam)
                .build();
        implResult.create(result);
        return result;
    }

    @Override
    public Set<Result> showAllResultTeamInfo(Integer id) {
        Set<Result> results = new HashSet<>();
        for (Result result : implResult.findAll()
        ) {
            if (result.getTeamGame().getTeam_id() == id) {
                results.add(result);
            }
        }
        return results;
    }

    @Override
    public void deleteResult(Integer id) throws SQLException {
        implResult.deleteById(id);
    }

    @Override
    public void updateResult(Integer id, String opponentTeam) throws SQLException {
        Result result = implResult.findOne(id);
        result.setOpponent_name(opponentTeam);
        implResult.update(result);
    }

    @Override
    public Result findResultById(Integer id) throws SQLException {
        return implResult.findOne(id);
    }

    @Override
    public List<ResultDTO> findAll() {
        return implResult.findAll()
                .stream()
                .map(ResultMapper::mapFrom)
                .collect(Collectors.toList());
    }
}
