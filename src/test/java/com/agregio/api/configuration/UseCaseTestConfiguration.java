package com.agregio.api.configuration;

import com.agregio.api.core.Marche;
import com.agregio.api.core.TypeParc;
import com.agregio.api.core.model.Offre;
import com.agregio.api.core.model.Parc;
import com.agregio.api.core.usecases.CreerOffreUseCase;
import com.agregio.api.core.usecases.CreerParcUseCase;
import com.agregio.api.core.usecases.ListerOffresUseCase;
import com.agregio.api.core.usecases.ListerParcsUseCase;
import com.agregio.api.inmemory.InMemoryOffreRepository;
import com.agregio.api.inmemory.InMemoryParcRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Configuration
public class UseCaseTestConfiguration {

    private final Map<String, Offre> offresDatasource = new HashMap<>();
    private final Map<String, Parc> parcsDatasource = new HashMap<>();

    @Bean
    public CreerOffreUseCase getCreerOffreUseCase() {
        return new CreerOffreUseCase(
                new InMemoryOffreRepository(new HashMap<>())
        );
    }

    @Bean
    public CreerParcUseCase getCreerParcUseCase() {
        return new CreerParcUseCase(
                        new InMemoryParcRepository(new HashMap<>(),
                        new InMemoryOffreRepository(new HashMap<>()))
        );
    }

    @Bean
    public ListerOffresUseCase listerOffresUseCase() {
        List<Parc> parcs = List.of(
                new Parc(UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d"), "Parc1", TypeParc.EOLIEN, 1000),
                new Parc(UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d"), "Parc2", TypeParc.HYDRAULIQUE, 2000)
        );
        UUID uuid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
        offresDatasource.put("Offre1", new Offre(uuid, "Offre1", Marche.PRIMAIRE, null, parcs));
        return new ListerOffresUseCase(
                new InMemoryOffreRepository(offresDatasource)
        );
    }

    @Bean
    public ListerParcsUseCase listerParcsUseCase() {
        return new ListerParcsUseCase(
                new InMemoryParcRepository(parcsDatasource, new InMemoryOffreRepository(offresDatasource))
        );
    }
}