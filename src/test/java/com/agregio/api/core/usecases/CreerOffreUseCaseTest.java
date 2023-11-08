package com.agregio.api.core.usecases;

import com.agregio.api.core.Marche;
import com.agregio.api.core.model.BlocHoraire;
import com.agregio.api.core.model.Offre;
import com.agregio.api.core.ports.OffreRepository;
import com.agregio.api.entrypoints.in.CreerOffreIn;
import com.agregio.api.inmemory.InMemoryOffreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CreerOffreUseCaseTest {

    private UUID id;
    private String nom;
    private List<BlocHoraire> blocHoraires;

    @BeforeEach
    void setUp() {
        id = UUID.fromString("1dd47159-6e86-422a-bc6b-fdc51cfd9af4");
        nom = "Offre1";
        blocHoraires = List.of(new BlocHoraire(1L, 0, 3, 1000, 500));
    }

    @Test
    void shouldCreateOffre() {
        // Given
        Map<String, Offre> dataSource = new HashMap<>();
        CreerOffreIn offreIn = buildOffreIn();
        Offre expectedOffre = new Offre(id, nom, Marche.PRIMAIRE, blocHoraires, null);
        CreerOffreUseCase creerOffreUseCase = buildOffreUseCase(dataSource);
        // When
        creerOffreUseCase.execute(offreIn);
        //Then
        assertThat(dataSource.get(nom)).usingRecursiveComparison().ignoringFields("id").isEqualTo(expectedOffre);
    }

    private CreerOffreIn buildOffreIn() {
        List<BlocHoraire> blocHoraires = List.of(new BlocHoraire(1L, 0, 3, 1000, 500));
        return new CreerOffreIn("Offre1", Marche.PRIMAIRE, blocHoraires);
    }

    private CreerOffreUseCase buildOffreUseCase(Map<String, Offre> dataSource) {
        OffreRepository offreRepository = new InMemoryOffreRepository(dataSource);
        return new CreerOffreUseCase(offreRepository);
    }
}