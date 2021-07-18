package com.meli_play.desafio_quality.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String districtName;
    private BigDecimal valueDistrictM2;

    public District(String districtName, BigDecimal valueDistrictM2) {
        this.districtName = districtName;
        this.valueDistrictM2 = valueDistrictM2;
    }
}
