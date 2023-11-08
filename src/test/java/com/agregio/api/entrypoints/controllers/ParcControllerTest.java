package com.agregio.api.entrypoints.controllers;

import com.agregio.api.configuration.UseCaseTestConfiguration;
import com.agregio.api.core.Marche;
import com.agregio.api.core.TypeParc;
import com.agregio.api.entrypoints.in.CreerParcIn;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(UseCaseTestConfiguration.class)
@WebMvcTest(ParcController.class)
class ParcControllerTest {
    private static final JsonMapper MAPPER = new JsonMapper();

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldCreateProducer() throws Exception {
        CreerParcIn parcIn = new CreerParcIn("Parc1", TypeParc.EOLIEN, 1000);
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/parcs")
                .content(MAPPER.writeValueAsString(parcIn))
                .contentType("application/json")
                .accept("application/json"));
        result.andExpect(status().isCreated());
    }

    @Test
    void shouldListProducersForGivenMarket() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/parcs/{marche}", Marche.RAPIDE.name())
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isOk());
    }

}