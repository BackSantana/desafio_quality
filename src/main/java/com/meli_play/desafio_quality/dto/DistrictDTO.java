package com.meli_play.desafio_quality.dto;

import com.meli_play.desafio_quality.models.District;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DistrictDTO {
    private String districtName;
    private BigDecimal valueDistrictM2;

    public DistrictDTO(String districtName, BigDecimal valueDistrictM2) {
        this.districtName = districtName;
        this.valueDistrictM2 = valueDistrictM2;
    }

    public static DistrictDTO toDTO(District district){
        return new DistrictDTO(district.getDistrictName(), district.getValueDistrictM2());
    }
}
