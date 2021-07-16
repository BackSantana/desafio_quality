package com.meli_play.desafio_quality.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meli_play.desafio_quality.models.Room;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoomDTO {
    private String roomName;
    private double roomWidth;
    private double roomLength;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double squareMeter;

    public RoomDTO(String roomName, double roomWidth, double roomLength, double squareMeter) {
        this.roomName = roomName;
        this.roomWidth = roomWidth;
        this.roomLength = roomLength;
        this.squareMeter = squareMeter;
    }

    public static List<RoomDTO> toDTOM2Room(List<Room> roomList){
        List<RoomDTO> roomDTOList = new ArrayList<>();
        roomList.forEach(room -> roomDTOList.add(new RoomDTO(
                room.getRoomName(),
                room.getRoomWidth(),
                room.getRoomLength(),
                room.getSquareMeter())));
        return roomDTOList;
    }
}
