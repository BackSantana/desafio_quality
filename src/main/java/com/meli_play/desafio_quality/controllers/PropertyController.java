package com.meli_play.desafio_quality.controllers;

import com.meli_play.desafio_quality.dto.BiggestRoomDTO;
import com.meli_play.desafio_quality.dto.PropertyCalculations;
import com.meli_play.desafio_quality.dto.PropertyDTO;
import com.meli_play.desafio_quality.forms.PropertyForm;
import com.meli_play.desafio_quality.models.District;
import com.meli_play.desafio_quality.models.Property;
import com.meli_play.desafio_quality.service.DistrictService;
import com.meli_play.desafio_quality.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.meli_play.desafio_quality.service.PropertyService;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/property")
public class PropertyController {
    @Autowired
    PropertyService propertyService;

    @Autowired
    DistrictService districtService;

    @Autowired
    RoomService roomService;

    @PostMapping("/add")
    public ResponseEntity addProperty(@RequestBody @Valid PropertyForm homeForm, UriComponentsBuilder uriComponentsBuilder){
        District district = districtService.getDistrict(homeForm.getDiscrictId());
        Property property = PropertyForm.toModel(homeForm, district);
        propertyService.add(property);
        URI uri = uriComponentsBuilder.path("/api/addProperty/{id}").buildAndExpand(property.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/getProperty/{propertyId}")
    public ResponseEntity getProperty(@PathVariable Long propertyId){
        return ResponseEntity.ok(propertyService.getById(propertyId));
    }

    @GetMapping("/calculateM2/{propertyId}")
    public ResponseEntity<PropertyDTO> calculatePropertyM2(@PathVariable Long propertyId){
        Property property = propertyService.getById(propertyId);
        double sum = propertyService.calculateTotalPropertyM2(property);
        PropertyCalculations propertyCalculations = new PropertyCalculations();
        propertyCalculations.setTotalM2(sum);
        return ResponseEntity.ok(PropertyDTO.toDTO(property, propertyCalculations));
    }

    @GetMapping("/calculateValue/{propertyId}")
    public ResponseEntity<PropertyDTO> calculateValueProperty(@PathVariable Long propertyId){
        Property property = propertyService.getById(propertyId);
        PropertyCalculations propertyCalculations = new PropertyCalculations();
        propertyCalculations.setValue_property_m2(propertyService.valueProperty(property));
        return ResponseEntity.ok(PropertyDTO.toDTO(property,propertyCalculations));
    }

    @GetMapping("/calculateAll/{propertyId}")
    public ResponseEntity<PropertyDTO> calculateAllProperty(@PathVariable Long propertyId){
        Property property = propertyService.getById(propertyId);
        roomService.setValuesSquareMeter(property.getRoomLists());

        PropertyCalculations propertyCalculations = new PropertyCalculations();
        BiggestRoomDTO biggestRoomDTO = BiggestRoomDTO.toDTO(roomService.biggestRoom(property));

        propertyCalculations.setValue_property_m2(propertyService.valueProperty(property));
        propertyCalculations.setBiggestRoom(biggestRoomDTO);
        propertyCalculations.setTotalM2(propertyService.calculateTotalPropertyM2(property));

        return ResponseEntity.ok(PropertyDTO.toDTOAll(property, propertyCalculations));
    }
}
