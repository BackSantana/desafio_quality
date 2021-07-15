package com.meli_play.desafio_quality.controllers;

import com.meli_play.desafio_quality.forms.DiscrictForm;
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

    @PostMapping("/addDiscrict")
    public ResponseEntity addDistrict(@RequestBody @Valid DiscrictForm discrictForm, UriComponentsBuilder uriComponentsBuilder){
        District district = DiscrictForm.toModel(discrictForm);
        districtService.addDistrict(district);
        URI uri = uriComponentsBuilder.path("/api/addDiscrict/{id}").buildAndExpand(district.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
