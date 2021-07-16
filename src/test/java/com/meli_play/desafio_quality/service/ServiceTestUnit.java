package com.meli_play.desafio_quality.service;

import com.meli_play.desafio_quality.models.District;
import com.meli_play.desafio_quality.models.Property;
import com.meli_play.desafio_quality.models.Room;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ServiceTestUnit {

    @Autowired
    PropertyService propertyService = new PropertyService();

    @Autowired
    RoomService roomService = new RoomService();

    private District district;
    private List<Room> roomList = new ArrayList<>();
    private Property property;

    @BeforeEach
    public void init() {
        Room room1 = new Room("Quator", 10.0, 10.0);
        Room room2 = new Room("Sala", 15.0, 10.0);
        Room room3 = new Room("Cozinha", 15.0, 5.0);
        Room room4 = new Room("Lavanderia", 4.0, 5.0);
        roomList.addAll(Arrays.asList(room1, room2, room3, room4));

        this.district = new District("Bela Vista", BigDecimal.valueOf(5000.00));
        this.property = new Property("Casa do Carlos", district, roomList);
        roomService.setValuesSquareMeter(property.getRoomLists());
    }

    @Test
    public void deveCalcularTotalM2(){
        init();
        double m2Total = 345.0;
        double propertyM2 = propertyService.calculateTotalPropertyM2(property);

        Assertions.assertEquals(m2Total, propertyM2);
    }

    @Test
    public void deveCalcularValorDaPropriedade(){
        init();
        BigDecimal valorPropriedade = BigDecimal.valueOf(345.0).multiply(district.getValueDistrictM2());

        Assertions.assertEquals(valorPropriedade, propertyService.valueProperty(property));
    }

    @Test
    public void deveRetornarOMaiorComodo(){
        init();
        double maiorComodo = 15.0 * 10.0;

        Assertions.assertEquals(maiorComodo, roomService.biggestRoom(property).getSquareMeter());
    }

    @Test
    public void deveCalcularM2Comodo(){
        init();
        double m2Comodo = 4.0 * 5.0;
        double comodo = property.getRoomLists().get(3).getSquareMeter();

        Assertions.assertEquals(m2Comodo, comodo);
    }
}
