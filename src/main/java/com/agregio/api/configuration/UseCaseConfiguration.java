package com.agregio.api.configuration;

import com.agregio.api.core.ports.OffreRepository;
import com.agregio.api.core.ports.ParcRepository;
import com.agregio.api.core.usecases.CreerOffreUseCase;
import com.agregio.api.core.usecases.CreerParcUseCase;
import com.agregio.api.core.usecases.ListerOffresUseCase;
import com.agregio.api.core.usecases.ListerParcsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public CreerOffreUseCase getCreerOffreUseCase(OffreRepository offreRepository) {
        return new CreerOffreUseCase(offreRepository);
    }

    @Bean
    public ListerOffresUseCase getListerOffresUseCase(OffreRepository offreRepository) {
        return new ListerOffresUseCase(offreRepository);
    }

    @Bean
    public CreerParcUseCase getCreerParcUseCase(ParcRepository parcRepository) {
        return new CreerParcUseCase(parcRepository);
    }

    @Bean
    public ListerParcsUseCase getListerParcsUseCase(ParcRepository parcRepository) {
        return new ListerParcsUseCase(parcRepository);
    }

}
