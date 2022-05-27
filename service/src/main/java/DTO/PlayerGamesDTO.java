package DTO;

import footballclub.entity.Game;
import footballclub.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlayerGamesDTO implements Serializable {
    private Integer player_id;
    private String player_name;
    private String player_surname;
    private Team team;
    private Set<Game> games;
}
