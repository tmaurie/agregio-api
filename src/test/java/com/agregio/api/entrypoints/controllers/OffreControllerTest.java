package com.agregio.api.entrypoints.controllers;

import com.agregio.api.configuration.UseCaseTestConfiguration;
import com.agregio.api.core.Marche;
import com.agregio.api.core.model.BlocHoraire;
import com.agregio.api.entrypoints.in.CreerOffreIn;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(UseCaseTestConfiguration.class)
@WebMvcTest(OffreController.class)
class OffreControllerTest {

    private static final JsonMapper MAPPER = new JsonMapper();

    @Autowired
    MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }


    @Test
    void shouldCreateOffer() throws Exception {
        List<BlocHoraire> blocHoraires = List.of(new BlocHoraire(1L, 0, 3, 1000, 500));
        CreerOffreIn offreIn = new CreerOffreIn("Offre1", Marche.PRIMAIRE, blocHoraires);
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/offres")
                .content(MAPPER.writeValueAsString(offreIn))
                .contentType("application/json")
                .accept("application/json"));
        result.andExpect(status().isCreated());
    }

    @Test
    void shouldListOffersForGivenMarket() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/offres/{marche}", Marche.PRIMAIRE.name())
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .isOk());
    }
}