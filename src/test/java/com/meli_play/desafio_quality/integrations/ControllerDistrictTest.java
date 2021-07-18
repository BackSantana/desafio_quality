package com.meli_play.desafio_quality.integrations;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli_play.desafio_quality.forms.DiscrictForm;
import com.meli_play.desafio_quality.repository.DistrictRepository;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
public class ControllerDistrictTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void deveCadastrarUmBairro() throws Exception {
        DiscrictForm districtForm =  new DiscrictForm();
        districtForm.setDistrictName("Jardim Peri");
        districtForm.setValueDistrictM2(BigDecimal.valueOf(500));

        String payLoad = mapper.writeValueAsString(districtForm);

        mock.perform(post("/api/district/add")
                .contentType("application/json")
                .content(payLoad))
                .andExpect(status().isCreated());
    }
}
