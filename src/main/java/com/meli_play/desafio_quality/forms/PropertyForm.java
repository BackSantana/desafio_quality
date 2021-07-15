package com.meli_play.desafio_quality.forms;

import com.meli_play.desafio_quality.models.District;
import com.meli_play.desafio_quality.models.Property;
import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class PropertyForm {
    @NotBlank(message = "O nome da propriedade nao pode estar vazio.")
    @Size(max = 30, message = "O comprimento do nome nao pode exceder 30 caracteres.")
    @Pattern(regexp = "^[A-Z][A-Za-z ]*$" , message = "O nome da propriedade deve comecar com uma letra maiuscula.")
    private String homeName;
    private Long discrictId;
    @Valid
    private List<RoomForm> roomList;

    public static Property toModel(PropertyForm propertyForm, District district){
        return new Property(
                propertyForm.getHomeName(),
                district,
                RoomForm.toModel(propertyForm.getRoomList()));
    }
}
