package com.meli_play.desafio_quality.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PropertyCalculations {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double totalM2;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal value_district_m2;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BiggestRoomDTO biggestRoom;
}
