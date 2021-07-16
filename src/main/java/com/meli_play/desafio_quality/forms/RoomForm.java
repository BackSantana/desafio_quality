package com.meli_play.desafio_quality.forms;

import com.meli_play.desafio_quality.models.Room;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class RoomForm {
    @NotNull(message = "can not be null")
    @NotBlank(message = "O nome do bairro nao pode estar vazio.")
    @NotEmpty(message = "O nome do bairro nao pode estar vazio.")
    @Size(max = 30, message = "O comprimento do bairro nao pode exceder 45 caracteres.")
    @Pattern(regexp = "^[A-Z][A-Za-z ]*$" , message = "O nome da propriedade deve comecar com uma letra maiuscula.")
    private String roomName;

    @NotNull(message = "can not be null")
    @Min(value = 1, message = "A largura minimo permitida por comodo é de 1 metros")
    @Max(value = 23, message = "A largura maxima permitida por comodo é de 23 metros.")
    private double roomWidth;

    @NotNull(message = "can not be null")
    @Min(value = 1, message = "O comprimento minimo permitida por comodo é de 1 metros")
    @Max(value = 33, message = "O comprimento maxima permitida por comodo é de 33 metros.")
    private double roomLength;

    public static List<Room> toModel(List<RoomForm> roomForm){
        List<Room> roomList = new ArrayList<>();
        roomForm.forEach( r -> roomList.add(new Room(r.getRoomName(), r.getRoomWidth(), r.getRoomLength())));
        return roomList;
    }
}
