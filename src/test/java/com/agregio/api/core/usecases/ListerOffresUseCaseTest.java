package com.agregio.api.core.usecases;

import com.agregio.api.core.Marche;
import com.agregio.api.core.TypeParc;
import com.agregio.api.core.model.BlocHoraire;
import com.agregio.api.core.model.Offre;
import com.agregio.api.core.model.Parc;
import com.agregio.api.core.ports.OffreRepository;
import com.agregio.api.inmemory.InMemoryOffreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class ListerOffresUseCaseTest {


    private Map<String, Offre> dataSource;

    @BeforeEach
    void setUp() {
        List<BlocHoraire> blocHoraires = List.of(new BlocHoraire(1L, 2, 3, 4, 5));
        List<Parc> parcs = List.of(new Parc(UUID.randomUUID(), "Parc1", TypeParc.EOLIEN, 1000));
        dataSource = new HashMap<>();
        dataSource.put("Offre1", new Offre(UUID.randomUUID(), "Offre1", Marche.PRIMAIRE, blocHoraires, parcs));
        dataSource.put("Offre2", new Offre(UUID.randomUUID(), "Offre2", Marche.SECONDAIRE, blocHoraires, parcs));
        dataSource.put("Offre3", new Offre(UUID.randomUUID(), "Offre3", Marche.PRIMAIRE, blocHoraires, parcs));
    }

    @Test
    void shoulListOffersWithGivenMarket() {
        // Given
        ListerOffresUseCase listerOffresUseCase = buildListerOffresUseCase(dataSource);
        // When
        List<Offre> offres = listerOffresUseCase.execute(Marche.PRIMAIRE);
        // Then
        assertThat(offres).hasSize(2);
    }

    private ListerOffresUseCase buildListerOffresUseCase(Map<String, Offre> dataSource) {
        OffreRepository offreRepository = new InMemoryOffreRepository(dataSource);
        return new ListerOffresUseCase(offreRepository);
    }

}

