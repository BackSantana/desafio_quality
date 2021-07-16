package com.meli_play.desafio_quality.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class PropertyCalculations {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double totalM2;

}
