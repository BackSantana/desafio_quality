package com.meli_play.desafio_quality.controllers;

import com.meli_play.desafio_quality.dto.BiggestRoomDTO;
import com.meli_play.desafio_quality.dto.PropertyCalculations;
import com.meli_play.desafio_quality.dto.PropertyDTO;
import com.meli_play.desafio_quality.models.Property;
import com.meli_play.desafio_quality.service.PropertyService;
import com.meli_play.desafio_quality.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @Autowired
    PropertyService propertyService;

    @GetMapping("/largest/{propertyId}")
    public ResponseEntity<PropertyDTO> largestRoom(@PathVariable Long propertyId){
        Property property = propertyService.getById(propertyId);
        BiggestRoomDTO biggestRoomDTO = BiggestRoomDTO.toDTO(roomService.biggestRoom(property), roomService.biggestRoomValue(property));
        PropertyCalculations propertyCalculations = new PropertyCalculations();
        propertyCalculations.setBiggestRoom(biggestRoomDTO);
        return ResponseEntity.ok(PropertyDTO.toDTO(property, propertyCalculations));
    }
}
