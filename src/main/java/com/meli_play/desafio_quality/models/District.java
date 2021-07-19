package com.meli_play.desafio_quality.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return Objects.equals(districtName, district.districtName) && Objects.equals(valueDistrictM2, district.valueDistrictM2);
    }
}
