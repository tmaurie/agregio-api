package com.agregio.api.core.usecases;

import com.agregio.api.core.Marche;
import com.agregio.api.core.TypeParc;
import com.agregio.api.core.model.Offre;
import com.agregio.api.core.model.Parc;
import com.agregio.api.core.ports.OffreRepository;
import com.agregio.api.core.ports.ParcRepository;
import com.agregio.api.inmemory.InMemoryParcRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListerParcsUseCaseTest {


    @Mock
    private OffreRepository ofrreRepository;
    private Map<String, Object> dataSource;

    private Offre offre;
    @BeforeEach
    void setUp() {
        dataSource = new HashMap<>();
        dataSource.put("Parc1", new Parc(UUID.randomUUID(), "Parc1", TypeParc.EOLIEN, 1000));
        dataSource.put("Parc2", new Parc(UUID.randomUUID(), "Parc2", TypeParc.EOLIEN, 1000));
        dataSource.put("Parc3", new Parc(UUID.randomUUID(), "Parc3", TypeParc.EOLIEN, 1000));
        offre = new Offre(UUID.randomUUID(), "Offre1", Marche.PRIMAIRE, List.of(), List.of(new Parc(UUID.randomUUID(), "Parc1", TypeParc.EOLIEN, 1000)));
    }

    @Test
    void shoulListOffersWithGivenMarket() {
        // Given
        ListerParcsUseCase listerParcsUseCase = buildListerParcUseCase(dataSource, ofrreRepository);
        // When
        when(ofrreRepository.listeOffreParMarche(Marche.PRIMAIRE)).thenReturn(List.of(offre));
        List<Parc> offres = listerParcsUseCase.execute(Marche.PRIMAIRE);
        // Then
        assertThat(offres).hasSize(1);
    }

    private ListerParcsUseCase buildListerParcUseCase(Map<String, Object> dataSource, OffreRepository offreRepository) {
        ParcRepository parcRepository = new InMemoryParcRepository(dataSource, offreRepository);
        return new ListerParcsUseCase(parcRepository);
    }

}