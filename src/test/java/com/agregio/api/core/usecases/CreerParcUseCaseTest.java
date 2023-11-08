package com.agregio.api.core.usecases;

import com.agregio.api.core.TypeParc;
import com.agregio.api.core.model.Offre;
import com.agregio.api.core.model.Parc;
import com.agregio.api.core.ports.OffreRepository;
import com.agregio.api.core.ports.ParcRepository;
import com.agregio.api.entrypoints.in.CreerParcIn;
import com.agregio.api.inmemory.InMemoryOffreRepository;
import com.agregio.api.inmemory.InMemoryParcRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CreerParcUseCaseTest {


    private UUID uuid;
    private String nom;

    @BeforeEach
    void setUp() {
        uuid = UUID.fromString("1dd47159-6e86-422a-bc6b-fdc51cfd9af4");
        nom = "Parc1";
    }

    @Test
    void shouldCreateParc() {
        // Given
        Map<String, Parc> dataSourceParc = new HashMap<>();
        Map<String, Offre> dataSourceOffre = new HashMap<>();
        CreerParcIn parcIn = buildParcIn();
        Parc expectedParc = new Parc(uuid, nom, TypeParc.EOLIEN, 1000);
        CreerParcUseCase creerParcUseCase = buildParcUseCase(dataSourceParc, dataSourceOffre);
        // When
        creerParcUseCase.execute(parcIn);
        //Then
        assertThat(dataSourceParc.get(nom)).usingRecursiveComparison().ignoringFields("id").isEqualTo(expectedParc);
    }


    private CreerParcIn buildParcIn() {
        return new CreerParcIn("Parc1", TypeParc.EOLIEN, 1000);
    }

    private CreerParcUseCase buildParcUseCase(Map<String, Parc> dataSourceParc, Map<String, Offre> dataSourceOffre) {
        OffreRepository offreRepository = new InMemoryOffreRepository(dataSourceOffre);
        ParcRepository parcRepository = new InMemoryParcRepository(dataSourceParc, offreRepository);
        return new CreerParcUseCase(parcRepository);
    }

}