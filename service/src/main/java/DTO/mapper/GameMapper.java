package DTO.mapper;

import DTO.GameDTO;
import footballclub.entity.Game;

public class GameMapper {
    public static GameDTO mapFrom(Game game) {
        return new GameDTO(game.getGame_id(), game.getGame_date(),
                game.getOpponent_name(), game.getResult(),game.getGoal_score(),
                game.getGoals_conceded(),game.getYellow_card_score(), game.getRed_card_score());
    }
}