package com.meli_play.desafio_quality.forms;

import com.meli_play.desafio_quality.models.District;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class DiscrictForm {
    @NotBlank(message = "O nome do bairro nao pode estar vazio.")
    @NotEmpty(message = "O nome do bairro nao pode estar vazio.")
    @Size(max = 45, message = "O comprimento do bairro nao pode exceder 45 caracteres.")
    private String districtName;

    @NotNull(message = "O metro quadrado nao pode estar vazio.")
    @Digits(integer = 13, fraction = 13)
    private BigDecimal valueDistrictM2;

    public static District toModel(DiscrictForm discrictForm){
        return new District(discrictForm.getDistrictName(), discrictForm.getValueDistrictM2());
    }
}
