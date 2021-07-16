package com.meli_play.desafio_quality.controllers;

import com.meli_play.desafio_quality.dto.PropertyCalculations;
import com.meli_play.desafio_quality.dto.PropertyDTO;
import com.meli_play.desafio_quality.forms.PropertyForm;
import com.meli_play.desafio_quality.models.District;
import com.meli_play.desafio_quality.models.Property;
import com.meli_play.desafio_quality.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.meli_play.desafio_quality.service.PropertyService;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class PropertyController {
    @Autowired
    PropertyService propertyService;

    @Autowired
    DistrictService districtService;

    @PostMapping("/addProperty")
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

    @GetMapping("/calculatePropertyM2/{propertyId}")
    public ResponseEntity<PropertyDTO> calculatePropertyM2(@PathVariable Long propertyId){
        double sum = propertyService.calculateTotalPropertyM2(propertyService.getById(propertyId));
        PropertyCalculations propertyCalculations = new PropertyCalculations();
        propertyCalculations.setTotalM2(sum);
        PropertyDTO propertyDTO =  PropertyDTO.toDTO(propertyService.getById(propertyId), propertyCalculations);
        return ResponseEntity.ok(propertyDTO);
    }
}
