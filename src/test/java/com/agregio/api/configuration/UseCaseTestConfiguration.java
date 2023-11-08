package com.agregio.api.configuration;

import com.agregio.api.core.Marche;
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
import java.util.Map;
import java.util.UUID;

@Configuration
public class UseCaseTestConfiguration {

    private final Map<String, Offre> offres = new HashMap<>();
    private final Map<String, Parc> parcs = new HashMap<>();

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
        UUID uuid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
        offres.put("Offre1", new Offre(uuid, "Offre1", Marche.PRIMAIRE, null, null));
        return new ListerOffresUseCase(
                new InMemoryOffreRepository(offres)
        );
    }

    @Bean
    public ListerParcsUseCase listerParcsUseCase() {
        UUID uuid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
        offres.put("Offre1", new Offre(uuid, "Offre1", Marche.PRIMAIRE, null, null));
        return new ListerParcsUseCase(
                new InMemoryParcRepository(parcs, new InMemoryOffreRepository(offres))
        );
    }
}