package managment.interfaces;

import DTO.ResultDTO;
import footballclub.entity.Result;
import footballclub.entity.Team;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface ResultService {
    /**
     * Create game
     */
    Result createResult(Team team, String opponentTeam) throws SQLException;

    Set<Result> showAllResultTeamInfo(Integer id);

    void deleteResult(Integer id) throws SQLException;

    void updateResult(Integer id,
                      String opponentTeam) throws SQLException;

    Result findResultById(Integer id) throws SQLException;

    List<ResultDTO> findAll();

}
