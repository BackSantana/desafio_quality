package com.meli_play.desafio_quality.service;

import com.meli_play.desafio_quality.exception.NotFoundException;
import com.meli_play.desafio_quality.models.Property;
import com.meli_play.desafio_quality.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PropertyService {
    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    RoomService roomService;

    public void add(Property property){
        roomService.setValuesSquareMeter(property.getRoomLists());
        propertyRepository.save(property);
    }

    public Property getById(Long id){
        return propertyRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("[ %s ] id not found", id)));
    }

    public double calculateTotalPropertyM2(Property property){
        return CalculateTotalPropertyM2.calulateTotalPropertyM2(property.getRoomLists());
    }

    public BigDecimal valueProperty(Property property){
        double sum = CalculateTotalPropertyM2.calulateTotalPropertyM2(property.getRoomLists());
        return BigDecimal.valueOf(sum).multiply(property.getDistrict().getValueDistrictM2());
    }
}
