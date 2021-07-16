package com.meli_play.desafio_quality.service;

import com.meli_play.desafio_quality.models.Room;

import java.util.List;

public class CalculateTotalPropertyM2 {

    public static double calulateTotalPropertyM2(List<Room> roomList){
        return roomList.stream().mapToDouble(CalculateTotalPropertyM2::calculateM2ByRoom).sum();
     }

    public static double calculateM2ByRoom(Room room){
        return room.getRoomLength() * room.getRoomWidth();
    }
}
