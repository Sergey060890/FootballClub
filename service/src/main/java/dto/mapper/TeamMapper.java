package dto.mapper;


import dto.TeamDTO;
import footballclub.entity.Team;

public class TeamMapper {

    public static TeamDTO mapFrom(Team team) {
        return new TeamDTO(team.getTeam_id(), team.getTeam_name(),
                team.getCity(), team.getCountry(), team.getStadium(), team.getCoach(),team.getPlayers(),team.getGames());
    }
}
