package com.meli_play.desafio_quality.dto;

import com.meli_play.desafio_quality.models.Room;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoomDTO {
    private String roomName;
    private double roomWidth;
    private double roomLength;

    public RoomDTO(String roomName, double roomWidth, double roomLength) {
        this.roomName = roomName;
        this.roomWidth = roomWidth;
        this.roomLength = roomLength;
    }

    public static List<RoomDTO> toDTO(List<Room> roomList){
        List<RoomDTO> roomDTOList = new ArrayList<>();
        roomList.forEach(room -> roomDTOList.add(new RoomDTO(
                        room.getRoomName(),
                        room.getRoomWidth(),
                        room.getRoomLength())));
        return roomDTOList;
    }
}
