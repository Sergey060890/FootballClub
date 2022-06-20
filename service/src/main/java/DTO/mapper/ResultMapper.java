package DTO.mapper;

import DTO.ResultDTO;
import footballclub.entity.Result;

public class ResultMapper {
    public static ResultDTO mapFrom(Result result) {
        return new ResultDTO(result.getId(),
                result.getOpponent_name());
    }
}
