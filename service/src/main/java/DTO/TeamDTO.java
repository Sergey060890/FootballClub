package DTO;

import footballclub.entity.Game;
import footballclub.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamDTO implements Serializable {
    private Integer team_id;
    private String team_name;
    private String city;
    private String country;
    private String stadium;
    private String coach;
    private Set<Player> players;
    private Set<Game> games;

//    public TeamDTO(Team team) {
//        this.team_id = team.getTeam_id();
//        this.team_name = team.getTeam_name();
//        this.city = team.getCity();
//        this.country = team.getCountry();
//        this.stadium = team.getStadium();
//        this.coach = team.getCoach();
//    }

}
