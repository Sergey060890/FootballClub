package DTO;

import footballclub.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GamePlayersDTO implements Serializable {
    private Integer id;
    private LocalDate game_date;
    private String opponent_name;
    private String result;
    private Integer goal_score;
    private Integer goals_conceded;
    private Set<Player> players;
}
