package DTO.mapper;

import DTO.PlayerDTO;
import footballclub.entity.Player;

public class PlayerMapper {
    public static PlayerDTO mapFrom(Player player) {
        return new PlayerDTO(player.getPlayer_id(), player.getPlayer_name(),
                player.getPlayer_surname(), player.getCountry(),player.getAge(),
                player.getPosition());
    }
}
