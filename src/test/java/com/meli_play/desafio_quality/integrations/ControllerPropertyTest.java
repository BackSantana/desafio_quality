package com.meli_play.desafio_quality.integrations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli_play.desafio_quality.forms.PropertyForm;
import com.meli_play.desafio_quality.forms.RoomForm;
import com.meli_play.desafio_quality.models.District;
import com.meli_play.desafio_quality.service.DistrictService;
import com.meli_play.desafio_quality.service.RoomService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
public class ControllerPropertyTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    RoomService roomService;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    DistrictService districtService;

    private District district;
    private List<RoomForm> roomList = new ArrayList<>();
    private PropertyForm property;

    public void creatProperty() {
        this.district = new District("Bela Vista", BigDecimal.valueOf(5000.00));
        districtService.addDistrict(district);

        creatListRooms();

        this.property = new PropertyForm();
        this.property.setHomeName("Casa do Carlos");
        this.property.setDiscrictId(district.getId());
        this.property.setRoomList(roomList);
     }

    private void creatListRooms(){
        RoomForm room1 = new RoomForm();
        room1.setRoomName("Quarto");
        room1.setRoomLength(10.0);
        room1.setRoomWidth(10.0);

        RoomForm room2 = new RoomForm();
        room2.setRoomName("Sala");
        room2.setRoomLength(15.0);
        room2.setRoomWidth(10.0);

        RoomForm room3 = new RoomForm();
        room3.setRoomName("Cozinha");
        room3.setRoomLength(15.0);
        room3.setRoomWidth(10.0);

        RoomForm room4 = new RoomForm();
        room4.setRoomName("Lavanderia");
        room4.setRoomLength(4.0);
        room4.setRoomWidth(5.0);

        roomList.addAll(Arrays.asList(room1, room2, room3, room4));
    }

    @Test
    public void deveCriarUmaPropriedade() throws Exception {
        creatProperty();
        String payLoad = mapper.writeValueAsString(property);

        mock.perform(post("/api/property/add")
                .contentType("application/json")
                .content(payLoad))
                .andExpect(status().isCreated());
    }
}
