package com.agregio.api.core.usecases;

import com.agregio.api.core.TypeParc;
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
        Map<String, Object> dataSource = new HashMap<>();
        CreerParcIn parcIn = buildParcIn();
        Parc expectedParc = new Parc(uuid, nom, TypeParc.EOLIEN, 1000);
        CreerParcUseCase creerParcUseCase = buildParcUseCase(dataSource);
        // When
        creerParcUseCase.execute(parcIn);
        //Then
        assertThat(dataSource.get(nom)).usingRecursiveComparison().ignoringFields("id").isEqualTo(expectedParc);
    }


    private CreerParcIn buildParcIn() {
        return new CreerParcIn("Parc1", TypeParc.EOLIEN, 1000);
    }

    private CreerParcUseCase buildParcUseCase(Map<String, Object> dataSource) {
        OffreRepository offreRepository = new InMemoryOffreRepository(dataSource);
        ParcRepository parcRepository = new InMemoryParcRepository(dataSource, offreRepository);
        return new CreerParcUseCase(parcRepository);
    }

}