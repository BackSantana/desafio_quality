package com.meli_play.desafio_quality.service;

import com.meli_play.desafio_quality.models.Property;
import com.meli_play.desafio_quality.models.Room;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RoomService {

    public Room biggestRoom(Property property){
        List<Room> roomList = property.getRoomLists();
        setValuesSquareMeter(roomList);
        Comparator<Room> comparator = Comparator.comparing(Room::getSquareMeter);

        return roomList.stream().max(comparator).get();
     }

     public void setValuesSquareMeter(List<Room> roomList){
         roomList.forEach(room -> room.setSquareMeter(CalculateTotalPropertyM2.calculateM2ByRoom(room)));
     }
}
