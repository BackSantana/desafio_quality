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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PropertyCalculations propertyCalculations;

    public PropertyDTO(Long id, String nome, DistrictDTO district, List<RoomDTO> roomLists, PropertyCalculations propertyCalculations) {
        this.id = id;
        this.nome = nome;
        this.district = district;
        this.roomLists = roomLists;
        this.propertyCalculations = propertyCalculations;
    }

    public PropertyDTO(Long id, String nome, DistrictDTO district, List<RoomDTO> roomLists) {
        this.id = id;
        this.nome = nome;
        this.district = district;
        this.roomLists = roomLists;
    }

    public static PropertyDTO toDTO(Property property, PropertyCalculations propertyCalculations){
        return new PropertyDTO(
                property.getId(),
                property.getNome(),
                DistrictDTO.toDTO(property.getDistrict()),
                RoomDTO.toDTO(property.getRoomLists()),
                propertyCalculations);
    }

    public static PropertyDTO toDTOAll(Property property, PropertyCalculations propertyCalculations){
        return new PropertyDTO(
                property.getId(),
                property.getNome(),
                DistrictDTO.toDTO(property.getDistrict()),
                RoomDTO.toDTOM2Room(property.getRoomLists()),
                propertyCalculations);
    }

    public static PropertyDTO toDTOM2Room(Property property){
        return new PropertyDTO(
                property.getId(),
                property.getNome(),
                DistrictDTO.toDTO(property.getDistrict()),
                RoomDTO.toDTOM2Room(property.getRoomLists()));
    }
}
