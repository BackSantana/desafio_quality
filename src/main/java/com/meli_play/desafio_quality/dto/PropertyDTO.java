package com.meli_play.desafio_quality.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meli_play.desafio_quality.models.Property;
import lombok.Data;

import java.util.List;

@Data
public class PropertyDTO {
    private Long id;
    private String nome;
    private DistrictDTO district;
    private List<RoomDTO> roomLists;
    private PropertyCalculations propertyCalculations;

    public PropertyDTO(Long id, String nome, DistrictDTO district, List<RoomDTO> roomLists, PropertyCalculations propertyCalculations) {
        this.id = id;
        this.nome = nome;
        this.district = district;
        this.roomLists = roomLists;
        this.propertyCalculations = propertyCalculations;
    }

    public static PropertyDTO toDTO(Property property, PropertyCalculations propertyCalculations){
        return new PropertyDTO(
                property.getId(),
                property.getNome(),
                DistrictDTO.toDTO(property.getDistrict()),
                RoomDTO.toDTO(property.getRoomLists()),
                propertyCalculations);
    }
}
