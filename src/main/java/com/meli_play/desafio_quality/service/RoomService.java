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
        Comparator<Room> comparator = Comparator.comparing(room -> CalculateTotalPropertyM2.calculateM2ByRoom(room));

        return roomList.stream().max(comparator).get();
     }

     public Double biggestRoomValue(Property property){
         return property.getRoomLists()
                 .stream()
                 .mapToDouble(room -> CalculateTotalPropertyM2.calculateM2ByRoom(room))
                 .max()
                 .getAsDouble();
     }
}
