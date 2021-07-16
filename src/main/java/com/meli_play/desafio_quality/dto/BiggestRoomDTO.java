package com.meli_play.desafio_quality.dto;

import com.meli_play.desafio_quality.models.Room;
import lombok.Data;

@Data
public class BiggestRoomDTO {
    private String roomName;
    private double roomWidth;
    private double roomLength;
    private double squareMeter;

    public BiggestRoomDTO(String roomName, double roomWidth, double roomLength, double squareMeter) {
        this.roomName = roomName;
        this.roomWidth = roomWidth;
        this.roomLength = roomLength;
        this.squareMeter = squareMeter;
    }

    public static BiggestRoomDTO toDTO(Room room, Double squareMeter){
        return new BiggestRoomDTO(room.getRoomName(), room.getRoomWidth(), room.getRoomLength(), squareMeter);
    }
}
