package com.meli_play.desafio_quality.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PropertyCalculations {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double totalM2;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal value_property_m2;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BiggestRoomDTO biggestRoom;

    public PropertyCalculations(Double totalM2, BigDecimal value_property_m2, BiggestRoomDTO biggestRoom) {
        this.totalM2 = totalM2;
        this.value_property_m2 = value_property_m2;
        this.biggestRoom = biggestRoom;
    }

    public PropertyCalculations(Double totalM2) {
        this.totalM2 = totalM2;
    }

    public PropertyCalculations(BigDecimal value_property_m2) {
        this.value_property_m2 = value_property_m2;
    }

    public PropertyCalculations(BiggestRoomDTO biggestRoom) {
        this.biggestRoom = biggestRoom;
    }
}
