package com.meli_play.desafio_quality.controllers;

import com.meli_play.desafio_quality.forms.DiscrictForm;
import com.meli_play.desafio_quality.models.District;
import com.meli_play.desafio_quality.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/discrict")
public class DistrictController {

    @Autowired
    DistrictService districtService;

    @PostMapping("/add")
    public ResponseEntity addDistrict(@RequestBody @Valid DiscrictForm discrictForm, UriComponentsBuilder uriComponentsBuilder){
        District district = DiscrictForm.toModel(discrictForm);
        districtService.addDistrict(district);
        URI uri = uriComponentsBuilder.path("/api/discrict/add/{id}").buildAndExpand(district.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
